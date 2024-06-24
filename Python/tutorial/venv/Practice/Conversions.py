import string


print("-------Exercise 1--------\nPractices formatting a string")
#Exercise 1
c = "the new world is upon us"
c = c.replace("n","m")+c #is this not condiered mutability
x="{x} hi {g} bye"
print(x.format(x="sri",g="srikar"))
x="{2} is a {0} who likes to eat {1}"
print(x.format("male","vegetables","sri"))

print("\n-------Exercise 2--------\nFormats the poem so matching lines have same tabs")
#Exercise 2
input_1="Twinkle, twinkle, little star, How I wonder what you are! Up above the world so high, Like a diamond in the sky. Twinkle, twinkle, little star, How I wonder what you are"
c=""
li=[]
for i in input_1:
    if i.isupper() and len(c)!=0:
        if i!="I":
            j=c.translate(str.maketrans("","",string.punctuation))
            if j.strip() in li:
                print(("\t" * li.index(j.strip())) + c)
            else:
                li.append(j.strip())
                print(("\t"*li.index(j.strip()))+c)
            c=i
        else:
            c+=i
    else:
        c+=i
j=c.translate(str.maketrans("","",string.punctuation))
if j.strip() in li:
    print(("\t" * li.index(j.strip())) + c)
else:
    li.append(c)
    print(("\t" * li.index(j.strip())) + c)

print("\n-------Exercise 3--------\nTakes the first, middle, and last character of name")
#Exercise 3
name=input("Please enter your name: ")
abr=name[0]+name[int(len(name)/2)]+name[len(name)-1]
print("Abbreviated Version",abr)


print("\n-------Exercise 4--------\nPlaces one string in the middle of another string")
#Exercise 4
str1=input("Enter one value: ")
str2=input("Enter another value: ")
print(str1[0:int(len(str1)/2)]+str2+str1[int(len(str1)/2)::])

print("\n-------Exercise 5--------\nPrints all lower case letters and then upper case letters")
#Exercise 5
str1=input("Enter a string with lower and upper case: ")
li,li1=[],[]
for i in str1:
    if i.isupper():
        li.append(i)
    elif i.islower():
        li1.append(i)
print("".join(li1)+"".join(li))

print("\n-------Exercise 6--------\nProvides count of letters, digits, and special characters")
#Exercise 6
str1=input("Enter a string with letters, digits, and special characters: ")
l,d,s=0,0,0
for i in str1:
    if i in string.ascii_letters:
        l+=1
    elif i in string.digits:
        d+=1
    else:
        s+=1
print("Chars =",l,"\nDigits =",d,"\nSymbol",s)

print("\n-------Exercise 7--------\nCombines both strings together")
#Exercise 7
str1=input("Enter string: ")
str2=input("Enter another string: ")
for i in range(0,len(str1)):
    if(i<len(str2)):
        print(str1[i]+str2[i],end="")
    else:
        print(str1[i], end="")
if(len(str2)>len(str1)):
    x=len(str2)-len(str1)
    print(str2[len(str2)-x::])

print("\n-------Exercise 8--------\nProvides count of work in sentence")
#Exercise 8
str1=input("Enter sentence: ")
str2=input("Enter word to count: ")
x=0
if(len(str2)>len(str1)):
    print(x)
else:
    for i in range(0,len(str1)-len(str2)):
        if(str1[i:i+len(str2)]==str2):
            x+=1
    print(x)

print("\n-------Exercise 9--------\nProvides count of each letter in word")
#Exercise 9
str1=input("Enter a word: ")
dict={}
for i in str1:
    if i not in dict:
        dict[i]=1
    else:
        dict[i]=dict[i]+1
print(dict)

print("\n-------Exercise 10--------\nPrints the word backword")
#Exercise 10
print(input("Enter word: ")[::-1])


print("\n-------Exercise 11--------\nIdentifies index of last position of where word located")
#Exercise 11
str1=input("Please enter a sentence: ")
str2=input("Please enter a word to find: ")
x=0
for i in range(len(str1)-len(str2)):
    if(str1[i:i+len(str2)])==str2:
        x=i
print(x)


print("\n-------Exercise 12--------\nPrint sentence without the punctuation")
#Exercise 12
str1=input("Please enter a sentence: ")
str2=""
for i in str1:
    if i.isalnum():
        str2+=i
print(str2)

print("\n-------Exercise 13--------\nFinds word with numbers and alphabets")
l=list(input("Pleasae enter a sentence: ").split(" "))
for i in l:
    if i.isalnum() and i.isnumeric()==False and i.isalpha()==False:
        print(i)

print("\n-------Exercise 14--------\nReplaces special symbols with #")
l=input("Please enter a sentence: ")
for i in l:
    if i in list(string.punctuation):
        l=l.replace(i,"#")
print(l)
