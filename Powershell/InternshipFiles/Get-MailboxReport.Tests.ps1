Describe 'GraphOps'{
    Context 'Get-MailboxReport'{
        It 'Should develop a report in Current Users Download folder'{
            Begin{
                Connect-MgGraph -Scopes "Reports.Read.All"
            }
            Process{
                Get-MailboxReport
                $Path = Join-Path $HOME Downloads\MailboxUsageReport.csv
                $Path | Should -Exist
            }
            End{
                $Path = Join-Path $HOME Downloads\MailboxUsageReport.csv
                Remove-Item -Path $Path
            }
        }
    }
}