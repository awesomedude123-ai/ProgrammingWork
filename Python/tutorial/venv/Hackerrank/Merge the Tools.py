string = "ABACAAADA"
k = 3
r = len(string)/k
answer = []
count = 0
for element in string[::]:
    if count%k!=0:
        print(element)
        if element not in answer:
            answer.append(element)
    else:
        print("".join(answer))
        answer.clear()
        answer.append(element)
    count = count +1

print("".join(answer))