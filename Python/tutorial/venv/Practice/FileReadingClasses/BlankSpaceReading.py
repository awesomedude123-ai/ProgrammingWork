filename=input("Enter the filename: ")
sentences="".join(open(filename).readlines())
print(sentences.count(" "))