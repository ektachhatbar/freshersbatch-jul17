def peep(it):
    print(it)
    return(next(it))
list=[1,2,3]
print(peep(iter(list)))