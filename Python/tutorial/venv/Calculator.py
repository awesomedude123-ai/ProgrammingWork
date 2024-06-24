import CalcMod
choice = int(input('Choose one of the opertations and enter the number associated. 1-Addition, 2-Subtraction, 3-Multiplication, 4-Division: '))



if choice==1:
    num = input('Provide a list of numbers,seperated by commas: ')
    li = num.split(',')
    print("Sum:", CalcMod.add(li))
elif choice==2:
    print("Difference:", CalcMod.subtract())
elif choice==3:
    #add the list idea
    num = input('Provide a list of numbers, seperated by commas: ')
    li = num.split(',')
    print("Product:", CalcMod.multiply(li))
else:
    print("Quotient:", CalcMod.division())
