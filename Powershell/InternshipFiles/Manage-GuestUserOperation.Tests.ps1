Describe 'GraphOps'{
    Context 'Manage-GuestUserOperation'{
        BeforeAll{
            Connect-MgGraph
            $Path =Join-Path $HOME 'GuestUsersFile.csv'
        }
        It 'Should Add a Guest User'{
            Manage-GuestUserOperation -GuestUserFilePath $Path -GuestUserOperation 'AddGuestUser' | Should -Not -Throw
            Write-Host "Please do not accept the email. Necessary for next check"
            ##For AddUser, does it add the user to the AD once run or does it wait for the invitiation to be clicked and then add the user to the active directory
        }
        It 'Should Check the Status of the Guest User'{
            $File = Import-Csv -Path $Path
            Manage-GuestUserOperation -GuestUserEmail $File.InvitedUserEmailAddress -GuestUserOperation 'GuestUserStatus' | Should -Be "$($File.InvitedUserEmailAddress) has not accepted the invitation."
        }
        It 'Should Resend the Guest User Invitation'{
            $File = Import-Csv -Path $Path
            Manage-GuestUserOperation -GuestUserEmail $File.InvitedUserEmailAddress -GuestUserOperation 'ReSendInvitation' | Should -Not -Throw
            Write-Host "Please find the email and accept the invitation."
        }

        Start-Sleep -Seconds 10
        It 'Should Remove the Guest User'{
            Manage-GuestUserOperation -GuestUserFilePath $Path -GuestUserOperation "RemoveGuestUser" | Should -Not -Throw
            $File = Import-Csv -Path $Path
            $UPN = $File.InvitedUserEmailAddress.Replace('@','_')+ "#EXT#@genzeon.onmicrosoft.com" 
            $User = Get-MgUser -UserId $UPN
            if($User -eq $Null){
                Write-Output "User was successfully removed"
            }else{
                Write-Output "User was not removed."
            }
        }
    }
}