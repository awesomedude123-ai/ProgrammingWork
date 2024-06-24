def is_palindrome(k):
    if(len(k)%2==0):
        return recurssion_even(k,len(k),True)
    else:
        return recurssion_odd(k,len(k),True)



def recurssion_odd(str1, y,x):
    str1=str1.lower()
    if y==int(len(str1)/2):
        if x==True:
            return True
        else:
            return False
    else:
        if str1[len(str1)-y]==str1[y-1] and x==True:
            return recurssion_odd(str1,y-1,True)
        else:
            return recurssion_odd(str1,y-1,False)

def recurssion_even(str1,y,x):
    str1=str1.lower()
    if y==int(len(str1)/2)+1:
        if x==True and str1[y]==str1[y-1]:
            return True
        else:
            return False
    else:
        if str1[len(str1) - y] == str1[y - 1] and x == True:
            return recurssion_odd(str1, y - 1, True)
        else:
            return recurssion_odd(str1, y - 1, False)



print(is_palindrome("hhollohh"))