inputfile = open('/Users/awesomedude123/Downloads/SecurityLog-rev2 (1).xml','r')
outputfile = open('/Users/awesomedude123/Downloads/outputEventSecurityLog.xml','w')
outputfile.write("")
outputfile.close()
outputfile = open('/Users/awesomedude123/Downloads/outputEventSecurityLog.xml','a')
event = input("Please event an event number: ")

numevents = 0

data = inputfile.read()

cleaned = data.replace("\r","").replace("\n","")

cleaned_2 = cleaned.replace("<Event ","\n<Event ")
index = 0

for line in cleaned_2.split("\n"):
    if index!=0:
        if line.__contains__(f"<EventID>{int(event)}</EventID>"):
            outputfile.write(line+"\n")
    index+=1

##outputfile.write(cleaned_2)

inputfile.close()
outputfile.close()