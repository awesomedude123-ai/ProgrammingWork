import pandas as pd

# Replace with your pcap file path
csv_file = "/Users/awesomedude123/Downloads/packets.csv"
df = pd.read_csv(csv_file)
dict_of_ip_addresses = {}
c=0
s=""
check=""
for index,row in df.iterrows():
    if c!=0:
        if row['Info'].__contains__('>'):
            s = row['Info'].split("  >  ")
            if row['Source'] not in dict_of_ip_addresses.keys():
                if int(s[0])<=1024:
                    dict_of_ip_addresses[row['Source']]=[int(s[0])]
            else:
                if int(s[0])<=1024:
                    if int(s[0]) not in dict_of_ip_addresses[row['Source']]:
                        dict_of_ip_addresses[row['Source']].append(int(s[0]))


            check=s[1].split(" ")
            if check[0].__contains__("["):
                check=check[0].split("[")[0]
            else:
                check=check[0]

            if row['Destination'] not in dict_of_ip_addresses.keys():
                if int(check)<=1024:
                    dict_of_ip_addresses[row['Destination']]= [int(check)]
            else:
                if int(check)<=1024:
                    if int(s[0]) not in dict_of_ip_addresses[row['Destination']]:
                        dict_of_ip_addresses[row['Destination']].append(int(check))
    c+=1
    print(c)

output_file = "/Users/awesomedude123/Downloads/output.txt"
print(len(dict_of_ip_addresses))
with open(output_file, "w") as fi:
    for i in dict_of_ip_addresses.keys():
        fi.write(str(i+":"+str(sorted(dict_of_ip_addresses[i]))))
        print("Finished ",i)