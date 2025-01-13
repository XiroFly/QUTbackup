my_list=[1,2,3,4,5]
print(my_list[-1::-1])
my_tuple=tuple(my_list)
for i in my_tuple:
    print(i,end=" ")
my_s=set(my_list)
print("len="+str(len(my_s)))
my_d= {'a': 1, 'b': 2, 'c': 3}
print(my_d) 
while age:=int(input("输入年龄")): 
    if age<18:
        print("未成年人")
    elif age>=18 and age<60:
        print("成年人")
    else :print("老年人") 
mylist=[i for i in range(1,6)]
for i in mylist:
    if i%2!=0:
        print(pow(i,2))
import re
def fun (match):
       return match.group().upper()
mystr=input("输入字符串\n")
str_= re.sub(r"\b[a-z]",fun ,mystr)
print(str_)
class counter:
    a=0
    def __init__(self,a) -> None:
        self.a=a
    @staticmethod
    def add(a,b):
        print(a+b)
    def delete(self,b):
        print(self.a/b)
    def minus(self,b):
        print(self.a-b)
    def multiply(self,b):
        print(self.a*b)
b=counter(4)
counter.add(5,7)
b.delete(7)
b.minus(7)
b.multiply(7)

