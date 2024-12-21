[ -d ~ ]
echo $?

help test

[ "cat" = "dog" ];echo $?
[ "cat" = "cat" ];echo $?
[ 4 -lt 3 ]; echo $?
[ ! 4 -lt 3 ]; echo $?

[[ 4 -lt 3 ]];echo $?

[[ -d ~ && -a /bin/bash ]];echo $?

[[ -d ~ || -a /bin/mash ]];echo $?

[[ -d ~ ]] && echo ~ is a directory 

[[ -d /bin/bash ]] && echo /bin/bash is a directory 

[[ "cat" =~ c.* ]]; echo $?