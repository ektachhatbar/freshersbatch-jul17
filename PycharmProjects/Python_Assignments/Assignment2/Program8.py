import glob
def findfile():
    for filename in glob.glob('D:/Info Material/**/*', recursive=True):
            print(filename)
findfile()