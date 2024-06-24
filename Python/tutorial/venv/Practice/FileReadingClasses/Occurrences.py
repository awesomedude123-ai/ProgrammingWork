import string
import re
import os


def words_and_punctuation(word):
    value=[];x=""
    for i in word:
        if i in string.punctuation:
            value.append(x)
            value.append(i)
            break
        else:
            x+=i
    if len(value)==0:
        value.append(x)
    return value


file_name=input("Enter file name: ")
d={}
sentence_list="".join(open(file_name,"r").readlines()).split("\n")
for line in sentence_list:
    for word in line.split():
        li=words_and_punctuation(word)
        if li[0] in d:
            d[li[0]]=d[li[0]]+1
        else:
            d[li[0]]=1
        if len(li)>1:
            if li[1] in d:
                d[li[1]]=d[li[1]]+1
            else:
                d[li[1]]=1
li=sorted([(key,value) for key,value in d.items()],key=lambda x: x[1])
for key,value in li:
    print(key,"->",value)
    s = key+" -> "+str(value)+"\n"
    open("result.txt", "a").write(s)
