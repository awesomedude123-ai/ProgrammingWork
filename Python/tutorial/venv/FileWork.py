import os

#path = os.path.join("/Users/awesomedude123/PycharmProjects/tutorial/venv", "Practice")
#os.mkdir(path)

#Modify it for each directory to contain the files as well
"""
A:A

B: A.B.

C; A,B,C
"""

path = os.path.join("/Users/awesomedude123/PycharmProjects/tutorial/venv/Practice", "A")

os.mkdir(path)

os.chdir("/Users/awesomedude123/PycharmProjects/tutorial/venv/Practice/A")
path = "/Users/awesomedude123/PycharmProjects/tutorial/venv/Practice/A"
path1 = os.path.join(path, "B")
os.mkdir(path1)

os.chdir("/Users/awesomedude123/PycharmProjects/tutorial/venv/Practice/A/B")

path = "/Users/awesomedude123/PycharmProjects/tutorial/venv/Practice/A/B"

path2 = os.path.join(path, "C")
os.mkdir(path2)

os.chdir("/Users/awesomedude123/PycharmProjects/tutorial/venv/Practice/A/B/C")

path = "/Users/awesomedude123/PycharmProjects/tutorial/venv/Practice/A/B/C"

path3 = os.path.join(path, "D")
os.mkdir(path3)

os.chdir("/Users/awesomedude123/PycharmProjects/tutorial/venv/Practice/A/B/C/D")

file = open("A.txt", "w")
file.write("This is text file A")
file.close()

file1 = open("B.txt", "w")
file1.write("This is text file B")
file1.close

file2 = open("C.txt", "w")
file2.write("This is text file C")
file2.close()

file3=open("D.txt", "w")
file3.write("This is text file D")
file3.close()

path = "/Users/awesomedude123/PycharmProjects/tutorial/venv/Practice"
#returns 3 values: File path, directory names, file names

#0s.walk -> Shows path, what is directory, and files. Can delete files that are not required.
num_of_dir = 0
num_of_files = 0
for path1, dir, files in os.walk(path):
    for name in dir:
        num_of_dir = num_of_dir + 1
    for name1 in files:
        num_of_files = num_of_files + 1
print('Number of files:', num_of_files)
print('Number of directories', num_of_dir)