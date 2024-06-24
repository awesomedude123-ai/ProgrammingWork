def fizzBuzz(n):
    if n%3==0 and n%5==0:
        print("FizzBuzz")
    elif n%3==0:
        print("Fizz")
    elif n%5==0:
        print("Buzz")
    else:
        print(n)
        
        
li = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]

for element in li:
    fizzBuzz(element)




## Leap year

def is_leap(year):
    leap = False

    if year%100==0:
        if year%400==0:
            leap = True
        else:
            leap = False
    elif year%4:
        leap = True

    return leap