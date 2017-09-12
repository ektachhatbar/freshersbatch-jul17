import datetime
class Person:
    def __init__(self,birthdate):
        self.birthdate = birthdate
    def age(self):
        today = datetime.date.today()
        age = today.year - self.birthdate.year
        if today < datetime.date(today.year, self.birthdate.month, self.birthdate.day):
            age -= 1
        return age
person = Person(datetime.date(1995, 9, 11))
print(person.age())