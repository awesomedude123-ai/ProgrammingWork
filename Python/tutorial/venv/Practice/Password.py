"""
Assignment : Evaluate the Password
    Str1 = "ABCDEFGH675"
    output:
    alpha = True
    lower = True/FALSE
    digit = True
    Upper = True
    alnum = True
    length = 10
"""

##Make better

password = input("Please provide a password. Your passowrd must contain, numbers, uppercase letters, lowercase letters , symbols, and must be at least 10 characters ")
if password.isalpha()==False:
    if password.islower()==False:
        if password.isdigit()==False:
            if password.isupper()==False:
                if password.isalnum()==False:
                    if len(password)>=10:
                        print("This password works. You're all set")
                    else:
                        print("This password is not long enough")
                else:
                    print("This password needs a symbol")
            else:
                print("This password needs to have lower case letters as well.")
        else:
            print("This password needs letters")
    else:
        print("This password needs to have upper case letters as well.")
else:
    print("This password needs to have numbers as well.")


