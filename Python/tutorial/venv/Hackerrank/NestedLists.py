from collections import defaultdict
key_names=defaultdict(list)
scores=[]
for _ in range(int(input())):
    name = input()
    score = float(input())
    if score in key_names:
        key_names[score].append(name)
    else:
        key_names[score]=[name]
    if score not in scores:
        scores.append(score)
num = sorted(scores)[1]
names = sorted(key_names.get(num))
for element in names: print(element)