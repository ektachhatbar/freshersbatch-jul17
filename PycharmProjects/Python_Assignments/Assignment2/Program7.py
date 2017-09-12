def getFileChar(*files):
    for file in files:
        fobj=open(file)
        for line in fobj:
            counter = 0
            for ch in line:
                counter+=1
            if counter>40:
                print(line)
        fobj.close()
getFileChar('D:/Info Material/Python/sample.txt','D:/Info Material/Python/sample2.txt')