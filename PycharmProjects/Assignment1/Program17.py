amt=100
while True:
    inp=input()
    if(not inp):
        break
    tran=inp.split(" ");

    for i in tran:
        if(i=='D'):
            amt+=int(tran[1])
        elif(i=='W'):
            amt-=int(tran[1])
print(amt)