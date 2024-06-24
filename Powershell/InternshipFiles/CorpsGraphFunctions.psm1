
function Test-ADData {
    [CmdletBinding()]
    param (
        # Parameter help description
        [Parameter(Mandatory = 'True')]
        [string]
        $AdUpdateCsvfilePath
    )
    
    begin {
        $AdUpdateList = Import-Csv $AdUpdateCsvfilePath
    }
    
    process {
        $AdUpdateList | ForEach-Object {
            if('' -eq $_.EmailAddress){
                Write-Host "Email address is empty for $($_.GivenName) $($_.Surname)"
            }            
            else {
                Write-Verbose "Working on $($_.EmailAddress) ..."
                $user = Get-MgUser -Filter "UserPrincipalName -like '$($_.EmailAddress)'" -Property Manager, Department, Country, State, City, Company, Title
                if ($null -eq $user) {
                    Write-Host "User $($_.EmailAddress) not found in AD"
                }
                elseif ('TRUE' -eq $user.Department) {
                    Write-Host "Department is TRUE for $($_.EmailAddress), this is invalid data"
                }
            }
        }
    }
    end {
        
    }
}#Ask what is this method about


function Get-Reportees()
{
    <#
    .SYNOPSIS
    Get reportees

    .DESCRIPTION
    Get reportees by traversing the hierarchy

    .EXAMPLE
     Get-Reportees -UserPrincipalName 'Vikram.Pendli@genzeon.com'
    #>
    PARAM(
        # User Principle Name
        [string]
        $UserPrincipalName
        )
    Process{
        # If User Principal name has no reportees then exit
        $User = Get-MgUser -Filter "UserPrincipalName -like '$UserPrincipalName'"
        $Reportees = Get-MgUser -Filter "Manager -eq '$User'"
        # For each of the reportees return User principal name and Reportee
        if($null -ne $Reportees) { 
            foreach ($Reportee in $Reportees) {
                $directreporteeUPN = (Get-MgUser  -Identity $Reportee).UserPrincipalName 
                $Record = New-Object PSObject -Property @{ ReporteeUPN="$directreporteeUPN"; ManagerUPN="$UserPrincipalName"}
                $Record
                Get-Reportees -UserPrincipalName $directreporteeUPN
            }
        }
        else{
            return 
        }
    }
}#Ask about this method as well
