Describe 'GraphOps'{
    BeforeAll{
        Connect-MgGraph
        $userProperties = @{
            DisplayName = "tuser"
            UserPrincipalName = "test.user@genzeon.com"
            JobTitle = "Intern(Testing)"
            StreetAddress="123 Test Ave"
            City="Test City"
            State="Pennsylvania"
            PostalCode="19425"
            Country="US"
            MobilePhone="1234567890"
            passwordProfile = @{
                password="h12894hg@ysu8784hFwey98hagiuu0"
            }
            AccountEnabled=$True
            MailNickname="testuser"

        }

        New-MgUser @userProperties
        $Path = Join-Path $HOME "user.csv"
        $UserBeforeUpdate=Get-MgUser -UserId "test.user@genzeon.com"
    }
    Context 'Update-AzureAdUser'{

        It 'Should update User Details'{
            {Import-Csv -Path $Path | Update-AzureADUser} | Should -Not -Throw 
        }

        It 'Should make changes to User Details'{
            $array = Import-Csv $Path
            $UserAfterUpdate = Get-MgUser -UserId $array.User
            $UserBeforeUpdate | Should -Not -Be $UserAfterUpdate
    }
    AfterAll{
        Remove-MgUser -UserId "test.user@genzeon.com"
    }
}
}