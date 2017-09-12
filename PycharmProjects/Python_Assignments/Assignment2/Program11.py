import glob
import os
def findfile():
    count = 0
    lineCount = 0
    for filename in glob.glob('C:/Users/chhatbar_e/Assignments/PycharmProjects/Python_Assignments/Assignment2/Program1.py', recursive=True):
        if(filename):
            print(filename)
            if os.path.isfile(filename):
                    for line in open(filename):
                        if(line.rstrip()):
                            if not line.startswith("#"):
                                lineCount+=1
            count+=1
    print("Number of Files ",count,"Number of lines", lineCount)
findfile()