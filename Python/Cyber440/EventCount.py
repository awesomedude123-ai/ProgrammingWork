inputfile = open('/Users/awesomedude123/Downloads/SecurityLog-rev2 (1).xml','r')
outputfile = open('/Users/awesomedude123/Downloads/outputEventCountSecurityLog.xml','w')
outputfile.write("")
outputfile.close()
outputfile = open('/Users/awesomedude123/Downloads/outputEventCountSecurityLog.xml','a')
event = input("Please event an event number: ")

numevents = 0

data = inputfile.read()

cleaned = data.replace("\t","").replace("\r","").replace("\n","")

cleaned_2 = cleaned.replace("<Event ","\n<Event ")
index = 0
count = 0
for line in cleaned_2.split("\n"):
    if index!=0:
        if line.__contains__(f"<EventID>{int(event)}</EventID>"):
            outputfile.write(line+"\n")
            count+=1
    index+=1
print(f"Count of EventID {event} is {count}")
outputfile.write(f"Count of EventID {event} is {count}")

##outputfile.write(cleaned_2)

inputfile.close()
outputfile.close()