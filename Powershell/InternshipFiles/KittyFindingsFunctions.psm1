
#Gets the ID's of the Recommendations missing between the Audit Report and the CSV file
Function Get-MissingId {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $True)]
        [String]
        $AuditFile
        ,
        [Parameter(Mandatory = $True)]
        [String]
        $InputFile
        ,
        [String]
        $OutputFile = "C:\Users\rootadmin\HardeningKitty\Findings\MissingIDBetweenBothInputFiles.csv"
    )
    $file = Import-Csv $AuditFile
    $file1 = Import-Csv $InputFile
    $array = @("ID")
    foreach ($Id in $file.ID) {
        if ($file1.ID -notcontains $Id) {
            $array += $Id
        }
    }
    $array | Out-File -FilePath $OutputFile
}

#Gets the Missing Recommednations that are in the Audit Report but are not in the input CSV file
Function Get-MissingRecommendationsInAuditNotInInput {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $True)]
        [String]
        $AuditFile
        ,
        [Parameter(Mandatory = $True)]
        [String]
        $InputFile
        ,
        [String]
        $OutputFile = "C:\Users\rootadmin\HardeningKitty\Findings\MissingRecsInAuditNotInput.csv"
    )
    $file = Import-Csv $AuditFile
    $file2 = Import-Csv $InputFile
    $array = @()
    foreach ($row in $file) {
        if ($file2.ID -notcontains $row.ID) {
            $array += $row
        }
    
    }
    $array | Export-Csv $OutputFile
}


#Gets the Failed Recommendations that are in both the Input CSV file and the Audit Report
Function Get-MissingRecommendationsInBoth {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $True)]
        [String]
        $AuditFile
        ,
        [Parameter(Mandatory = $True)]
        [String]
        $InputFile
        ,
        [String]
        $OutputFile = "C:\Users\rootadmin\HardeningKitty\Findings\FailedInBothInputAndAudit.csv"
    )
    $file = Import-Csv $AuditFile
    $file1 = Import-CSV $InputFile

    $array = @()
    foreach ($row in $file) {
        if ($file1.ID -contains $row.ID) {
            if ($row.TestResult -eq "Failed") {
                $array += $row
            }
        }
    }
    $array | Export-Csv -Path $OutputFile
}


#Gets the Failed Recommednations from the File that consists of the recommendations missing in the Input CSV file
Function FailedMissing {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $True)]
        [String]
        $AuditRowOfIdMissingFile
        ,
        [String]
        $OutputFile = "C:\Users\rootadmin\HardeningKitty\Findings\FailedInAuditNotInInput.csv"
    )
    $file = Import-Csv $AuditRowOfIdMissingFile
    $array = @()
    foreach ($row in $file) {
        if ($row.TestResult -eq "Failed") {
            $array += $row
        }
    }
    $array | Export-Csv -Path $OutputFile
}

#Gets All Recs that did not pass from Audit File
Function Get-TestResultFailed {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $True)]
        [String]
        $AuditFile
        ,
        [String]
        $OutputFile = "C:\Users\rootadmin\HardeningKitty\Findings\TestResultFailed.csv"
    )
    $file = Import-Csv $AuditFile
    $array = @()
    foreach ($row in $file) {
        if ($row.TestResult -ne "Passed") {
            $array += $row
        }
    }
    $array | Export-Csv -Path $OutputFile
}


#Replaces the Recommendations in Input File with the Audit Recommendations
Function Modify-Recommendation {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $True)]
        [string]
        $TestResultFailed
        ,
        [Parameter(Mandatory = $True)]
        [String]
        $FileFindingList
        ,
        [String]
        $OutputFile = "C:\Users\rootadmin\HardeningKitty\finding_list_cis_microsoft_windows_10_enterprise_20h2_machineCOPY1.csv"
    )
    $FailedFile = Import-Csv $TestResultFailed
    $FileFindingList = Import-Csv $FileFindingList
    $array = @()
    foreach ($row in $FileFindingList) {
        if ($FailedFile.ID -contains $row.ID) {
            foreach ($row1 in $FailedFile) {
                if ($row.ID -eq $row1.ID) {
                    $Rec = $FailedFile.Recommended
                    $row.Recommended = $Rec
                }
                break
            }
        }
        $array += $row
    }
    $array | Export-Csv -Path $OutputFile
}

#Get the Audit Rows that are not being modified in the Input File
Function Get-Missing {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $True)]
        [String]
        $FileFindingList
        ,
        [Parameter(Mandatory = $True)]
        [String]
        $TestResultFailed
        ,
        [String]
        $OutputFile = "C:\Users\rootadmin\HardeningKitty\Findings\MissingResults.csv"
    )
    $File1 = Import-Csv $FileFindingList
    $File2 = Import-Csv $TestResultFailed

    $array = @()
    foreach ($row in $File2) {
        if ($row.Category -eq $File1.Category -and $row.Name -eq $File2.Name) {

        }
        else {
            $array += $row
        }
    }

    $array | Export-Csv $OutputFile
}

#Gets Recommendations that was considered Failed in the old Audit Report but now considered Passed in the new Audit Report
Function Get-DifferentTestResultRows {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $True)]
        [String]
        $OldAuditFile
        ,
        [Parameter(Mandatory = $True)]
        [String]
        $NewAuditFile
        ,
        # Parameter help description
        [Parameter(AttributeValues)]
        [ParameterType]
        $ParameterName
    )
}

#Need to create the registry keys and paths for all the failed ones. First check if they can be found elsewhere and then create the registry keys



Function Get-AzureRecommendations {
    [CmdletBinding()]
    param (
        # Parameter help description
        [Parameter(Mandatory = $True)]
        [string]
        $AzureRecommendationsInputFile
        ,
        [string]
        $OutputFile = "C:\Users\SMukkamala\Downloads\RecommendationSimplified.csv"
    )
    $file = Import-Csv $AzureRecommendationsInputFile
    $array = @()
    foreach ($row in $file) {
        $table = @{
            #exportedTimestamp,subscriptionId,subscriptionName,resourceGroup,resourceType,resourceName,resourceId,recommendationId,recommendationName,recommendationDisplayName,
            #description,remediationSteps,severity,state,notApplicableReason,firstEvaluationDate,statusChangeDate,controls,azurePortalRecommendationLink,nativeCloudAccountId,tactics,
            #techniques,cloud,owner,eta,dueDate,gracePeriod
            recommendationDisplayName = $row.recommendationDisplayName
            remediationSteps          = $row.remediationSteps
        }
        $array += ($table | Select-Object @("recommendationDisplayName","remediationSteps"))
    }
    $array | Export-Csv $OutputFile
}


Function Get-RecColumn{
    [CmdletBinding()]
    param (
        [Parameter(Mandatory=$True)]
        [string]
        $AzureRecommendationsInputFile
        ,
        [string]
        $OutputFile = "C:\Users\SMukkamala\Downloads\SingleColumnRecommendationSimplified.csv"
        ,
        [Parameter(Mandatory=$True)]
        [string]
        $ColumnName
    )
    $file = Import-Csv $AzureRecommendationsInputFile
    $array = @($ColumnName)
    foreach($row in $file){
        $array += @($row.$ColumnName)
    }
    $array | Write-Output
}


#Gets the Recommendations that are in the FileFindingList but are not in the InputFile
Function Get-Different{
    param(
        [Parameter(Mandatory=$True)]
        [String]
        $InputFile
        ,
        [Parameter(Mandatory=$True)]
        [String]
        $FileFindingList
        ,
        [String]
        $OutputFile = "C:\Users\SMukkamala\HardeningKitty\FileDifference.csv"
    )

    $file=Import-Csv $InputFile
    $file1 = Import-Csv $FileFindingList

    $array=@()
    foreach($row in $file1){
        if($file.Category -eq $row.Category -and $file.Name -eq $row.Name){
            
        }else{
            $array+=$row
        }
    }

    $array | Export-Csv -Path $OutputFile

}