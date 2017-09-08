class StringTest:
    def __init__(self):
        self.str=""
    def getString(self):
        self.str=input("Enter String : ")
    def printString(self):
        print(self.str.upper())
obj=StringTest()
obj.getString()
obj.printString()