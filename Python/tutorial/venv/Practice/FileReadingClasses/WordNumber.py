value=input("Please enter a sentence: ").title()
example=input("Please enter a word that should be counted: ").title()
count=0

#sentence --> Sentence
print(value.count(example))



#Sentences, Sentences.
for i in value.split(" "):
    if i.__contains__(example):
        count += 1
print(count)

#    if i not in d:
        #d[i]=input_1.count(i)

#word words

input_1=input("Please enter a sentence or numbers: ").lower()
d={}#dictionary
for i in input_1.split(" "):
    if i not in d:
        d[i]=input_1.count(i)
for i in d:
    print(i,"=",d[i])

input_1 = input("Enter a list of values seperated by comma: ")
d = {}
for i in input_1.split(","):
    if i not in d:
        d[i] = input_1.split(",").count(i)
print(d.keys())
key_removed = input("Select key to update: ")
d["updated"] = d[key_removed]
d.pop(key_removed)
print(d.keys())
