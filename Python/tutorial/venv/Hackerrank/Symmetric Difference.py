string = "12 3 4 67"
string1 = "2 45 98 78"

s = set(int(element) for element in string.split(" "))
s1 = set(int(element) for element in string1.split(" "))
s2 = s.difference(s1)
s2 = s2.union(s1.difference(s))
print(s2)
s2 = sorted(s2)
for element in s2:
    print(element)