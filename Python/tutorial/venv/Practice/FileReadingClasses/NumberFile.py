filename=input("Enter the filename: ")
sentences="".join(open(filename).readlines())
new_sentences=""
for i in sentences:
    if not i.isdigit():
        new_sentences+=i
open(filename,"w").write(new_sentences)
print("".join(open(filename).readlines()))
open(filename).close()
