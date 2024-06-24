
Function Get-MailboxReport {

    <#
        .SYNOPSIS
        Get the Mailbox Usage Report

        .DESCRIPTION
        Get the Mailbox Usage Report

        .EXAMPLE
        Get-MailboxReport -Period "D30"

    #>
    [CmdletBinding()]
    param (
        # Parameter help description
        [Parameter()]
        [String]
        $Period = "D7"
    )
    Connect-MgGraph
    $FilePath = Join-Path $HOME "Downloads\MailboxUsageReport.csv"
    Get-MgReportMailboxUsageDetail -Period $Period -OutFile $FilePath

}
Function Update-AzureADUser {

    <#
        .SYNOPSIS
        Update Azure AD portal

        .DESCRIPTION
        Update User details

        .EXAMPLE
        Update-AzureADUser -Path C:\Users\UserName\DirectoryWithImagesAndUserFiles

    #>

    [CmdletBinding()]
    param (
        #It is the path of the directory containing "user.csv", image.
        [Parameter(Mandatory = $True)]
        [string]
        $Path
    )

    $UserFile = Join-Path $Path "user.csv"
    Import-Csv -Path $UserFile | ForEach-Object {
        $ImageFile = Join-Path $Path "images" -ChildPath $_.Picture
        $ReportsToUser = Get-MgUser -Search $_.Manager
        $ReportsToObjectId = $ReportsToUser.ObjectId

        Update-MgUser -User.Id $_.User -JobTitle $_.JobTitle -Department $_.Department -StreetAddress $_.StreetAddress -City $_.City -State $_.State 
        -PostalCode $_.PostalCode -Country $_.Country -TelephoneNumber $_.OfficePhone -PhysicalDeliveryOfficeName $_.Office -Manager $ReportsToObjectId
        
        Set-MgUserPhotoContent -UserId $_.User -InFile $ImageFile

    }
}
Function Add-ZoomUser {
    <#
        .SYNOPSIS
        Creates a Zoom user account

        .DESCRIPTION
        It creates a new Zoom user account

        .EXAMPLE
        Add-ZoomUser $UPN <test.user@genzeon.com>

    #>
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $True)]
        [string]
        $UPN
    )
    $User = Get-MgUser -Filter "UserPrincipalName eq '$UPN'"
    $ServicePrincipal = Get-MgServicePrincipal -Filter "appId eq '820bdb38-0a93-4c99-bb3d-5fef45ae9d04'"
    $AppRole = $ServicePrincipal.AppRoles | Where-Object { $_.DisplayName -eq 'Basic' }
    New-MgUserAppRoleAssignment -UserId $User.ObjectId -AppRoleId $AppRole.Id -ResourceId $ServicePrincipal.ObjectId -PrincipalId $User.ObjectId
    
}

Function Manage-GuestUserOperation {
    <#
        .SYNOPSIS
        Adding Guest Users,Sending invitation mail to Guest Users, Removing Guest Users

        .DESCRIPTION
        Adds Guest Users, Sends invitation mail the Guest Users, Removes Guest Users

        .EXAMPLE
        Manage-GuestUserOperation $GuestUserFilePath C:\Users\UserName\GuestUsersFile -GuestUserOperation AddGuestUser

        .EXAMPLE
        Manage-GuestUserOperation $GuestUserEmail test.user@gmail.com -GuestUserOperation GuestUserStatus

        .EXAMPLE
        Manage-GuestUserOperation $GuestEmail test.user@gmail.com -GuestUserOperation ReSendInvitation

        .EXAMPLE
        Manage-GuestUserOperation $GuestUserFilePath C:\Users\UserName\GuestUsersFile -GuestUserOperation RemoveGuestUser

    
    #>

    [CmdletBinding()]
    param (

        # Parameter help description
        [Parameter()]
        [string]
        $GuestUserFilePath
        ,
        # Parameter help description
        [Parameter()]
        [string]
        $GuestUserEmail
        ,
        [Parameter(Mandatory = $True)]
        [ValidateSet('AddGuestUser', 'GuestUserStatus', 'ReSendInvitation', 'RemoveGuestUser')]
        $GuestUserOperation
    )

    switch ($GuestUserOperation) {
        'AddGuestUser' {
            $rows = Import-Csv -Path $GuestUserFilePath
            foreach ($row in $rows) {
                try {
                    $Result = New-MgInvitation -InvitedUserDisplayName $row.InvitedUserDisplayName -InvitedUserEmailAddress $row.InvitedUserEmailAddress -InviteRedirectUrl 'https://myapplications.microsoft.com' -SendInvitationMessage $True
                    Write-Output "Successfully created the Guest user account and Invitiation Mail sent to $($Result.InvitedUserEmailAddress)"
                }
                catch {
                    Write-Output "Error has occurred. Please review and try again."
                    break
                }
                 
            }
        }

        'GuestUserStatus' {
            $GuestUPN = $GuestUserEmail.Replace('@', '_') + "#EXT#@genzeon.onmicrosoft.com"
            if ((Get-MgUser -UserId $GuestUPN).ExternalUserState -eq "PendingAcceptance") {
                Write-Output "$($GuestUserEmail) has not accepted the invitation."
            }
            else {
                Write-Output "$($GuestUserEmail) has accepted the invitation."
            }
        }

        'ReSendInvitation' {
            $GuestUPN = $GuestUserEmail.Replace('@', '_') + "#EXT#@genzeon.onmicrosoft.com"
            if ((Get-MgUser -UserPrincipalName $GuestUPN).ExternalUserState -eq "PendingAcceptance") {
                try {
                    $Resend = New-MgInvitation -InvitedUserEmailAddress $GuestUserEmail -InviteRedirectUrl "https://myapplications.microsoft.com" -SendInvitationMessage $True
                    Write-Output "Invitation not accepted, Resending Invitation Mail to $($GuestUserEmail)"
                }
                catch {
                    Write-Output "Error has occurred. Please review and try again"
                }
            }
        }

        'RemoveGuestUser' {
            $rows = Import-Csv $GuestUserFilePath
            foreach ($row in $rows) {
                $GuestUserEmailRow = $row.InvitedUserEmailAddress
                $GuestUPN = $GuestUserEmailRow.Replace('@', '_') + "#EXT#@genzeon.onmicrosoft.com" 
                $User = Get-MgUser -Filter "UserPrincipalName -eq $GuestUPN"
                Remove-MgUser -UserId $User.OdataId
                if ((Get-MgUser -Filter "UserPrincipalName -eq $GuestUPN").DisplayName -eq "") {
                    Write-Output "Successfully removed $($User.DisplayName)."
                }
                else {
                    Write-Output "An error has occurred. Please review and try again."
                }

            }
        }
    }
}

git config --global user.email "Srivathsava.Mukkamala@genzeon.com"
git config --global user.name "Srivathsava Mukkamala"