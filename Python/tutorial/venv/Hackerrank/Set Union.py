M = input()
li = set(input().split(" "))
N = input()
li1 = set(input().split(" "))

number = set([])
for element in li:
    if element in li1:
        number.union(element)
print(len(number))

