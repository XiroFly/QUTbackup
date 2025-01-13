import os
def fun1(path,newpath):
    def fun12(path):
        file_contents=[]
        lis= os.listdir(path)
        for i in lis:
          file_path= os.path.join(path,i)
          if os.path.isfile(file_path):
            with open(file_path,encoding="utf-8") as fp:#要编码
                file_contents.append(fp.read())
        return(file_contents)
    file_contents=fun12(path)
    with open(newpath,"w")as fp:
       fp.writelines(file_contents)
def fun2():
    try:
        fp=None
        fp= open("application2/不存在.txt","r")
    except FileNotFoundError:
        print("处理错误")
    finally:
        if fp is not None:
            fp.close()
   
fun1(r"D:\Users\fly\Python\application2",r"D:\Users\fly\Python\application2\作业三.txt")
