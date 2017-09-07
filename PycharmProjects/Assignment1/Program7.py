x,y=int(input("Enter the value of x :")),int(input("Enter the value of y :"))
matrix=[[0 for j in range(y)]for i in range(x)]
for i in range(x):
    for j in range(y):
        matrix[i][j]=i*j
print(matrix)