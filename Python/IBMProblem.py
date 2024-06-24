def getScoreDifference(numSeq):
    first_score = 0
    second_score = 0
    index = len(numSeq)
    turn = 0
    for i in range(index):
        if(turn%2==0):
            first_score += numSeq[0]
        else:
            second_score += numSeq[0]

        num = numSeq[0]
        numSeq.pop(0)
        index-=1
        if num%2==0:
            numSeq = numSeq[::-1]
        turn+=1
    return first_score-second_score

li=[3,6,2,3,5]
print(getScoreDifference(li))


print()
print()
li=[2,1,4]
print(getScoreDifference(li))