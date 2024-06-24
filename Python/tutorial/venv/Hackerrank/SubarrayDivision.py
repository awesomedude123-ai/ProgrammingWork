from itertools import combinations
from datetime import datetime
s = [2,5,1,3,4,4,3,5,1,1,2,1,4,1,3,3,4,2,1]
d = 18
m = 7
"""

start_time = datetime.now()


count = 0
perm = combinations(s, m)
li=[]
for element in perm:
    element=sorted(element)
    if element not in li:
        li.append(element)
        if m == 1 and sum(element) == d:
            count = 1
            break
        elif sum(element) == d:
            print(element)
            count = count + 1

end_time = datetime.now()
print('Duration: {}'.format(end_time-start_time))
print(count)
"""
num = 0
x=0
e = m
count = 0



for element in range(0, len(s)):
    li = s[x:e]
    if sum(li) == d:
        count = count + 1
    num = 0
    x=x+1
    e=e+1
    print(x,e)
    if e>len(s):
        break
print(count)

ls = [10,9,7,11,14,8,13,29]

h = 'pop'
h.insert(1, 'r')
print(h)