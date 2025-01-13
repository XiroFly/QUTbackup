import openai
import os
import tkinter as tk
OPENAI_API_KEY = ""
openai.api_key = OPENAI_API_KEY
os.environ["http_proxy"]="http://localhost:7890"
os.environ["https_proxy"]="http://localhost:7890"
#多轮对话，把历史message作为参数传进去
def get_completion_from_messages(messages, model="gpt-3.5-turbo", temperature=0):
    response = openai.ChatCompletion.create(
        model=model,
        messages=messages,
        temperature=temperature, # 控制模型输出的随机程度
    )
    return response.choices[0].message["content"]
# 现在我们已经给模型提供了上下文，也就是之前的对话中提到的我的名字，然后我们会问同样的问题，也就是我的名字是什么。因为模型有了需要的全部上下文，所以它能够做出回应，就像我们在输入的消息列表中看到的一样。
context = [{'role':'system', 'content':"""
        你是订餐机器人，为披萨餐厅自动收集订单信息。
        
        你要首先问候顾客。然后等待用户回复收集订单信息。收集完信息需确认顾客是否还需要添加其他内容。
        最后需要询问是否自取或外送，如果是外送，你要询问地址。
        最后告诉顾客订单总金额，并送上祝福。
        请确保明确所有选项、附加项和尺寸，以便从菜单中识别出该项唯一的内容。
        你的回应应该以简短、非常随意和友好的风格呈现。
        菜单包括：
        菜品：
        意式辣香肠披萨（大、中、小） 12.95、10.00、7.00
        芝士披萨（大、中、小） 10.95、9.25、6.50
        茄子披萨（大、中、小） 11.95、9.75、6.75
        薯条（大、小） 4.50、3.50
        希腊沙拉 7.25
        配料：
        奶酪 2.00
        蘑菇 1.50
        香肠 3.00
        加拿大熏肉 3.50
        AI酱 1.50
        辣椒 1.00
        饮料：
        可乐（大、中、小） 3.00、2.00、1.00
        雪碧（大、中、小） 3.00、2.00、1.00
        瓶装水 5.00
        """} ]
# 根据用户输入text，生成类似{'role':'user', 'content':f"{text}"}的用户消息
def generate_user_message(text):    
    return {'role':'user', 'content':f"{text}"}
# 根据LLM响应response，生成类似{'role':'assistant', 'content':f"{response}"}的用户消息
def generate_assistant_message(response):
    return {'role':'assistant', 'content':f"{response}"}
# 根据requirement，生成类似{'role':'system', 'content':f"{requiremen}"}的系统消息
def generate_system_message(requiremen):
    return {'role':'system', 'content':f"{requiremen}"}
# 将一条{'role':'user', 'content':""}的消息添加到context中
def upgrade_context(message):
    context.append(message)
    return context
# # 通过context/messages，生成可展现的结果，并展现在panel中
def update_chat(messages):
 content = ""
 for message in messages:
    if message["role"] == "user":
        content += f"我: {message['content']}\n"
    elif message["role"] == "assistant":
        content += f"机器人: {message['content']}\n"
 chat_text.delete(1.0, tk.END)
 chat_text.insert(tk.END, content)
# 创建一个主窗口
root = tk.Tk()
root.title("食物点餐机器人")
# 创建一个文本输入框和按钮
frame = tk.Frame(root, padx=10, pady=10)
frame.pack()
text_input = tk.Entry(frame, width=50)
text_input.pack(side=tk.LEFT)
button2 = tk.Button(frame, text="结账", command=lambda: on_button2_click())
button2.pack(side=tk.RIGHT)
button = tk.Button(frame, text="聊天", command=lambda: on_button_click(text_input.get()))
button.pack(side=tk.RIGHT)
# 创建一个文本框，用于显示聊天消息
chat_frame = tk.Frame(root, padx=10, pady=10)
chat_frame.pack()
chat_text = tk.Text(chat_frame, width=50, height=80)
chat_text.pack()
# 定义一个函数，用于处理聊天按钮点击事件
def on_button_click(text):
    # 依据用户输入文本，生成用户消息
    message = generate_user_message(text)
    # 更新上下文
    context = upgrade_context(message)
    # 请求LLM获取响应w
    response = get_completion_from_messages(context)
    # print(response)    
    # 依据响应文本，生成助手消息
    assistant_message = generate_assistant_message(response)
    # 更新上下文
    upgrade_context(assistant_message)
    # 根据上下文更新聊天面板内容
    print(context)
    update_chat(context)
# 定义一个函数，用于处理结账按钮点击事件
def on_button2_click():
    # 创建不改变context的临时context，用以同LLM通信
    temp_context =  context.copy()
    # 创建临时系统消息
    temp_system_message = generate_system_message("创建上一个食品订单的 json 摘要。\
    逐项列出每件商品的价格，字段应该是 1) 披萨，包括大小 2) 配料列表 3) 饮料列表，包括大小 4) 配菜列表包括大小 5) 总价")
    # 更新临时上下文
    temp_context.append(temp_system_message)
    # 请求LLM获取响应
    response = get_completion_from_messages(temp_context)
    # print(response)    
    # 依据响应文本，生成助手消息
    assistant_message = generate_assistant_message(response)
    # 更新上下文
    temp_context.append(assistant_message)
    # 更新聊天面板内容
    # print(temp_context)
    update_chat(temp_context)
# 运行主循环
root.mainloop()