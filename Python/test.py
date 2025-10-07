#they are planning on investing (this is an integer).
principal = float(input("Please enter the amount you are saving: "))
interest = float(input("Please enter the yearly interest rate: "))
years = int(input("Please enter the number of years you are saving: "))
#This line will calculate how much the user saves after the number
#of years the inputted using their principal amount and the yearly
#interest rate. This is solved using the Simple Interest Amount Formula
savings = principal * (1 + interest * years)
#This line takes the yearly interest rate given by the user and converts
#it into a percentage by multiplying it by 100
percent = interest * 100
#This line will tell the user how much they will have recieved after
#their given years, interest rate, and principal value
print("The current yearly interest rate is %.2f. At the end of year %d, you will have received "
"$%.2f if you deposit $%.2f right now" %(percent, years, savings, principal))