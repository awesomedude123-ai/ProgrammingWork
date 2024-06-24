Describe 'GraphsOps'{
    BeforeAll{
        Connect-MgGraph
    }
    Context 'New-GuestUser'{
        It 'Should create a new Guest User'{
            $Path = Join-Path $HOME "GuestUsersFile.csv"
            {Import-Csv -Path $Path | New-GuestUser} | Should -Not -Throw
        }
    }
}