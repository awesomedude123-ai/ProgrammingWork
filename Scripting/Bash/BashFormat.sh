echo "The results are: $(( 2 + 2 )) and $(( 3 / 1 ))" 

printf "The results are: %d and %d\n" $(( 2 + 2 )) $(( 3 / 1 ))

echo "----10----| --5--"

echo "Right-aligned text and digits"
printf "%10s: %5d\n" "A Label" 123 "B Label" 456

echo "Left-aligned text, right-aligned digits"
printf "%-10s: %5d\n" "A Label" 123 "B Label" 456

echo "Left aligned text and digits"
printf "%-10s: %-5d\n" "A Label" 123 "B Label" 456

echo "Left-aligned text, right aligned adn padded digits"
printf "%-10s: %0fd\n" "A Label" 123 "B Label" 456

echo "----10----| --5--"

printf "%(%Y-%m-%d %H:%M:%S)T\n" 16817558
date +%s
date +%Y-%m%d\ %H:%M:%S

printf "%(%Y-%m-%d %H:%M:%S)T\n" $(date +%s)
printf "%(%Y-%m-%d %H:%M:%S)T\n"
printf "%(%Y-%m-%d %H:%M:%S)T is %s\n" -1 "the time"
