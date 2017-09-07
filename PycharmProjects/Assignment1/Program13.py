sentence=input("Enter a sentence : ")
wcount,dcount=0,0
for w in sentence:
    if(w.isalpha()):
        wcount+=len(w)
    elif(w.isdigit()):
        dcount+=len(w)
print("Letters = ",wcount)
print("Digits = ",dcount)