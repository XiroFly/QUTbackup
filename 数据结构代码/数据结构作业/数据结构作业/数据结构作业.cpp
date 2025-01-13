// 数据结构作业.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include<algorithm>
#define   Max 50 
#define Min -100
using namespace std;
struct chart1 {
    int length=0;
    int *shuzu = new int[Max];
    chart1(int n) {
        length = n ;
        for (int i = 0; i < n; i++) {
            cin >> shuzu[i];
        }
        sort(shuzu,shuzu+n);
    }
    chart1(){}
    static chart1& jiaoji(chart1& ch1,chart1& ch2) {
        chart1* ch = new chart1();
        for (int i = 0, j = 0, z = 0;j<ch2.length&&i<ch1.length;) {
            if (ch1.shuzu[i] == ch2.shuzu[j]) { ch->length++; ch->shuzu[z] = ch1.shuzu[i]; cout << ch->shuzu[z] <<" "; i++; j++; z++; }
            else if (ch1.shuzu[i] < ch2.shuzu[j])i++;
            else j++;
        }
        return *ch;
    }
};
struct chart2 {
    struct jiedian {
        jiedian(int a) {
            data = a;
        }
        jiedian(){}
        int data;
        jiedian* next = nullptr;
    };
    jiedian* head=new jiedian(Min);//头结点
    jiedian* jd=head;
    chart2() {
        int a;
        
        while (cin >> a) {
           jiedian* p=  new jiedian(a);
            for (;;) {//排序
                if (jd->data<a && jd->next != nullptr && jd->next->data>a) { p->next = jd->next; jd->next = p; break; }
                else if (jd->next == nullptr) { jd->next = p; break; }
                    else { jd = jd->next; }
            }
        }
        cin.clear();
        cin.ignore(3,'/n');
        cout << "ok" << endl;
    
        
    }

    static void jiaoji(chart2& ch1, chart2& ch2) {
        for (jiedian*p1=ch1.head->next,*p2=ch2.head->next;p1!=nullptr&&p2!=nullptr;) {
            if (p1->data == p2->data) { cout << p1->data << " "; p1 = p1->next; p2 = p2->next; }
            else if (p1->data > p2->data)p2 = p2->next;
            else p1 = p1->next;
        }
    }


};
int main()
{
    chart1 ch1 = chart1(5);
    chart1 ch2 =  chart1(6);
    chart1::jiaoji(ch1,ch2);
    chart2 ch3 = chart2();
    chart2 ch4 = chart2();
    chart2::jiaoji(ch3, ch4);
   
    
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
