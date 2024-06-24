function Addition{
    [CmdletBinding()]
    param (
        [Parameter(Mandatory=$True)]
        [int]
        $value1=0 ,
        $value2=0
    )

    return $value1+$value2
}



function Subtraction{
    param (
        [Parameter(Mandatory=$True)]
        [int]
        $value1=0 ,
        $value2=0
    )

    return $value1-$value2
}

function Multiplication {
    param (
        # Parameter help description
        [Parameter(Mandatory=$True)]
        [int]
        $value1=0 ,
        $value2=0
    )

    return $value1*$value2
    
}


function Division {
    param (
        # Parameter help description
        [Parameter(Mandatory=$True)]
        [int]
        $value1=0 ,
        $value2=0
    )

    return $value1/$value2
    
}