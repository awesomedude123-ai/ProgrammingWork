import random
import string

sentence = input("Please input a messgae you wish to have encoded:")
char_list=list(string.ascii_letters)+list(string.digits)+list(string.punctuation)+list(string.whitespace)
encoded_string=""
for i in sentence:
    index=char_list.index(i)
    x=random.randint(1,len(sentence))
    encoded_string=encoded_string + char_list[(((index+index)*x)-x)%len(char_list)]
print(encoded_string)