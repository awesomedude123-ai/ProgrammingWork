"""
The ceaser cypher program: One of the earliest and simplest method of encryption techinque.

It subtitutes a letter for another letter that is a fixed number of positions down the alphabet.

"""

"""
"""

string = "sri"
array = [1,4,2,3]

alphabet = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'



message = input('Provide a message ')

num = int(input('Enter a number between 0 and 26 '))

encoded_message = ''


index = 1

letter1=''
for element in message:
    for letter in alphabet:
        if element == letter:
            if (num+index) > len(alphabet):
                number = 52-index
                encoded_message = encoded_message + alphabet[num -number]
                index = 1
                break
            else:
                encoded_message = encoded_message+alphabet[num+index]
                index = 1
                break
        elif index == len(alphabet)-1:
            index = 1
            break
        else:
            index = index + 1

print("This is your encoded message: " + encoded_message)