d = {'Name':'Sri', 'Age':'17','Height': '5,11'}
d1 = {'Name' : 'Unknown', 'Age': 'No idea', 'Heights':'Will never know'}




str1 = "Today is Tuesday Today is Sunny Today is my Class"
example = str1.split(" ")


#Use dictionary instead of lists
repeat={}
non_repeat={}

for element in example[::]:
   num = str1.count(element)
   if num>1:
       if element not in repeat:
           repeat[element] = num
   else:
       non_repeat[element] = num
       example.remove(element)
print("Repeated Words: ", repeat)

print("Non-Repeated Words ", non_repeat)



##Use disctionaries, do not override the value just say it is present as well, merge any keys that are not present
##Assignment 2

for element1 in d1:
    if element1 in d.keys():
        print(d1[element1], "is also in the key", element1)
    else:
        d[element1]=d1[element1]
#check key, which key is being merged(if key is already there)
print(d)