function Get-MailboxReport {
    <#
    .SYNOPSIS
    Get the mailbox usage report

    .DESCRIPTION
    Get the mailbox usage report

    .EXAMPLE
    Get the mailbox usage report
#>
    [CmdletBinding()]
    param(
        # It is the path where the resultant .csv file has to be saved
        [string]$FileName
    )
    BEGIN {
        $ErrorActionPreference = "Continue"
        $Today = Get-Date
    }

    PROCESS {
        (Get-Mailbox) |
        ForEach-Object {
            $MisPrimarySmtpAddress = $_.PrimarySmtpAddress
            Write-Verbose "Getting statistics for $MisPrimarySmtpAddress"
            $lic = Get-MsolUser -UserPrincipalName $MisPrimarySmtpAddress | Select-Object Licenses
            $licSku = $lic.Licenses.AccountSkuId
            Get-MailboxStatistics -Identity $MisPrimarySmtpAddress | Select-Object DisplayName, 
            @{Name = "EmailAddress"; Expression = { $MisPrimarySmtpAddress } },
            LastLogonTime, 
            @{Name = "DaysSinceLastLogon"; Expression = { ($Today - $_.LastLogonTime).Days } },
            @{Name = "License"; Expression = { $licSku } }
        } | Sort-Object -Descending -Property DaysSinceLastLogon | Export-Csv -Path $FileName
    }
    
    END {

    }
}
Function New-SharedMailbox {
    <#
    .SYNOPSIS
    Creates new shared mailbox
    .DESCRIPTION
    It Creates a new shared mailbox under the specified Domain.
    .EXAMPLE
    New-O365SharedMailbox -FirstName <firstname> -LastName <lastname> -EmailDomain <moxiesystems | genzeon> -Verbose
    #>
    [CmdletBinding()]
    Param
    (
        # It is the First Name of the Shared Mailbox
        [parameter(Mandatory = 'true')]
        [string]
        $FirstName,
        # It is the Last Name of the Shared Mailbox
        [parameter(Mandatory = 'true')]
        [string]
        $LastName,
        # It is the name of the domain in which the Shared MailBox account will be created.
        [ValidateSet('genzeon', 'moxiesystems', 'complianceprosolutions.com')]
        [parameter(Mandatory = 'true')]
        [string]
        $EmailDomain,
        # It is the email address of the user who has to be notified about the shared mailbox
        [string]
        $NotificationEmail = 'helpdesk@genzeon.com'
    )

    BEGIN {
        $ErrorActionPreference = "Stop"
    }

    PROCESS {
        # SMTP address
        $PrimarySmtpAddress = "$FirstName.$LastName@$EmailDomain.com"
        Write-Verbose "Creating shared mailbox - $PrimarySmtpAddress"
        # Genzeon - shared mailbox
        if ($EmailDomain -eq "genzeon") {
            New-Mailbox -PrimarySmtpAddress $PrimarySmtpAddress -Name "$FirstName $LastName (G)" -Shared -Alias "$FirstName.$LastName"
        }
        # Moxie - shared mailbox
        if ($EmailDomain -eq "moxiesystems") {
            New-Mailbox -PrimarySmtpAddress $PrimarySmtpAddress -Name "$FirstName $LastName (M)" -Shared -Alias "$FirstName.$LastName"
        }
        
    }

    END {
        # Email Notitification
        $subject = "New Shared Mailbox Creation"
        $body = @"
        Please find the following new mailbox.
        $PrimarySmtpAddress

        Thanks,
        Genzeon Helpdesk
"@

        Send-MailMessage -To $NotificationEmail `
            -Subject $subject -From genzeon.service@genzeon.com `
            -SmtpServer smtp.office365.com -Port 587 -Credential $ExchangeCred -UseSsl `
            -Body $body -Verbose
    }
}

function Set-MailboxPermission {
    <# 
    .Synopsis
    It is used manage permissions of a mailbox.
    .Description
    It is used to give permissions to a user for a specific mailbox.
    .Example
    Set-MailboxPermission -Mailbox <Mailbox.Name@genzeon.com> -User <Test.User@genzeon.com> -PermissionType <FullAccess | SendAs>
    #>
    [cmdletbinding()]
    param(
        # Specify the Email address of the Mailbox
        [parameter(Mandatory = 'true')]
        [string]
        $Mailbox,
        # Specify the Email address of the User that has to be given the permissions
        [parameter(Mandatory = 'true')]
        [string]
        $User,
        # Specify the type of permission - 'FullAccess' or 'SendAs'. If not specified, both permissions will be given to the specified user for the specified mailbox.
        [ValidateSet('FullAccess', 'SendAs')]
        [string]
        $PermissionType
    )
    begin {
        $ErrorActionPreference = 'Stop'
    }
    process {
        switch ($PermissionType) {
            'FullAccess' {
                Write-Verbose "Setting $PermissionType permission for the specified mailbox"
                Add-MailboxPermission -Identity $Mailbox -User $User -AccessRights FullAccess  -InheritanceType All -confirm:$false -Verbose 
            }
            'SendAs' {
                Write-Verbose "Setting $PermissionType permission for the specified mailbox"
                Add-RecipientPermission -Identity $Mailbox -Trustee $User -AccessRights SendAs -Confirm:$false -Verbose
            }
            Default {
                Write-Verbose "Setting 'FULL ACCESS' and 'SEND AS' permissions for the specified mailbox"
                Add-MailboxPermission -Identity $Mailbox -User $User -AccessRights FullAccess  -InheritanceType All -confirm:$false -Verbose 
                Add-RecipientPermission -Identity $Mailbox -Trustee $User -AccessRights SendAs -Confirm:$false -Verbose
            }
        }
    }
}
Function Update-AzureADUser {
    <#
    .SYNOPSIS
    Update Azure AD portal

    .DESCRIPTION
    Update User details

    .EXAMPLE
    Add Picture,Mobile,TelephoneNumber,Country
#>
    [CmdletBinding()]
    Param
    (
        # It is the path of the data-file "user.csv"
        [string]
        $DataFolder
    )

    Import-csv "$DataFolder\user.csv" | ForEach-Object {
        $ImageFile = join-path -Path "$DataFolder\images" -ChildPath $_.Picture
        $ReportsToUser = Get-AzureADUser -SearchString $_.Manager
        $ReportsToObjectId = $ReportsToUser.ObjectId

        Set-AzureADUser -ObjectId $_.User -JobTitle $_.JobTitle -Department $_.Department -StreetAddress $_.StreetAddress `
            -City $_.City -State $_.State -PostalCode $_.PostalCode -Country $_.Country `
            -TelephoneNumber $_.OfficePhone -PhysicalDeliveryOfficeName $_.Office
        Set-AzureADUserThumbnailPhoto -ObjectId $_.User -FilePath $ImageFile
        Set-AzureADUserManager -ObjectId $_.User -RefObjectId $ReportsToObjectId
    }
}

Function Update-CustomAttribute {
    param(
        # It is the array of users that has to be passed through Pipeline.
        [Parameter(ValueFromPipeline = $True)]
        [string[]]$All
    )
    Process {
        foreach ($user in $All) {
            Set-Mailbox -Identity $User -CustomAttribute1 "Employee"
        }
    }
}

Function Add-DistributionGroup {
    <#
    .SYNOPSIS
    Create a new genzeon distribution group

    .DESCRIPTION
    Create a new genzeon distribution group

    .EXAMPLE
    Add-DistributionGroup -DisplayName Sample -Name Sample -PrimarySmtpAddress Sample.Test@genzeon.com -Members "UsersFilePath"
#>
    [CmdletBinding()]
    Param
    (
        # It is the Dsiplay Name of the Distribution List
        [Parameter(Mandatory = $true)]
        [string]
        $DisplayName,
        # It is the name of the Distribution list
        [Parameter(Mandatory = $true)]
        [string]
        $Name,
        # It is the email address of the Distribution List
        [Parameter(Mandatory = $true)]
        [string]
        $PrimarySmtpAddress
    )

    Begin {

    }
    Process {
        New-DistributionGroup -DisplayName $DisplayName -Name $Name -PrimarySmtpAddress $PrimarySmtpAddress -Members (Get-Content)
    }
    End {
        Write-Host "New DistributionGroup Created"
    }

}
function Set-NewLicense {
    [CmdletBinding()]
    param (
        # It is the path where the .csv file containing the Email Addresses of the users is located.
        [Parameter(Mandatory = $true)]
        [string]
        $UPNFolder
    )

    begin {
        $OldLicense = "genzeon:O365_BUSINESS_PREMIUM"
        $NewLicense = "genzeon:SPE_E3"
    }

    process {
        Import-Csv "$Folder\UPN.csv" | ForEach-Object {
            Set-MsolUserLicense -UserPrincipalName $_.UPN -AddLicenses $NewLicense -RemoveLicenses $OldLicense
        }
    }

    end {

    }

}
Function Add-User {
    <#
    .SYNOPSIS
    Create a new Office 365 user

    .DESCRIPTION
    Create a new Office 365 user

    .EXAMPLE
    Import-csv -path C:\OneDrive\Desktop\OnBoardingForms\OnBoard_Corp.csv | Add-o365user
#>
    BEGIN {
        # AD User InitialPassword
        if (-not (test-path -Path 'variable:\Exchangecred')) {
            New-Variable -Name ExchangeCred -Scope Global -Visibility Public
            $ExchangeCred = Get-Credential -Message "Enter your Exchange credentials"
        }
    }
    PROCESS {
        $UserPrincipalName = $_.FirstName + '.' + $_.LastName + "@" + $_.Domain
        $DisplayName = $_.FirstName + ' ' + $_.LastName
        $NotificationEmail = $_.NotificationEmail
        $UsageLocation = $_.Country
        $MobileNumber = $_.MobilePhone
        
        if ($null -ne $UsageLocation) {
            switch ($UsageLocation) {
                'IN' {
                    $Country = 'India'
                    $MobilePhone = "+91" + " " + $MobileNumber
                }
                'US' {
                    $Country = 'United States'
                    $MobilePhone = "+1" + " " + $MobileNumber  
                }
                'PH' {
                    $Country = 'Philippines'
                    $MobilePhone = "+63" + " " + $MobileNumber
                }
            }
        }
        
        #Checking available licenses. If enterprise pack is not available it will assign premium.
        $Check = Get-MsolAccountSku | Where-Object { $_.AccountSkuId -eq "genzeon:SPE_E3" }
        $PremLicCheck = Get-MsolAccountSku | Where-Object { $_.AccountSkuId -eq "genzeon:O365_BUSINESS_PREMIUM" }
        if ($Check.ActiveUnits -ne $Check.ConsumedUnits) {
            $LicenseType = "genzeon:SPE_E3"
        }elseif($PremLicCheck.ActiveUnits -ne $PremLicCheck.ConsumedUnits) {
            $LicenseType = "genzeon:O365_BUSINESS_PREMIUM"
        }else {
            Write-Verbose "No available Office365 Licenses to assign" -verbose
        }

        if($null -ne $LicenseType) {
        # Creating the user account
        $Result = New-MsolUser -FirstName $_.FirstName -LastName $_.LastName -DisplayName $DisplayName  `
            -UserPrincipalName $UserPrincipalName  -City $_.City -Country $Country -Department $_.Department  `
            -MobilePhone $MobilePhone -PostalCode $_.PostalCode -State $_.State -StreetAddress $_.StreetAddress `
            -Title $_.Title -UsageLocation $UsageLocation -ForceChangePassword $false `
            -LicenseAssignment $LicenseType -Verbose -ErrorAction Stop
            
        if ($? -eq $true) { Write-Verbose "Successfully created the O365 user account." -Verbose }
            
        # Sending an Email
        $subject = "New Office365 User Created"
        $body = @"
A new user account has been created.

Username    = $UserPrincipalName
Password    = $($Result.Password)


Thanks,
Genzeon Helpdesk.
"@

            Send-MailMessage -To @($NotificationEmail) `
                -Subject $subject -From genzeon.service@genzeon.com `
                -SmtpServer smtp.office365.com -Port 587 -Credential $ExchangeCred -UseSsl `
                -Body $body
        }
        
    }
    END {
    }
}

function Remove-UserfromDL {
    <#
    .SYNOPSIS
    Remove User from  distribution group

    .DESCRIPTION
    Remove User from  distribution group

    .EXAMPLE
    Remove-UserOnDistributionList -UPN  Testuser@genzeon.com -verbose

    .EXAMPLE
    Import-csv -Path .\UPN.csv | Remove-UserOnDistributionList
    
#>
    [CmdletBinding()]
    param (
        # Enter the UPN of a User
        [Parameter(ValueFromPipeline = $true)]
        [String[]]$UPN,
        $ErrorActionPreference = 'Stop'
    )
    
    begin {
        #Get the all DLs
        $DLGroups = (Get-DistributionGroup).PrimarySmtpAddress
    }
    
    process {
        ForEach-Object {
        # Gets User OnPrem, O365 Groups, DL's, Security Groups, SharePoint Sites
        $UserGroupList = Get-AzureADUserMembership -ObjectId $_.UPN | Where-Object { $_.ObjectType -eq "Group" } | Select-Object DisplayName, DirSyncEnabled, Mail, ObjectId, MailEnabled, SecurityEnabled
        #Filter the User DL's
        $UserDLs = @()
        $UserGroupList | ForEach-Object {
            if ($DLGroups -contains $_.mail) {
                $UserDLs += $_.mail
            }
        }
        # Removes user from Distribution Groups
        foreach ($Group in $UserDLs) {
            if ((Get-DistributionGroupMember -Identity $Group).PrimarySmtpAddress -contains $_.UPN) {
                Remove-DistributionGroupMember -Identity $Group -Member $_.UPN -Confirm:$false
                Write-Verbose "Removed $($_.UPN) From $Group Group" -Verbose
                }
            }
        }
    }
    
}

Function Add-ZoomUser {
    <# 
    .Synopsis
    Creates a Zoom user account
    .Description
    It creates a new Zoom usera ccount
    .Example
    Add-ZoomUser -UPN <test.user@genzeon.com>
    #>
    [CmdletBinding()]
    param (
        # It is the email address of the user
  
        [parameter(Mandatory = 'True')]
        [string]$UPN
  
        # [string]
        # $Application = 'Zoom',

        # [ValidateSet('Basic', 'Pro')]
        # [string]
        # $License
    )
    
    begin {
    }
    
    process {
        $User = Get-AzureADUser -ObjectId "$UPN"
        $ServicePrincipal = Get-AzureADServicePrincipal -Filter "ObjectId eq '820bdb38-0a93-4c99-bb3d-5fef45ae9d04'"
        $AppRole = $ServicePrincipal.AppRoles | Where-Object { $_.DisplayName -eq 'Basic' }
        New-AzureADUserAppRoleAssignment -ObjectId $User.ObjectId -PrincipalId $User.ObjectId `
            -ResourceId $ServicePrincipal.ObjectId -Id $AppRole.Id
    }
    
    end {
    }
}

function Disable-User {
    <# 
    .Synopsis
    Disables an office365 user account.
    .Description
    It disables an office365 user account and sends out the  notification email to specified email address(by default the notification emaail address is helpdesk@genzeon.com)
    .Example
    Disable-User -UPN <test.user@genzeon.com> -NotificationEmailAddress <helpdesk@genzeon.com>

    #>
    [CmdletBinding()]
    param (
        # It is the email address of the user that has to be disabled.
        [parameter(Mandatory = $true)]
        [string]$UPN,
        # It is the email address of the user to whom the notification email has to be sent. The default value is "helpdesk@genzeon.com"
        [string[]]$NotificationEmailAddress = 'helpdesk@genzeon.com',
        $ErrorActionPreference = 'Stop'
    )
    
    begin {
        #Get the Licenses info of the User
        $Licenses = (Get-MsolUser -UserPrincipalName $UPN | Select-Object -ExpandProperty Licenses).AccountSkuId

        #Remove the licenses one by one
        if ($null -ne $Licenses) {
            $Licenses | ForEach-Object { Set-MsolUserLicense -UserPrincipalName $UPN -RemoveLicenses $_ }
            Write-Verbose "Removed the Licenses"
        }
    }
    
    process {
        #Block the sign-in
        if ((Get-MsolUser -UserPrincipalName $UPN).BlockCredential -ne $true) { 
            Set-MsolUser -UserPrincipalName  $UPN -BlockCredential $true -Verbose 
            Write-Verbose "Blocked the Sign-in access"
        }
        if ((Get-DistributionGroupMember -Identity allindiateam@genzeon.com).PrimarySmtpAddress -contains "$UPN") {
            Remove-DistributionGroupMember -Identity "allindiateam@genzeon.com" -Member "$UPN" -Confirm:$false
            Write-Verbose "Removed from All India Team DL"
        }
        elseif ((Get-DistributionGroupMember -Identity allusteam@genzeon.com).PrimarySmtpAddress -contains "$UPN") {
            Remove-DistributionGroupMember -Identity "allusteam@genzeon.com" -Member "$UPN" -Confirm:$false
            Write-Verbose "Removed from All US Team DL"
        }
        elseif ((Get-DistributionGroupMember -Identity allphilippinesteam@genzeon.com).PrimarySmtpAddress -contains "$UPN") {
            Remove-DistributionGroupMember -Identity "allphilippinesteam@genzeon.com" -Member "$UPN" -Confirm:$false
            Write-Verbose "Removed from All Philippines Team DL"
        }
    }
    
    end {
        # sending email
        if (($null -eq ((Get-MsolUser -UserPrincipalName $UPN | Select-Object -ExpandProperty Licenses).AccountSkuId)) -and ((Get-MsolUser -UserPrincipalName $UPN).BlockCredential -eq 'True')) {
             
            # Send out a notification email
            $Body = @"
    The following user account has been disabled:
    $UPN


    Thanks
    Genzeon Helpdesk
"@
            $Subject = "User account Disabled"
            Send-MailMessage -To $NotificationEmailAddress `
                -Cc 'helpdesk@genzeon.com' `
                -Subject $Subject -From genzeon.service@genzeon.com `
                -SmtpServer smtp.office365.com -Port 587 -Credential $ExchangeCred -UseSsl `
                -Body $Body

            Write-Verbose 'Notification Email Sent !'
        }
    }
}
function Set-UserMfa {
    <# 
    .Synopsis
    Enable MFA for an office365 user.
    .Description
    It used to Manage MFA for an Office365 user.
    .Example
    Set-UserMfa -UPN <Test.User@genzeon.com> -State <Enabled|Disabled>
    #>
    [CmdletBinding()]
    param (
        # Enter the UPN of a User
        [Parameter(Mandatory = "true")][string]$UPN,
        [parameter(Mandatory = 'true')][ValidateSet('Enabled', 'Enforced', 'Disabled')]$State
    )
    switch ($State) {
        'Enabled' {
            # Create the StrongAuthenticationRequirement object
            $mf = New-Object -TypeName Microsoft.Online.Administration.StrongAuthenticationRequirement
            $mf.RelyingParty = "*"
            $mf.State = $State
            $mfa = @($mf)
            # Enable MFA for specific user
            Write-Verbose "Setting the MFA status to $State for $UPN"
            Set-MsolUser -UserPrincipalName $UPN -StrongAuthenticationRequirements $mfa -Verbose 
        }
        'Disabled' {
            if ((Get-MsolUser -UserPrincipalName $UPN).StrongAuthenticationRequirements) { 
                Write-Verbose "Setting the MFA status to $State for $UPN"
                Set-MsolUser -UserPrincipalName $UPN -StrongAuthenticationRequirements @() 
            }
            else { "MFA already Disabled for $UPN" } 
        }
        'Enforced' {
            # Create the StrongAuthenticationRequirement object
            $mf = New-Object -TypeName Microsoft.Online.Administration.StrongAuthenticationRequirement
            $mf.RelyingParty = "*"
            $mf.State = $State
            $mfa = @($mf)
            # Enable MFA for specific user
            Write-Verbose "Setting the MFA status to $State for $UPN"
            Set-MsolUser -UserPrincipalName $UPN -StrongAuthenticationRequirements $mfa -Verbose 
        }
    }
}
function Enable-ArchiveMailbox {
    <# 
    .Synopsis
    Enable the Online Archive Mailbox for an Office365 Outlook mailbox
    .Description
    It is used to enable the Online Archive Mailbox for an Office365 Outlook mailbox. It also 
enables AutoExpansion of the Archive mailbox.
    .Example
    Enable-ArchiveMailbox -UPN <Test.User@genzeon.com>
    #>
    [cmdletbinding()]
    param(
        $UPN
    )
    $MailboxInfo = Get-Mailbox -Identity $UPN
    if ($MailboxInfo.ArchiveState -ne "Local") {
        Enable-Mailbox -Identity $MailboxInfo.PrimarySmtpAddress -Archive -verbose
    }
    if ($MailboxInfo.AutoExpandingArchiveEnabled -eq $false) {
        Enable-Mailbox -Identity $MailboxInfo.PrimarySmtpAddress -AutoExpandingArchive -Verbose
    }
}
Function Set-PostUserCreationRequirement {
    <#
.Synopsis
Performs the post-user creation tasks
.Description
It can add the user to an O365 group, Enable or Disable Outlook Web Access and Web Access for Devices, Enable MFA, adds users in respective location DL's, zelis user in Zelis DL and adds the user to the AD Group
.Example
Set-PostUserCreationRequirement -OnBoardingForm "C:\OneDrive\Desktop\OnBoardingForms\MisUser.csv"
.Example
Set-PostUserCreationRequirement -OnBoardingForm "C:\OneDrive\Desktop\OnBoardingForms\MisUser.csv" -EnableO365MFA -$EnableOWA
#>
    [cmdletbinding()]
    param(
        # The literal path of the On-Boarding csv file
        [parameter(Mandatory = $true)]
        [string]$OnBoardingForm,
        # It is the name of the On-Prem AD group to which the user has to be added.
        [ValidateSet('tibco', 'RadTest', 'NetworkAccessVPN')]
        [string[]]$AdGroupName,
        [switch]$DisableOWA,
        [switch]$EnableOWA,
        [switch]$DoNotEnableO365Mfa,
        [switch]$DoNotAddToDL,
        [switch]$DoNotEnableMailboxArchive,
        $VerbosePreference = "Continue"
    )

    Begin{
        $ZelisMDM = 'f2dff20d-733b-4c9a-931b-4127eb61818c'
        $GenzeonMDM = 'c03738db-2c84-4fa4-803d-5b319c991e4b'
        $ZelisIndiaAssociates = 'f0cabcd4-e9e0-4269-9a6a-89ff5ffb5ae0'
        $KnowBe4Access = '327ab342-33d0-40af-9356-4e134fd984b5'
    }

    Process {
        
        #Importing Userdata from CSV file
        Import-Csv $OnBoardingForm | ForEach-Object {

        # UserPrincipalName
        $UPN = $_.FirstName + '.' + $_.LastName + "@" + $_.Domain 

        $Mail = (Get-Mailbox $UPN -ErrorAction SilentlyContinue -Verbose).PrimarySmtpAddress

        # Adding the user to respective O365 DL based on the location
        If ($mail -eq $UPN) {

            $Country = (Get-Mailbox $UPN).UsageLocation
            if (! $DoNotAddToDL) {
                if ($null -ne $Country) {
                    switch ($Country) {
                        'India' {
                            Write-Verbose "Adding user to Office365 group"
                            Add-DistributionGroupMember -Identity 'All India Team' -Member $UPN  -Verbose 
                        }
                        'United States' {
                            Write-Verbose "Adding user to Office365 group"
                            Add-DistributionGroupMember -Identity 'All US Team' -Member $UPN  -Verbose 
                        }
                        'Philippines' {
                            Write-Verbose "Adding user to Office365 group"
                            Add-DistributionGroupMember -Identity 'All Philippines Team' -Member $UPN  -Verbose 
                        }
                    }
                }
            }    
            
            # It enables MFA for the specified user
            if (! $DoNotEnableO365Mfa) {
                Write-Verbose "Enabling MFA"
                # Create the StrongAuthenticationRequirement object
                $mf = New-Object -TypeName Microsoft.Online.Administration.StrongAuthenticationRequirement
                $mf.RelyingParty = “*”
                $mfa = @($mf)
                # Enable MFA for specific user
                Set-MsolUser -UserPrincipalName $UPN -StrongAuthenticationRequirements $mfa
            }       

            # Disable OWA
            if ($DisableOWA) {
                Write-Verbose "Outlook web access - Disabled"
                Set-CasMailbox -Identity $UPN -OWAEnabled $false
            }

            # Enable OWA
            if ($EnableOWA) {
                Write-Verbose "Outlook web access - Enabled"
                Set-CasMailbox -Identity $UPN -OWAEnabled $true
            }    

            # Add the user to On-prem user groups
            if ($AdGroupName) {
                $AdGroupName | ForEach-Object {
                    Write-Verbose "Adding user to the AD group: $_"
                    $SAName = (Get-ADUser -Filter { EmailAddress -EQ $UPN }).SamAccountName
                    Get-ADGroup $_ | Add-ADGroupMember -Members $SAName
                }
            }

            # Manage mailbox online archive
            if (! $DoNotEnableMailboxArchive) {
                #  Enable Mailbox Online acrhive 
                $MailboxInfo = Get-Mailbox -Identity $UPN
                if ($MailboxInfo.ArchiveState -ne "Local") {
                    Enable-Mailbox -Identity $MailboxInfo.PrimarySmtpAddress -Archive -verbose
                }
                # Enable Mailbox online archive - auto expansion
                if ($MailboxInfo.AutoExpandingArchiveEnabled -eq $false) {
                    Enable-Mailbox -Identity $MailboxInfo.PrimarySmtpAddress -AutoExpandingArchive -Verbose
                }
            }

            # Adding users to Knowbe4 security group
            $UPNObjID = (Get-AzureADUser -ObjectId "$UPN").ObjectId
            Add-MsolGroupMember -GroupObjectId $KnowBe4Access -GroupMemberType User -GroupMemberObjectId "$UPNObjID" -Verbose

           # Adding Zelis User in Zelis DL            
            if ($_.Project -eq "Zelis") {
                if ($null -ne $Country) {
                    switch ($Country) {
                        'India' {
                            Write-Verbose "Adding user to Zelis DL"
                            Add-DistributionGroupMember -Identity 'teamzelisindia@genzeon.com' -Member $UPN -Verbose
                            Write-Verbose "Adding user to Zelis Associates Group"
                            Add-MsolGroupMember -GroupObjectId $ZelisIndiaAssociates -GroupMemberType User -GroupMemberObjectId "$UPNObjID" -Verbose
                        }
                    }
                }
                Write-Verbose "Adding user to Zelis MDM Group"
                Add-MsolGroupMember -GroupObjectId $ZelisMDM -GroupMemberType User -GroupMemberObjectId "$UPNObjID" -Verbose
            }
            else{
                Write-Verbose "Adding user to Genzeon MDM Group"
                Add-MsolGroupMember -GroupObjectId $GenzeonMDM -GroupMemberType User -GroupMemberObjectId "$UPNObjID" -Verbose
            }

        }
        else { Write-Verbose "$UPN Mailbox Not Created"}
        }
    }
}
function Manage-GuestUserOperation {
    <#
    .SYNOPSIS
    Adding guest users, Send Invitation mail to Guest users

    .DESCRIPTION
    Adds Guest user, Check guest userstate and send Invitation mail to Guest users, if user not accepts Invitation.

    .EXAMPLE
    Manage-GuestUserOperations -GuestUsersfilepath "C:\Temp\GuestUsers.csv" -GuestUserOpearations AddGuestUser -Verbose

    .EXAMPLE
    Manage-GuestUserOperations -ExternalUPN test.user@gmail.com -GuestUserOpearations GuestUserStatus -Verbose

    .EXAMPLE
    Manage-GuestUserOperations -ExternalUPN test.user@gmail.com -GuestUserOpearations ReSendInvitation -Verbose
#>
    [CmdletBinding()]
    param (
        # It is the Email address of the Guest user
        [string]$ExternalUPN,
        # Guest users CSV filepath
        [string]$GuestUsersfilepath,
        # To add guest users, get guest users status and to Send Invitation mail to guest users
        [parameter(Position = 1, Mandatory = 'true')]
        [ValidateSet('AddGuestUser', 'GuestUserStatus', 'ReSendInvitation')]
        $GuestUserOperations
    )

    $TenantName = 'genzeon'

    switch ($GuestUserOperations) {
        'AddGuestUser' {
            # adding External users as guest users
            Import-Csv $GuestUsersfilepath | ForEach-Object {  
                $AddResult = New-AzureADMSInvitation  -InvitedUserDisplayName $_.InvitedUserDisplayName -InvitedUserEmailAddress $_.InvitedUserEmailAddress -InviteRedirectURL 'https://myapplications.microsoft.com' -SendInvitationMessage $True -ErrorAction 'Stop'
                if ($AddResult.SendInvitationMessage -eq $true) {
                    Write-Verbose "Successfully created the Guest user account and Invitation Mail Sent to $($AddResult.InvitedUserEmailAddress)." 
                }
            }
        }

        'GuestUserStatus' {
            # varible will Convert External mail ID to Guest mail ID    
            $GuestUPN = $ExternalUPN.Replace("@", "_") + "#EXT#@$TenantName.onmicrosoft.com"
            if ((Get-AzureADUser -ObjectId $GuestUPN).UserState -eq "PendingAcceptance") {
                Write-Verbose "$($ExternalUPN) not Accepted Invitation"
            }
            else {
                Write-Verbose "$($ExternalUPN) Accepted Invitation"
            }
        }

        'ReSendInvitation' {
            # varible will Convert External mail ID to Guest mail ID 
            $GuestUPN = $ExternalUPN.Replace("@", "_") + "#EXT#@$TenantName.onmicrosoft.com"
            #Checks User Inviation accepted or not
            if ((Get-AzureADUser -ObjectId $GuestUPN).UserState -eq "PendingAcceptance") { 
                $Resend = New-AzureADMSInvitation -InvitedUserEmailAddress $ExternalUPN -InviteRedirectURL "https://myapplications.microsoft.com" -SendInvitationMessage $true
                if ($Resend.SendInvitationMessage -eq $true) {
                    Write-Verbose "Invitation not Accepted, Resending Invitation mail to $ExternalUPN"
                }
                else { Write-Verbose "Resending Invitation mail to $ExternalUPN failed" }
            }
            else {
                Write-Verbose "$($ExternalUPN) Accepted Invitation"
            }
        }


    }
}
