filename=input("Enter the filename: ")
sentences="".join(open(filename).readlines())
print(sentences[::-1])
open(filename).close()