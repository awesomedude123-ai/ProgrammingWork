$Path = Join-Path $HOME "\Desktop"
$command = {
    "cd $Path
    Git Clone https://github.com/scipag/HardeningKitty.git"
}
Invoke-Command -ScriptBlock $command
$ModulePath = Join-Path $Path "\HardeningKitty\HardeningKitty.psm1"
Import-Module $ModulePath
Install-Module -Name ProcessMitigations -Force
$LogPath = Join-Path $Path "\LogFile1.txt"
$FileFindingPath = Join-Path $HOME "\HardeningKitty\SecurityStandard.csv"
Invoke-HardeningKitty -Mode HailMary -Verbose -Log -LogFile $LogPath -SkipRestorePoint -SkipMachineInformation -FileFindingList $FileFindingPath