"""


"""
#assignment 2
a = [10,20,30,40,50,60]
b = 25
index = 0
for element in a[::]:
    if b<element:
        a.insert(index,b)
        break
    index = index + 1
print(a)

#assignment 1

a = {1,2,3,4,5,6}
b = {4,5,6, '9'}
a1 = a.difference(b)
b1 = b.difference(a)
a2 = a1.union(b1)
print(a2)

li = ['b','a','c','k','l']
li.sort()
print(li)

print(a.difference(b).union(b.difference(a)))