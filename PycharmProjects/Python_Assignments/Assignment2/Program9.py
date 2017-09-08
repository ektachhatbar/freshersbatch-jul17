import glob
count=0
for filename in glob.iglob('C:/Users/chhatbar_e/Assignments/PycharmProjects/Python_Assignments/Assignment1/*.py', recursive=True):
    if(filename):
        print(filename)
        count+=1
print("Number of .py Files ",count)