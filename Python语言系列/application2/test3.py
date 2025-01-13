# 1. 写一个程序，读取一个文件的内容，并将文件中包含的所有单词按照字母顺序排序后输出到另一个文件中。
# 2.写一个程序，遍历一个文件夹内的所有文件和子文件夹，并打印出所有文件的文件名。
# 3.编写一个程序，提示用户输入两个数字，并计算它们的商。如果用户输入的第二个数字为0，程序应该抛出一个异常并提示用户不能除以0。
# 4.编写一个程序，提示用户输入一个文件名，并读取该文件的内容。如果文件不存在，程序应该抛出一个异常并提示用户文件不存在。
#软件213白鹏飞202111050676
import re
import os
def fun(match):
   return match.group()
def fun1():
   with open(r"D:\Users\fly\Python\application2\test3.txt","r") as f:
     string= f.read()
     file_list=re.findall("[a-zA-Z]+",string)
     file_list.sort()
   with open(r"D:\Users\fly\Python\application2\test33.txt","w") as fs:
       for i in file_list:
        fs.write(str(i)+" ")

def fun2(path):
 thelist= os.walk(path)
 for root, dirs,files in thelist:
    for file in files:
       print(file)
def fun3():
   a=int(input(" 输入第一个数字: "))
   b=int(input(" 输入第二个数字: "))
   try:
      if b==0:
         raise Exception("用户不能除以0\n")
   except : raise 
   else :print(a/b)
def fun4():
   string= input("输入文件名\n")
   try:
      file= open(string,"r",encoding="utf-8")
      print(file.read())
   except FileNotFoundError:
      print(FileNotFoundError("用户文件不存在。"))
   finally:file.close()
fun4()

