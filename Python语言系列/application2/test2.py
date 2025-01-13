# 软件213白鹏飞 202111050676
import math
def greet(name):
    print(f"hello,{name}")
def get_max(a,b):
    return max(a,b)
def square(R):
    return R*R*math.pi
a=lambda string: len(string)
b=lambda x1,x2:max(x1,x2)
class Student:
    def __init__(self,name,age,grade) -> None:
       self.name=name
       self.age=age
       self.grade=grade
    def get_grade(self):
        grade={"A":90,"B":80,"C":70,"D":60,"F":50}
        if self.grade>grade["A"]:
            return "A"
        elif self.grade>grade["B"]:
            return "B"
        elif self.grade>grade["C"]:
            return "C"
        elif self.grade>grade["D"]:
            return "D"
        else :
            return "F"
greet("白鹏飞")
print(get_max(23,25))
print(square(9))
print(a("are"))
print(b(45,89))
student=Student("白鹏飞",21,99)
print(student.get_grade())
