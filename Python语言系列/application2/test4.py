# 1.编写一个程序，在窗口中显示一个“Hello, World!”的标签。
# 2.编写一个程序，在窗口中显示两个文本框和一个按钮。当用户单击按钮时，程序应该将两个文本框中的内容相加并在标签中显示结果。
# 3.编写一个程序，在窗口中显示一个列表框和一个按钮。当用户单击按钮时，程序应该将选定的项从列表框中删除。
# 4.编写一个程序，爬取百度贴吧中某个贴子的所有图片。
from tkinter import *
def application1():
    root=Tk()
    root.geometry("300x300+200+200") 
    root.title("hello")
    label= Label(root,text="hello,world")
    label.pack()
    root.mainloop()    
def application2():
    root=Tk()
    root.geometry("300x300+200+200") 
    root.title("2")
    text1= Entry(root)
    text2=Entry(root)
    text1.pack()
    text2.pack()
    Button(root,text="+",command =lambda:res(text1.get(),text2.get())).pack()
    def res(text1,text2):
        sum= int(text1)+int(text2)
        Label(root,text=sum).pack()
    root.mainloop()
def application3():
    win=Tk()
    def delete():
        index=listbox.curselection()
        if index:
            listbox.delete(index)
    win.title("三")
    win.geometry("300x200")
    listbox=Listbox(win)
    listbox.pack(pady=10,expand=False)
    listbox.configure(height="5",width="10")
    items = ["Item 1", "Item 2", "Item 3", "Item 4"]
    for item in items:
      listbox.insert(END,item)
    Button(win,text="删除",command=delete).pack(side="bottom")
    win.mainloop()
application3()

    