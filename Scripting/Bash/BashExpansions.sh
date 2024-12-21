##Tilda Expansion

echo ~
whoami


##Brace Expansion
echo c{a,o,u}t
echo {1..10}
echo {10..1}
echo {01..100}
echo {a..z}
echo {a..z..2}
echo {1..30..3}
echo {cat,dog,fox}{1..5}

##Parameter Expansion
a="Hello World"
echo $a
echo ${a}
echo ${a:1:9}
echo ${a/World/Everybody}
echo ${a//e/_}


##Command Substitution
uname -r 
echo "Kernel is $(uname -r)."

##Arithmetic Expansion

echo $((2+2))
echo $((4*2))