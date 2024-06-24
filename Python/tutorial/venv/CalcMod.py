"""
def add(*args):
    return sum(args)
"""
import sys
def add(num):
    index=0
    for element in num:
        try:
            num[index]=int(element)
        except:
            print(element,'is not a number.')
            try:
                element = input('Provide the number again: ')
                num[index] = int(element)
            except:
                print('What you entered was not a number. Program exited!')
                sys.exit()
        index+=1
    return sum(num)

def subtract():
    try:
        num = int(input('Provide the first number: '))
        num1 = int(input('Provide the second number: '))
    except:
        print('What you entered were not numbers. Please try again.')
        try:
            num = int(input('Provide the first number: '))
            num1 = int(input('Provide the second number: '))
        except:
            print('What you entered were not numbers. Program exited!')
            sys.exit()
    return num-num1
def multiply(num):
    index = 0
    answer = 1
    for element in num:
        try:
            x=int(element)
        except:
            print(element, 'is not a number. Please enter another number.')
            try:
                element = input('Provide the number again: ')
                x=int(element)
            except:
                print('What you entered was not a number. Program exited!')
                sys.exit()
        answer = answer * x
    return answer
def division():
    try:
        num = int(input('Provide the divdend: '))
        num1 = int(input('Provide the divisor: '))
    except:
        print('What you entered were not numbers. Please try again.')
        try:
            num = int(input('Provide the first number: '))
            num1 = int(input('Provide the second number: '))
        except:
            print('What you entered were not numbers. Program exited!')
            sys.exit()
    return num/num1