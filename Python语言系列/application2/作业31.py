import os
import tkinter as tk

def calculate_file_size():
    file_path = file_path_entry.get()
    if os.path.exists(file_path):
        file_size = os.path.getsize(file_path)#关键
        size_label.config(text=f"文件大小：{file_size} 字节")
    else:
        size_label.config(text="文件不存在")

# 创建主窗口
window = tk.Tk()
window.title("文件大小计算器")

# 创建文本框
file_path_entry = tk.Entry(window, width=50)
file_path_entry.pack(pady=10)

# 创建标签
size_label = tk.Label(window, text="请输入文件路径")
size_label.pack()

# 创建按钮
calculate_button = tk.Button(window, text="计算文件大小", command=calculate_file_size)
calculate_button.pack(pady=10)

# 运行主循环
window.mainloop()
