inputfile = open('/Users/awesomedude123/Downloads/SecurityLog-rev2 (1).xml','r')
outputfile = open('/Users/awesomedude123/Downloads/outputEventCountPerTimeSecurityLog.xml','w')
outputfile.write("")
outputfile.close()
outputfile = open('/Users/awesomedude123/Downloads/outputEventCountPerTimeSecurityLog.xml','a')
event = input("Please event an event number: ")
list_of_times = {}
numevents = 0

data = inputfile.read()

cleaned = data.replace("\t","").replace("\r","").replace("\n","")

cleaned_2 = cleaned.replace("<Event ","\n<Event ")
index = 0
count = 0

##Get the times
for line in cleaned_2.split("\n"):
    if index!=0:
        split_1=line.split("<TimeCreated SystemTime=\'")
        split_2=split_1[1].split(":")
        if split_2[0] not in list_of_times:
            list_of_times[split_2[0]]=0
    index+=1

index=0

for line in cleaned_2.split("\n"):
    if index!=0:
        if line.__contains__(f"<EventID>{int(event)}</EventID>"):
            split_1 = line.split("<TimeCreated SystemTime=\'")
            split_2 = split_1[1].split(":")

            list_of_times[split_2[0]]=list_of_times[split_2[0]]+1
            count+=1
    index+=1


print(f"Count of EventID {event} is {count}")

outputfile.write(f"The EventID picked is {event}\nThe count for Event ID {event} is {count}\n")

for key in list_of_times.keys().__reversed__():

    print(f"{key}\t{list_of_times[key]}")
    outputfile.write(f"{key}\t{list_of_times[key]}\n")

##outputfile.write(cleaned_2)

inputfile.close()
outputfile.close()