from operator import itemgetter
list = []
while True:
    inps =input()
    if not inps:
        break
    list.append(tuple(inps.split(",")))
print(sorted(list, key=itemgetter(0,1,2)))