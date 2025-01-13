// 数据结构试验5.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
using namespace std;
struct SequentialList {
    int data[50];
    int lenth = 50;
    SequentialList() {
        for (int i = 0; i < 50; i++)data[i] = i+7;
    }
    int  binarySearch(int x) {
        static int min = 0; static int max = 49;
        int mid = min + (max - min) / 2;
        if (max <= min)return -1;
        if (data[mid] == x)return mid;
        if (data[mid] < x) { min = mid + 1; return binarySearch(x); }
        if (data[mid] > x) { max = mid - 1; return binarySearch(x); }
        
    }
};
struct node {
    int data;
    node* left = nullptr;
    node* right = nullptr;
    node(int n) {
        data = n;
    }
};
struct Dlinkchart {//构造一个查找树1-50
    node* root = nullptr;
    void  put(node* head, int n) {//插入
        if (head == nullptr) {
            head = new node(n);
            this->root = head;
            return;
        }
        if (n > head->data && head->right != nullptr) {
            return put(head->right, n);
        }
        if (n < head->data && head->left != nullptr) {
            return put(head->left, n);
        }
        if (n > head->data) {
            head->right = new node(n);
        }
        else {
            head->left = new node(n);
        }
    }
    Dlinkchart(int(&ap)[50]) {
        for (int i = 0; i < 50; i++) {
            put(root, ap[i]);
        }

    }
    node* search( int x ,int mode) {//mode==1:删除，mode==0：查找//选择static，多次调用时就要维护return时再次初始化
        static node* root = this->root,*p=nullptr;
        static int c;//c==0时删除左子节点，==1删除右子节点
        if (root->data == x) {
            if (mode == 1) {
                if (c == 0) {
                    change(p,c);init(root,p); return nullptr;
                }
                else { change(p,c); init(root, p); return nullptr; }
            }
            else return init(root, p);
        }
        if (x<root->data) {
            if (root->left != nullptr) {
                p = root; c = 0;
                root = root->left;  return search(x,mode);
            }
            else {
                init(root, p);
                return nullptr;
            }
        }
        if (x>root->data) {
            if (root->right != nullptr) {
                p = root; c = 1;
                root = root->right; return search(x,mode);
            }
            else {
                init(root, p);
                return nullptr;
            }
        }
    }
private:
    node* init(node*&root,node*&p){//static变量再次初始化
        node* node = root;
        root = this->root;
        p = nullptr;
        return node;
    }
    void change(node*p,int c ) {
        if (p == nullptr) { this->root = nullptr; delete this->root; }//p为空则只有头结点；
        node* pl,*pr;//左右节点
        if (c == 0) {
            pl = p->left->left;
            pr = p->left->right;
            delete p->left;
            if (pr != nullptr) {
                p->left = pr;
                node* ptr = pr;
                while (ptr->left != nullptr) { ptr = ptr->left; }
                ptr->left = pl;
            }
            else { p->left = pl; }
            
        }
        else {
            pl = p->right->left;
            pr = p->right->right;
            delete p->right;
            if (pr != nullptr) {
                p->right = pr;
                node* ptr = pr;
                while (ptr->left != nullptr) { ptr = ptr->left; }
                ptr->left = pl;
            }
            else { p->right = pl; }
        }
    }


};
int main()
{
    SequentialList a=SequentialList();
    cout << a.binarySearch(40)<<"\n";//查找40
    int array[50];//构造随机化数组；
    for (int i = 0; i < 50; i++) {
        array[i] = rand() % 50;
        for (int j = 0; j < i; j++) {
            if (array[i] == array[j]) { i--; break; }
        }
    }
    Dlinkchart ch (array);
    ch.put(ch.root, 50);
    cout << ch.search(45, 0)->data<<"\n";  
    ch.search(45, 1);
    cout << (nullptr == ch.search(45, 0));//判断是否为空；




   



    
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
