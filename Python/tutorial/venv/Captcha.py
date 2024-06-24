import random
import string


#without hardcoding the character length

captcha1 = ''
number = int(input("How many characters should be in the Captcha? "))

for element in range(number):
    num1 = random.randint(1,4)
    if num1==1:
        captcha1 = captcha1 + string.ascii_lowercase[random.randint(0,len(string.ascii_lowercase)-1)]
    elif num1==2:
        captcha1 = captcha1 + string.ascii_uppercase[random.randint(0, len(string.ascii_uppercase) - 1)]
    elif num1==3:
        captcha1 =captcha1 +  string.digits[random.randint(0,len(string.digits)-1)]
    else:
        captcha1 = captcha1 + string.punctuation[random.randint(0,len(string.punctuation)-1)]

print(captcha1)
#with hardcoding the character length
#lower_case_letters=string.ascii_lowercase
#upper_case_letters=string.ascii_uppercase
#digits = string.digits
#symbol = string.punctuation
"""
length_of_captcha = 10
captcha = lower_case_letters[random.randint(0,len(lower_case_letters)-1)] + \
          lower_case_letters[random.randint(0,len(lower_case_letters)-1)] + lower_case_letters[random.randint(0,len(lower_case_letters)-1)] + \
          upper_case_letters[random.randint(0,len(upper_case_letters)-1)] + upper_case_letters[random.randint(0,len(upper_case_letters)-1)] + \
          upper_case_letters[random.randint(0,len(upper_case_letters)-1)] + digits[random.randint(0,len(digits)-1)] + \
          digits[random.randint(0,len(digits)-1)] + symbol[random.randint(0,len(symbol)-1)] + symbol[random.randint(0, len(symbol)-1)]
print(captcha)
"""
