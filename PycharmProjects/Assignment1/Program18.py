import re

list=[]
password=[x for x in input("Enter Passwords : ").split(',')]
for p in password:
    if(len(p)<6 or len(p)>12):
        continue
    if not re.search("[a-z]", p):
        continue
    elif not re.search("[0-9]", p):
        continue
    elif not re.search("[A-Z]", p):
        continue
    elif not re.search("[$#@]", p):
        continue
    elif re.search("\s", p):
        continue
    else:
        pass
    list.append(p)
    print(",".join(list))
