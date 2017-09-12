import glob
import os
def findfile():
    count = 0
    lineCount = 0
    for filename in glob.glob('C:/Users/chhatbar_e/Assignments/PycharmProjects/Python_Assignments/**/*.py', recursive=True):
        if(filename):
            print(filename)
            if os.path.isfile(filename):
                 with open(filename) as fname:
                     lines = len(fname.readlines())
                     print(lines," lines in " ,filename)
                     lineCount += lines
            count+=1
    print("Number of Files ",count,"Number of lines", lineCount)
findfile()