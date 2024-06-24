Describe 'GraphOps'{
    BeforeAll{
        Connect-MgGraph
    }

    Context 'Remove-GuestUser'{
        It 'Should remove the guest users'{
            $Path = Join-Path $HOME 'GuestUsersFile.csv'
            {Import-Csv -Path $Path | Remove-GuestUser} | Should -Not -Throw
        }
    }
}