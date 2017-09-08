def yrange(n):
    i = 0
    while i < n:
        if(i%7==0):
            yield i
        i += 1
y= yrange(15)
print(y)
print(next(y))
print(next(y))
print(next(y))
