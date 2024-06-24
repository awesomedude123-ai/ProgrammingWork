Describe 'GraphOps'{
    Context 'Add-ZoomUser'{
        BeforeAll{
            Connect-MgGraph
        }
        It 'Should Add a Zoom User'{
            $Path = Join-Path $HOME "ZoomUser.csv"
            $File=Import-Csv -Path $Path
            foreach($row in $File){
                {Add-ZoomUser -UPN $row.User} | Should -Not -Throw
            }
        }
        AfterAll{
            foreach($row in $File){
                $User = Get-MgUser -UserId $row.User
                Remove-MgUserAppRoleAssignment -AppRoleAssignmentId '23962431-1240-420c-8472-a8111e98ca6f' -UserId $row.User
            }
        }
    }
}