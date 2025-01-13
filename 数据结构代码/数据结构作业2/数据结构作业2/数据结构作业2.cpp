// 数据结构作业2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
using namespace std;
struct stack {
    int array[100];
    int i = -1;
    int pop() {
        if(!isEmpty())
        return array[i--];
    }
    void push(int a) {
         array[++i]=a;
    }
    bool isEmpty() {
        return i == -1;
    }

};
void transform(int jinzhi, int a) {
    stack st;
    for (;a!=0;) {
        st.push(a % jinzhi);
        a /= jinzhi;
    }
    cout << "进制为" << jinzhi << "：";
    for (; !st.isEmpty();) {
        cout << st.pop();
    }
    cout << '\n';
}
struct queue {
    struct node {
        node() {}
        node(int order,string name){
            this->name = name;
            this->order = order;
        }
        int order=-1;
        string name;
        node* p = nullptr;
   };
    node* begin=new node();
    node* end = begin;
    bool isEmpty() {
        return begin->p ==nullptr ;
    }
    void enter(string name) {
        end->p = new node(end->order + 1, name);
        end = end->p;
    }
    void exit() {
        node* p = begin->p->p;
        cout << "现在轮到" << begin->p->name<<"\n";
        delete begin->p;
        begin->p = p;
    }
    void inquire(string name) {
        node* p = begin->p;
        while (p != nullptr) {
            if (p->name == name) { cout << name << ":您的序号为" << p->order - begin->p->order; return; }
            else {
                p = p->p;
            }
        }
        cout << "查无此人";
    }
};
int main()
{
    int jinzhi, a;
    cin >> jinzhi >> a;
    transform(jinzhi, a);
    queue treat;
   while(true){
       cout << "\n看病模拟程序\n" << "1:排队" << " 2:就诊\n" << "3:查询" << " 4:退出\n";
       int b; cin >> b;
       switch (b) {
       case 1: {
           string name;
           cout << "你的名字:";
           cin >> name;
           treat.enter(name);
           treat.inquire(name);//输出序号；
           break; }
       case 2: {
           treat.exit();
           break;
       }
       case 3: {
           string name;
           cout << "你的名字:";
           cin >> name;
           treat.inquire(name);
           break;
       }
       case 4: {exit(0); }
       }
    }

  
}

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门使用技巧: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
