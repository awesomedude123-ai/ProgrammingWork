# -*- coding: utf-8 -*-

#Interpreter is Python 3.8.8 64 bit
# (#%%)-Use this to run jypeter notebook cell without the parenthesis

"""
Spyder Editor

This is a temporary script file.
""" 
import pandas as pd

name = "Sri Mukkamala"
print("Hello Anaconda") 
print(name)

#%%

num = 4
print(num)

number1 = 10
nuber2 =15

absolute_value = max(abs(16-21),abs(17-29), abs(90-80))
print(absolute_value)
print(min(10,12,15,9))

number = 15
print(number + number1)

print(max(abs(10-19) , abs(15-20), abs(10-21)))

##this is just basic code. I still have to learn the bsaics of python.

max_num = max(10,12,11,14)

print(max_num)

number = str(123)

print(max(int('23'), int('10'), float('35')))
# %%
import pandas as pd
import numpy as np
#use seed value of 1492 as a base to generate a random number
#These numbers a not truly random,
#but pseudo-random, i.e. deterministic
np.random.seed(1492)
#generate one dimensional array filled with 5000 values
#array is filled with random floating point samples from
#the normal standard distribution
test_df = pd.DataFrame({ "var1": np.random.randn(5000) })
#show the random values
print(test_df)
#draw a histogram
test_df.hist()

x = np.array([0,1,2])
print(x)