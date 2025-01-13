import tkinter as tk
from tkinter import scrolledtext
import csv

# 读取 CSV 文件
data = []
with open('subway.csv', newline='') as csvfile:
    reader = csv.reader(csvfile)
    for row in reader:
        data.append(row)

# 存储查询到的结果
infomation = []

# 查询地铁线路
def search_line(sstr):
    global infomation
    result = sstr.split(",")
    if len(result) >= 2:  # 检查分割后是否有足够的元素
        print(result)
        city = result[0].strip()  # 获取城市名
        line = result[1].strip()  # 获取线路编号

        for row in data:
            if row[0] == city and row[1] == line:
                infomation.append(f"{row[0]}  {row[1]}  {row[2]}")

        scr = scrolledtext.ScrolledText(root, width=62, height=43)
        scr.place(x=75, y=200)

        n = len(infomation)
        print(n)
        ss = ''
        for i in range(n):
            print(infomation[i])
            ss = ss + infomation[i] + '\n'
        scr.insert('end', ss)
        infomation = []


# 查询站点
def search_station(sstr):
    global infomation
    for row in data:
        if row[2] == sstr:
            infomation.append(f"{row[0]}  {row[1]}  {row[2]}")

    scr = scrolledtext.ScrolledText(root, width=62, height=43)
    scr.place(x=75, y=200)

    n = len(infomation)
    print(n)
    ss = ''
    for i in range(n):
        print(infomation[i])
        ss = ss + infomation[i] + '\n'
    scr.insert('end', ss)
    infomation = []


if __name__ == '__main__':
    root = tk.Tk()
    root.title("python项目")
    canvas = tk.Canvas(root, height=800, width=600)
    canvas.pack()

    background_image = tk.PhotoImage(file='./bg1.png')
    background_label = tk.Label(root, image=background_image)
    background_label.place(relwidth=1, relheight=1)
    search_text = tk.StringVar()
    search_text1 = tk.StringVar()

    lower_frame = tk.Frame(root, bg='#80c1ff', bd=10)
    lower_frame.place(relx=0.5, rely=0.25, relwidth=0.75, relheight=0.7, anchor='n')

    frame = tk.Frame(root, bg='#80c1ff', bd=5)
    frame.place(relx=0.5, rely=0.1, relwidth=0.75, relheight=0.1, anchor='n')

    entry = tk.Entry(frame, font=40, textvariable=search_text)
    entry.place(relwidth=0.65, relheight=1)

    button = tk.Button(frame, text="查线路", font=40, command=lambda: search_line(search_text.get()))
    button.place(relx=0.7, relheight=1, relwidth=0.3)

    entry1 = tk.Entry(root, font=40, bg='#80c1ff', textvariable=search_text1)
    entry1.place(x=82, y=5, width=280, height=60)

    button1 = tk.Button(text="查站点", font=40, bg='#80c1ff', command=lambda: search_station(search_text1.get()))
    button1.place(x=390, y=5, width=135, height=60)

    root.mainloop()
