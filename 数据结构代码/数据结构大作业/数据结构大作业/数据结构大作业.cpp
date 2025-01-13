// 数据结构大作业.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
using namespace std;
#include <iomanip>
#define max 2001
//最小花费
//第一行输入两个正整数n, m，分别表示总人数和可以互相转账的人的对数。
//1 <= n <= 2000。以下m行每行输入三个正整数x, y, z，
//表示标号为x的人和标号为y的人之间互相转账需要扣除z% 的手续费(z < 100)。
//    最后一行输入两个正整数A, B。数据保证A与B之间可以直接或间接地转账。
//    【输出】A使得B到账100元最少需要的总费用。精确到小数点后8位。 
struct node {
    int key = 0;
    int weight = 100;
    node* p = nullptr;
    node(int key,int weight):key(key),weight(weight){}

   
};
struct  headnode {
    node* p=nullptr;
    void add(int key, int weight) {
        if (this->p == nullptr)this->p = new node(key, weight);
        else {
            node* p = this->p;
            while (p->p != nullptr) {
                p = p->p;
            }
            p->p = new node(key, weight);
        }
    }

};
void find(headnode*head, int n,int m,int A, int B) {
    int path[max];
    int aggregateA[max] = { 0 }; double aggregateB[max]={0};
   //B里放权值，A代表两个集合；A[i]=i为集合一，反之集合二
    aggregateA[A] = A; aggregateA[0] = -1;//A[i]==A[0]则已经考虑完，此i在集合一里去除
    path[A] = A; aggregateB[A] = 1;
    while (true) {
        for (int i = 1; i <= n; i++) {
            if (aggregateA[i] == i) {
                for(node *p=head[i].p; p!=nullptr; p=p->p)
                    if (p->weight < 100) {
                        double t = aggregateB[i] * (100 - p->weight) / 100;//越大越好
                        if (aggregateB[p->key] < t) {//比较
                            aggregateB[p->key] = t;
                            path[p->key] = i;
                            if (aggregateA[p->key] != -1)aggregateA[p->key] = p->key;
                        }
                    }
                aggregateA[i] = -1;
            }
           
          
        }
        for (int i = 1; i <= n; i++) {//终止循环条件
            if (aggregateA[i] == i)continue;
        }
        break;
    }
    cout << fixed << setprecision(8) << 100 / aggregateB[B];

}
int main()
{
    
    int n, m; cin >> n >> m;
    headnode* head = new headnode[n+1];
    int a, b, z;
    for (int i = 0; i < m; i++) {
        cin >> a >> b >> z;
        head[a].add(b, z);
    }
    int A, B; cin >> A >> B;
    find(head,n, m, A, B);

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
