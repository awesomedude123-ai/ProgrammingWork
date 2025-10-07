# 1. Write a Python snippet that prompts the user to enter an IST course number
# 140, 242, 261, 311, 411
# Use If, and elif statements and else to determine whether they entered the correct course number.
# If a correct course number is entered, output the title of the class i.e. 140 is Intro to Application Development, etc.

##Name-Day of Completion
##Brief 2-3 line description of code
x=input("Enter a word")
if x.isdigit():
    print("Is number")
else:
    print("Input is not a number")

#Taking int input from user
user_input = int(input("Enter IST Course: "))

##Check if input is one of the 5 numbers. If so, print specific name of course else print not valid
if user_input==140: #Checking if input is 140
    print("140 is Intro to App Dev") #Print Name of course
elif user_input==242: #Checking if input is 242
    print("242 is Intermediate Obj Ori Dev") #Print Name of course
elif user_input==261: #Checking if input is 261
    print("261 is App Dev Design Studio 1") #Print Name of course
elif user_input==311: #Checking if input is 311
    print("311 is Obj-Ori Design and Software") #Print Name of course
elif user_input==411: #Checking if input is 411
    print("411 is Distrbuted Obj Computing") #Print Name of course
else: #Input is not above
    print("Not Valid") #Print Name of course

# 2. Write a Python snippet that prompts a user to input a number between 1 - 100
# Then output if the number is well below average (<20), is below the average (<40)
# in the average (between 40 and 60), above the average (>60) or well above average (>80)
# If not, output that it is not a valid entry

##Prompt User
user_input = int(input("Give me a number between 1 and 100: "))
if user_input>=1 and user_input<=100:
    if user_input<20:
        print("Well Below Average")
    else:
        if user_input<40:
            print("Below Average")
        else:
            if user_input<60:
                print("Average")
            else:
                if user_input<80:
                    print("Above average")
                else:
                    print("Well Above Average")
else:
    print("Not Valid Input")


#3.Prompt for three integers. Check to see if all three are even by (1) using both compound conditional
# and (2) nested-ifs.

input_1=int(input("Give me a Number 1: "))
input_2=int(input("Give me a Number 2: "))
input_3=int(input("Give me a Number 3: "))

if input_1%2==0 and input_2%2==0 and input_3%2==0:
    print("All are even")
else:
    print("All are not even")

if input_1%2==0:
    if input_2%2==0:
        if input_3%2==0:
            print("All are even")
        else:
            print("All are not even")
    else:
        print("All are not even")
else:
    print("All are not even")

# 4. Write a program that calculates and prints the
# value of the coupon a person can receive based on groceries
# purchased using the table below.
# Prompt the user for the amount of their groceries, as a float.
# If so, read in the input and determine the value of the
# coupon based on the following information
# Money spent:                           Coupon %:
# More than $210                         14%
# More than $150 - 210                   12%
# More than $60 - 150                    10%
# From $10 - 60                           8%
# Less than $10                          No coupon

user_input=float(input("Price of groceries: "))

if user_input<0:
    print("Not Valid")
elif user_input>210:
    print("Coupon is 14%")
elif user_input>150:
    print("Coupon is 12%")
elif user_input>60:
    print("Coupon is 10%")
elif user_input>10:
    print("Coupon is 8%")
else:
    print("No Coupon")

##Check to see in string, is digit not digit
##Making sure if statements are in order

#0   0   0 1 0   1  0  0   P
#DL  DR  C M IL  OL IR OR  G

s=input()

dash_left=s[0]
dash_right=s[2]

# if M unlocked and G is P
## Child is 0 or DL is 1
## Unlock doors L or R