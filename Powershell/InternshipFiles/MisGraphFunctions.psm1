Function Add-MisUser{
    param(
        # Parameter help description
        [Parameter(Mandatory=$True)]
        [string]
        $ParameterName
    )
    Begin{

    }
    Process{
        Import-Csv -Path $OnBoardingForm | Add-User #This Add-User is the Add-User for Office365
        Import-Csv -Path $OnBoardingForm | ForEach-Object{
            $UPN = $_.FirstName + "."+$_.LastName + "@" + $_.Domain
            If($Null -eq (Get-MgUser -UserId $UPN)){
                Write-Output "O365 accound not created, Suspended User Account creation for $($_.FirstName + " "+$_.LastName)."
            }else{
                Import-Csv -Path $OnBoardingForm | Add-CorpUser
                Write-Output "Successfully Created User Account for $($_.FirstName + " "+$_.LastName)."
            }
        }
    }
}


