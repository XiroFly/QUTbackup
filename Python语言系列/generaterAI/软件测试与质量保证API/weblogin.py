# app.py
from flask import Flask, render_template, request

app = Flask(__name__,template_folder='D:/Users/fly/Python/generaterAI/软件测试与质量保证API/')

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/login', methods=['POST'])
def login():
    username = request.form['username']
    password = request.form['password']

    # 在真实应用中，这里应该有验证用户名和密码的逻辑

    if username == 'testuser' and password == 'testpassword':
        return 'Login successful'
    else:
        return 'Login failed'

if __name__ == '__main__':
    app.run(debug=True)
