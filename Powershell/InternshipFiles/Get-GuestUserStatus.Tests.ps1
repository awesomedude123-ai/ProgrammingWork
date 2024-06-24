Describe 'GraphOps'{
    BeforeAll{
        Connect-MgGraph
    }
    Context 'Get-GuestUserStatus'{
        It 'Should Get the Guest User Status'{
            $Path =Join-Path $HOME 'GuestUsersFile.csv'
            $File = Import-Csv -Path $Path
            foreach($row in $File){
                {Get-GuestUserStatus -GuestUserEmail $row.InvitedUserEmailAddress} | Should -Not -Throw
            }
        }
    }
}