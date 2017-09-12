from math import sin, cos, tan, pi
sum=lambda x,y:x+y
print(sum(11,9))

add1=list(map(lambda x,y:x+y,[1,2,3,4,5,6],[11,12,13,14,15,16]))
print(add1)
add2=list(map(lambda x:x*x,[1,2,3,4,5,6]))
print(add2)

def map_functions(x, functions):
    res = []
    for func in functions:
        res.append(func(x))
        return res
family_of_functions = (sin, cos, tan)
print(map_functions(pi, family_of_functions))

numberList=[1,2,3,4,5,6,7,8,9,10,11]
odd=list(filter(lambda x: x % 2, numberList))
print(odd)

s="onkar"+"deshpande"
print(s)