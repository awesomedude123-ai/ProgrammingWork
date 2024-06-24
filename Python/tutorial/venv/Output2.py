# str1 = "AAAABBBBCDDDEEEFFFIJKLLL"
# letter = str1[0]
# count = 0
# answer = letter
# length = 0
# num_of_dots = ""
# for letter_1 in str1:
#     if length != 0:
#         if letter ==letter_1 and length <len(str1)-1:
#             num_of_dots = num_of_dots +'.'
#             length = length + 1
#         elif length == len(str1)-1:
#             if str1[length] == str1[length-1]:
#                 answer = answer + num_of_dots + '.'
#             else:
#                 answer = answer + num_of_dots
#         else:
#             answer = answer + num_of_dots + letter_1
#             letter = letter_1
#             num_of_dots=''
#             length = length + 1
#     else:
#         length = 1
# answer
str1 = "AAAA"
initial = str1[0]
output = initial
count = 0
for element in str1[1:]:
    if element == initial:
        count = count+1
    else:
        if count == 0:
            output = output + element
            initial = element
        else:
            output = output+str(count)+element
            initial = element
            count = 0

if count!=0:
    output = output+str(count)
print(output)
