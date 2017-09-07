lines=[]
while True:
    line=input()
    if(line):
        lines.append(line.upper())
    else:
        break
print("\n".join(lines))