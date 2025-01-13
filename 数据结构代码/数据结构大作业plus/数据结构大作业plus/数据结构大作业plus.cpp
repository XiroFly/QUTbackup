// 数据结构大作业plus.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//教学安排
#include <iostream>
#include<stdio.h>
using namespace std;

struct onecourse {
	char*  name=nullptr;
	char* identity=nullptr;
	int credit=0;
	onecourse(){}
	void	assignment(char* name, char* identity) { this->name = name; this->identity = identity; }
	void  getcredit(int credit) { this->credit = credit; }
};
struct oneteam {
	static int* allcourse;
	static int maxcredit;
	static onecourse*  oc;
	int index=0;
	int curcredit=0;
	oneteam(){}
	oneteam( int index): index(index) {
	}
	bool add(int course) {
		if (course <= 0)return false;
		if (curcredit + oc[course].credit <= maxcredit) {
			allcourse[course] = index; return true;
		}
		else return false;
	}
};
struct nodeofall {
	static int length;
	oneteam ot;
	nodeofall* next=nullptr;
};
struct stack {
	int weight=0,start=0;
	int* sum;
	int i = -1;
	stack(int length) {
		sum = new int[length]{0};
	}
	int length = 0;
	void add(int x) { sum[++i] = x; length++; }
	int  del() { 
		if (i == -1)return -1;
		return sum[i--]; }
	bool check(int x) {
		for (int j = 0; j <= i; j++) {
			if (sum[j] == x) {
				
				return true;
			}
		}
		return false;
	}
	static bool exist(int x,int i,stack &st) {
		for (int j = 0; j <= i; j++) {
			if(st.sum[st.length-j] == x)return true;
		}
		return false;
	}
	void recycle() { i = length - 1; }
};
struct node {
	static stack* del(node* ptr,int i) {
		node* p =  ptr;
		while (p!=nullptr) {
			if (p->val->weight == i && p->val->i != -1)return p->val;//p->val->del()
			if (p->val->weight > i)break;
			else p = p->next;
		}
		//end>i,start<i
		while (p != nullptr) {
			if (p->val->start < i&&p->val->i!=-1)return p->val;
			if (p->val->start >= i)break;
			else p = p->next;
		}
		return nullptr;


	}
	stack * val;
	node* next = nullptr;
	node(int  length) {
		val = new stack(length);
	}
};

void dfs(int **array,int i,int length,stack &st) {
	 stack stc(length);	
	 if (stc.check(i)) { cout << "逻辑错误\n"; exit(-1); };
	stc.add(i);
	for (int j = 0; j < length; j++) {
		if (array[i][j] == 1)dfs(array, j, length, st);
	}
	if(!st.check(i))st.add(i);
	
}
 int  nodeofall::length = 0;
 int * oneteam::allcourse = nullptr;
 int  oneteam::maxcredit = 0;
 onecourse* oneteam::oc = nullptr;
int main()
{
	FILE* pt;
	 fopen_s(&pt, "class.txt", "rt");
	if (pt == nullptr) { cout << "wrong"; return 0; }
	int team, credit, course;//程序设计基础
	fscanf_s(pt, "%d", &team);
	fscanf_s(pt, "%d", &credit);
	fscanf_s(pt, "%d", &course);
	
	int** array = new int* [course + 2];
	for (int i = 0; i < course + 2; i++) {
		array[i] = new int[course + 2]{0};
		
	}
	for (int i = 1; i < course + 1; i++) {
		array[0][i] = 1;
		array[i][course + 1] = 1;
	}
	onecourse* oc = new onecourse[course + 2];
	for (int i = 1; i < course + 1; i++) {
		char* a = new char[15]{ "\0"};
		char* b = new char[15]{ "\0"};
	     int c;
		cout<< fscanf_s(pt, "%s %s %d", a,15, b,15, &c);
		oc[i].getcredit(c);
		oc[i].assignment(a, b);
		char tem;
		
		for (fscanf_s(pt, "%c", &tem,1); tem != '\n'; fscanf_s(pt, "%c", &tem,1)) {
			int j=0;
			cout<<fscanf_s(pt, "%d", &j);
			array[j][i] = 1;
		}
	}
	fclose(pt);
	stack st(course + 2);
	dfs(array, 0, course + 2, st);
	//最长路径
	int* route = new int[course + 2]{0};
	int* weight = new int[course + 2]{0};
	while (st.i != 0) {
		int i = st.del();
		for (int j = 0; j < course + 2; j++) {
			if (array[i][j] == 0)continue;
			if (array[i][j] + weight[i] > weight[j]) {
				weight[j] = array[i][j] + weight[i];
				route[j] = i;
			};

		}

	}
	stack longest(course + 2);
	for (int i = course + 1; i != 0; ) {
		longest.add(i);
		i = route[i];
	}
	longest.add(0);
	int length = course + 2 - longest.length;
	//只能链表不能数组
     node* head = new node(length); node* p = head;
	
	for (int i = 1; i < course + 1; i++) {
		for (int j = 1; j < course + 1; j++) {
			if (array[j][i] == 1&& !stack::exist(j,i, longest)) {

				p->next = new node(length);
				p->next->val->weight = i;
				for (int js=j; ; ) {
					if (!stack::exist(js, i, longest)) {
						p->next->val->add(js);
						js = route[js];
					}
					else { p->next->val->start = js; break; }
				}
				p = p->next;
			}
			
		}
	
	}
/////
	//
	//////
	 oneteam::allcourse = new int[course + 2]{ 0 };
	   oneteam::maxcredit = credit;
	 oneteam::oc = oc;
	//
	nodeofall* header = new nodeofall[longest.length];
	nodeofall* ptr = header;
	nodeofall* ptr1 = header+1;
	int index = 2;
	ptr->ot.index = 0;
	ptr->ot.add(longest.del());
	ptr = header+1;
	ptr->ot.index = 1;
	ptr->ot.add(longest.del());
	auto ptr2 = ptr1;
	for (int i=1;i<longest.length-1;) {
			while (true) {
				
				auto object = node::del(head->next, i + 1);
				if (object == nullptr)break;
				if (ptr1->ot.add(object->del()));
				else if (object->weight == i + 1) { ptr1->next = new nodeofall; ptr1 = ptr1->next; ptr1->ot.index = index++; ptr1->ot.add(object->del()); }
				else { ptr1 = ++ptr2; ptr1->ot.index=index++; ptr1->ot.add(object->del()); break; }
			}


			//0 1 2 3 1 4 1 5 0 1 1 1 0 6
		ptr = header + ++i;
		if(ptr->ot.index==0) ptr->ot.index = index++;
		ptr->ot.add(longest.del());
		
		
	}
	cout << "\n";
	for (int i =0 ; i < course + 2; i++) {
		cout << oneteam::allcourse[i] << " ";
		
	}
	cout << "\n";
	for (int i = 0; i < course + 2; i++) {
		cout << route[i] << ' ';

	}


	
	/*for (int i = 1; i < index - 1; i++) {
		cout << "学期" << i<<":";
		for (int j = 1; j < course + 1; j++) {
			if (oneteam::allcourse[j] == i) { cout << oc[j].name<<" "; }
		}
		cout << '\n';
	}
	return 0;*/
	
	return 0;




    
	








	





 

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
