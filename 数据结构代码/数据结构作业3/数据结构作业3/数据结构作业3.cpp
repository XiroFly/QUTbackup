// 数据结构作业3.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
using namespace std;
    struct node {
        int data;
        node* left = nullptr; bool ltag=false;
        node* right = nullptr; bool rtag=false;
        node(int n) {
            data = n;
        }
    };
    
    struct Dlinkchart {//构造一个查找树1-20
        node* root = nullptr;
        void  put(node* head ,int n) {
            if (head == nullptr) {
                head = new node(n);
                this->root = head;
                return;
            }
            if (n> head->data&&head->right!=nullptr ) {
                return put(head->right,n);
           }
            if (n < head->data&&head->left!=nullptr) {
                return put(head->left, n);
             }
            if (n > head->data) {
                head->right = new node(n);
            }
            else {
                head->left = new node(n);
            }
        }
        Dlinkchart(int (& ap)[20]) {
            for (int i = 0; i < 20; i++) {
                put(root, ap[i]);
            }
          
        }
       static void preOrder(node*head) {
           if (head != nullptr) {
               cout << head->data << " ";
               preOrder(head->left);
               preOrder(head->right);
           }
        }
       static void postOrder(node*head) {
           if (head != nullptr) {
               postOrder(head->left);
               postOrder(head->right);
               cout<<head->data<<" ";
           }
       }
       //将二叉链表中序线索化    
      
       void threaded(node* root) {
           if (root == nullptr)return;
           static node* pre = nullptr;
           if (root->left != nullptr) {
               
                threaded(root->left);
           }
           else {
               root->left = pre;  root->ltag = true; //什么时候p和pre确定是关键；
               pre = root; 
                   return threaded(root->right);
           
           }
           if (pre != nullptr) {
               if (pre->right == nullptr) { pre->right = root; pre->rtag = true; }
           }
           pre = root;
          
           if (root->right != nullptr) {
               threaded(root->right);
           }
          
       }
       static void inthorder(node* root) {//线索化中序遍历
           node* p = root;
           while (p!=nullptr) {
               for (;;) {
                   if (p->ltag != true)p = p->left;
                   else break;
               }
               for (; ;) {
                   cout << p->data << " ";
                   if (p->rtag == true) { p = p->right; }
                   else { p = p->right; break; }
               }
           }
       }
          
       

    };
            
int main()
{
    int ap[20];//随机化
    ap[0] = rand() % 20 + 1;
    for (int i = 1; i < 20; i++) {
        ap[i] = rand() % 20 + 1;
        for (int j = 0; j < i; j++) {
            if (ap[j] == ap[i]) {
                i--; break;
            }
        }
    }
    Dlinkchart *ch = new Dlinkchart(ap);
    cout << "前序："; Dlinkchart::preOrder(ch->root); cout << '\n';
    cout << "后序："; Dlinkchart::postOrder(ch->root); cout << '\n';
    ch->threaded(ch->root);
    Dlinkchart::inthorder(ch->root);


    

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
