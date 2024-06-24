word=input("Enter a word: ")
d,c=0,0
for i in word:
    if i.isdigit():
        d+=1
    else:
        c+=1
print("Digit #:",d,"\nCharacter #",c,end="")
