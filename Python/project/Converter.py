# Converts the temperature from F to C and vice versa
def temp(d=90, t='F'):
    # Degrees in d
    t = t.upper()
    if t == 'F':
        d = 5 * (d - 32) / 9
        return d
    else:
        d = d * (9 / 5) + 32
        return d


con = input("Would you like to enter a degrees value and its temperature? Enter Y for Yes or N for No. ")
y = True
if con=="N":
    y=False
while y:
    d = int(input("Please enter a Degrees value for the conversion. "))
    t = input("Please enter a Temperature. Enter F for Fahrenheit or C for Celsius")
    if t.upper() == 'F':
        print("You chose to convert", d, "from", t,"to",temp(d,t),"C")
    else:
        print("You chose to convert", d, "from", t, "to", temp(d, t), "F")
    con = input("Would you like to continue to enter a degrees value and its temperature? Enter Y for Yes or N for No. ")
    if con == "N":
        y = False

#Temperature,Metric to Standard,