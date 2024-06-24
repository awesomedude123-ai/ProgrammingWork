
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
        Import-Csv C:\Users\UserName\DirectoryWithUserFiles | Update-AzureADUser

    #>

    [CmdletBinding()]
    param (
        #Should be the array of users in csv file passed through the pipeline
        [Parameter(ValueFromPipeline = $True, Mandatory = $True)]
        $Users
    )
    Begin {
        Connect-MgGraph
    }
    Process {
        $ReportsToUser = Get-MgUser -UserId $Users.Manager
        #$_.Department,$_.Office
        Update-MgUser -UserId "$($_.User)" -JobTitle $_.JobTitle -Department "$($_.Department)" -StreetAddress $_.StreetAddress -City $_.City -State $_.State -PostalCode "$($_.PostalCode)" -Country $_.Country -MobilePhone "$($_.Mobile)" -OfficeLocation "$($_.Office)"
        $URL = "https://graph.microsoft.com/v1.0/users/" + $ReportsToUser.Id
        Set-MgUserManagerByRef -UserId $_.User -OdataId $URL
    }
    End {

    }
}
#Need all the values to be present

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
    $User = Get-MgUser -UserId $UPN
    $ServicePrincipal = Get-MgServicePrincipal -Filter "appId eq '23962431-1240-420c-8472-a8111e98ca6f'"
    $AppRole = $ServicePrincipal.AppRoles | Where-Object { $_.DisplayName -eq 'Basic' }
    New-MgUserAppRoleAssignment -UserId $User.Id -AppRoleId '00000000-0000-0000-0000-000000000000' -ResourceId $ServicePrincipal.Id -PrincipalId $User.Id
    
}
#Different Zoom App, No App Roles or display names


Function New-GuestUser {
    <#
       .SYNOPSIS
        Creates a Guest User

       .DESCRIPTION

       .EXAMPLE

       #>
    [CmdletBinding()]
    param (
        [Parameter(ValueFromPipeline = $True, Mandatory = $True)]
        $User
    )

    Begin {
        Connect-MgGraph
    }
    Process {
        New-MgInvitation -InvitedUserDisplayName $User.InvitedUserDisplayName -InvitedUserEmailAddress $User.InvitedUserEmailAddress -InviteRedirectUrl 'https://myapplications.microsoft.com' -SendInvitationMessage
        Write-Output "Successfully created the Guest user account and Invitiation Mail sent to $($User.InvitedUserEmailAddress)"
    }
    End {

    }
}

Function Get-GuestUserStatus {
    <#
      .SYNOPSIS
        Get the Guest User Status

      .DESCRIPTION

      .EXAMPLE

      #>

    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $True)]
        [string]
        $GuestUserEmail
    )

    Begin {
        Connect-MgGraph
    }
    Process {
        $GuestUPN = $GuestUserEmail.Replace('@', '_') + "#EXT#@genzeon.onmicrosoft.com"
        $User=Get-MgBetaUser -UserId $GuestUPN
        if ($User.ExternalUserState -eq "PendingAcceptance") {
            Write-Output "$($GuestUserEmail) has not accepted the invitation."
        }
        ElseIf($User.ExternalUserState -eq "PendingAcceptance"){
            Write-Output "$($GuestUserEmail) has accepted the invitation."
        }else{
            Write-Output "$($GuestUserEmail) has no invitation."
        } 
    }
    End {

    }
}

Function Resend-GuestUserInvitation {
    <#
      .SYNOPSIS
        Resend the Guest User Invitation

      .DESCRIPTION

      .EXAMPLE

      #>
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $True)]
        [string]
        $GuestUserEmail
    )

    Begin {
        Connect-MgGraph
    }
    Process {
        $GuestUPN = $GuestUserEmail.Replace('@', '_') + "#EXT#@genzeon.onmicrosoft.com"
        $User = Get-MgBetaUser -UserId $GuestUPN
        if ($User.ExternalUserState -eq "PendingAcceptance") {
            New-MgInvitation -InvitedUserEmailAddress $GuestUserEmail -InviteRedirectUrl "https://myapplications.microsoft.com" -SendInvitationMessage
            Write-Output "Invitation not accepted, Resending Invitation Mail to $($GuestUserEmail)"
        }
    }
    End {
        
    }
}

Function Remove-GuestUser {
    <#
     .SYNOPSIS

     .DESCRIPTION

     .EXAMPLE

     #>

    [CmdletBinding()]
    param (
        [Parameter(ValueFromPipeline = $True, Mandatory = $True)]
        $User
    )
    Begin {
        Connect-MgGraph
    }
    Process {
        $GuestUserEmailRow = $User.InvitedUserEmailAddress
        $GuestUPN = $GuestUserEmailRow.Replace('@', '_') + "#EXT#@genzeon.onmicrosoft.com" 
        Remove-MgUser -UserId $GuestUPN
        Write-Output "Successfuly removed Guest User $($User.InvitedUserDisplayName)"
    }
    End {

    }
}