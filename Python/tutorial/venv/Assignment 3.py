#Ouput 4
print("This is the output for assignment 3")

##Do not use the min method. Use only for and if statements
li = [-1,3,-4,9,-1]
answer = li[0]
for element in li:
    if answer>element:
        answer = element
print(answer)



##find practical uses of lists

"""
Li=[i**2 for i in range(1,101) if i>5]
print(Li)


"""


"""
This works

L1=[2,4,6,8,10,2,3,4,7,9,10,4,3,2]
index = 0
initial = L1[0]
for element in L1:
    if element<5:
        L1[index]=''
    index = index + 1
print(L1)
index = 0
for element in L1:
    for element in L1:
        if element == '':
            L1.pop(index)
        index = index + 1
    index = 0
print(L1)


for elem in l[::]:
     if elem < 5:
        l.remove(elem)

print(l)
"""

print('This is the output for assignment 2')

l = [1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 8, 9, 1, 2, 3, 4]
for elem in l[::]:
     if elem < 5:
        l.remove(elem)
print(l)

"""
l = [1,2,3,4,5,6,7,8,9,1,2,3,4]

for elem in l:
    if elem <5:
        l.remove(elem)
        
print(l)
"""


"""print('This is the output for assignment 4')

"""

print('This is the output for assignment 4')
L2=[3,6,9,10,4,7,2,1,19]
initial = L2[0]
index = -1
index1 = 0
for element2 in L2[::]:
    if initial>element2:
        L2[index1] = initial
        L2[index] = element2
    initial = element2
    print()
    index = index + 1
    index1 = index1 + 1

print(L2)