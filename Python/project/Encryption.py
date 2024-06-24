import random
import string


def encryption(sentence=""):
    letter = list(string.ascii_lowercase)
    punctuation = list(string.punctuation)
    value = ""
    for i in sentence:
        if i.lower() in letter:
            x = random.randint(0, 25)
            value = value + letter[x]
        elif i in punctuation:
            x = random.randint(0, 31)
            value = value + punctuation[x]
        else:
            value = value + " "
    return value


sentence = input("Enter a sentence or phrase: ")
print(sentence)
sentence = encryption(sentence)
print("1:", sentence)
sentence = encryption(sentence)
print("2:", sentence)
sentence = encryption(sentence)
print("3:", sentence)
