ly = int(input())
inputs = input().split()
sdow = inputs[0]
sm = inputs[1]
sdom = int(inputs[2])
inputs = input().split()
tm = inputs[0]
tdom = int(inputs[1])
d=[31,28,31,30,31,30,31,31,30,31,30,31]
m=["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
da=["Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"]
x=m.index(sm);y=m.index(tm)
u=0
if x<=y:
    while x!=y:
        if x==m.index(sm):
            if x==1 and ly==1:
                u+=(d[x]+1-sdom)
            else:
                u+=(d[x]-sdom)
            x+=1
        else:
            u+=(d[x]+1);x+=1
            if x==1 and ly==1:
                u+=1
            if x==len(d):
                x-=12
    if u==0:
        u+=(tdom-sdom)
    else:
        u+=(tdom)
    q=sdom
    w=m.index(sm)
    while u>7:
        q+=7;u-=7
        if d[w]==30 and q>30:
            w+=1;q-=30
        elif d[w]==31 and q>31:
            w+=1;q-=31
        elif d[w]==28 and q>28:
            if ly==1:
                w+=1;q-=29
            else:
                w+=1;q-=28
        if w>=len(m):
            w-=len(m)
    if sm == tm:
        h=da.index(sdow)+u
    else:
        if w==1 and ly==1:
            k=d[w]-q+tdom+1
        else:
            k=0
            if w==y:
                k=tdom-q
            else:
                k=d[w]-q+tdom

        h=da.index(sdow)+k
        while h>=len(da):
            h-=len(da)
    print(da[h])
else:
    while x>=y:
        if x==-1:
            x=11
        if x==m.index(sm):
            if x==1 and ly==1:
                u+=sdom
            else:
                u+=sdom
            x-=1
        else:
            u+=d[x];x-=1
            if x==1 and ly==1:
                u+=1
    if u==0:
        u+=(sdom-tdom)
    else:
        u+=(tdom)
    q=sdom
    w=m.index(sm)
    while u>7:
        q-=7;u-=7
        if d[w-1]==30 and q<=0:
            q+=30;w-=1
        elif d[w-1]==31 and q<=0:
            q+=31;w-=1
        elif d[w-1]==28 and q<=0:
            if ly==1:
                w-=1;q+=29
            else:
                w-=1;q+=28
        if w==-1:
            w=11
    if w==y:
        h=tdom-q
    else:
        h=d[w]-q+tdom
        print(d[w],q,tdom)
    p=da.index(sdow)+h
    if p>=len(da):
        p-=len(da)
    print(da[p])