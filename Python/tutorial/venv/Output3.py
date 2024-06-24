# string1 = "AAAABBBBCDDDEEEFFFIJKLLL"
# letter = string1[0]
# answer = ""
# length = 0
# count = 0
# for letter_1 in string1:
#     #Checking if the preceding letter is same or if we are not at the last letter. If we are then count should
#     if length!=0:
#         if letter == letter_1 and length!=len(string1)-1:
#             count=count+1
#             length = length + 1
#         elif length==len(string1)-1:
#             if string1[length-1] == string1[length]:
#                 answer = answer + string1[length] + str(count+1)
#             else:
#                 answer = answer + string1[length] + str(count)
#         else:
#             answer = answer + letter + str(count)
#             count = 0
#             letter = letter_1
#             length = length+1
#     else:
#         length = length+1
#         continue
# answer
str1 = "AAABBBCDDDEEEFFFIJKL"
initial = str1[0]
output = initial
num_of_dots = ''
for elem in str1[1:]:
    if elem == initial:
        num_of_dots = num_of_dots + '.'
    else:
        output = output + num_of_dots + elem
        initial = elem
        num_of_dots=''
output = output + num_of_dots
print(output)

num = int(input("Enter a number: "))
num1=0
num2=1
for element in range(0,num):
    num3=num1+num2
    if num>=num3:
        if num==num3:
            print(num,"is in the Fibonnaci Sequence")
            break
        else:
            num1=num2
            num2=num3
    else:
        print(num,"is not in the FIbonnaci Sequence")
        break





















