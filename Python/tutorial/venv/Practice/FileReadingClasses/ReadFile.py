filename=input("Enter the filename: ")
print("".join(open(filename,"r")))
open(filename).close()