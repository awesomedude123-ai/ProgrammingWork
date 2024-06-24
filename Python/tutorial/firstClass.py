inp = "AAABBBCCDEFIJKLLL"

out=""

initial = inp[0]

out = out + initial
count = 0

for element in inp[1:]:
    if element == initial:
        count = count + 1
    else:
        if count>0:
            out = out + '.' +element
            initial = element
            count = 0
        else:
            out = out+element
            initial = element

if count>0:
    out = out+'.'
print(out)
