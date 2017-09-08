sen=input("Enter a Sentence : ")
u,l=0,0
for s in sen:
    if(s.isupper()):
        u+=1
    elif(s.islower()):
        l+=1
print("UpperCase : ",u)
print("LowerCase : ",l)