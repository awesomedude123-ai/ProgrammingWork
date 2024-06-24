s1=[]
d1=[]
pun=[]
s=""
j = []
for i in s1:
    value=""
    for x in i:
        if x not in pun:
            s=s+x
        else:
            if s=="":
                value=value+x
            else:
                if s in d1:
                    value=value+d1[s]+x
                else:
                    value=value+s+x
                s=""
    if s !="":
        if s in d1:
            value=value+d1[s]
        else:
            value=value+s
    j.add(value)
" ".join(j)

