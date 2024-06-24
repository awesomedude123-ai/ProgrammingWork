import string



def missingWords(s,t):
    x = t.split(" ")
    y= s.split(" ")
    index=0
    list_of_words = []
    for i in y:
        if i != x[index]:
            list_of_words.append(i)
        else:
            if index < len(x)-1:
                index += 1
    return list_of_words

def isPangram(pangram):
    is_pangram = ""
    letters = list()
    for i in pangram:
        space = i.count(" ")
        letter = ["a", "b", "c", "d", "e", "f","g", "h", "i", "j", "k", "l","m", "n", "o", "p", "q", "r","s", "t", "u", "v", "w", "x","y", "z"]
        if len(i) - space >= 26:
            value = True
            for x in letter:
                if i.find(x)<0:
                    is_pangram=is_pangram+"0"
                    value = False
                    break
            if value==True:
                is_pangram = is_pangram + "1"
        else:
            is_pangram = is_pangram + "0"
    return is_pangram

x = []
x.append("we promptly judged antique ivory buckles for the next prize")
x.append("we promptly judged antique ivory buckles for the prizes")
x.append("the quick brown fox jumps over the lazy dog")
x.append("the quick brown fox jump over the lazy dog")

print(isPangram(x))


y="I am using hackerrank to improve programming"
z="am hackerrank to improve"
print(missingWords(y,z))