even=[]
for s in range(1000,3001):
    i=str(s)
    if((int(i[0]))%2==0 and (int(i[1]))%2==0 and (int(i[2]))%2==0 and (int(i[3]))%2==0):
        even.append(i)
print(",".join(even))