filename=input("Enter the filename: ")
print(len(open(filename).readlines()))
open(filename).close()