echo $((4+4))

echo $((8-5))

echo $((8/4))

echo $(( (3+6) - 5 * (5*2) ))

a=3

((a+=3))

echo $a

((a++))
echo $a

((a--))
echo $a

((a-=3))
echo $a

((a/=3))
echo $a

declare -i b=3
echo $b

b=$b+4
echo $b

declare -i c=1
declare -i d=3

e=$(echo "scale=3;$c/$d" | bc)
echo $e

echo $RANDOM
echo $RANDOM
echo $RANDOM

echo $((1 + RANDOM % 10 ))
echo $((1 + RANDOM % 10))
echo $((1 + RANDOM % 10))