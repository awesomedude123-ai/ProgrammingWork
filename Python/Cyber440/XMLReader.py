inputfile = open('/Users/awesomedude123/Downloads/SecurityLog-rev2 (1).xml','r')
outputfile = open('/Users/awesomedude123/Downloads/outputSecurityLog.xml','w')

numevents = 0


for line in inputfile:
    outputfile.write(line)
    numevents+=1
inputfile.close()
outputfile.close()