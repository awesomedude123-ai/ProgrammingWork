welcome = 9

for i in range(10):
    print((i+1) * welcome)

print("Hello World")

##Mean, Median, Mode

li=[19,
19,
28,
95,
4,
36,
100,
28,
95,
13,
100,
80,
47,
28,
48,
58,
88,
4,
48,
80]

li = sorted(li)
print(len(li))
print(sorted(li))
print((li[9]+li[10])/2)
print(sum(li)/len(li))