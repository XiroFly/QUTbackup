// 数据结构4试验.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
using namespace std;
struct NodeOfMargin {
	NodeOfMargin(int data, int weight) :data(data), weight(weight) {}
	int data;//定点编号；
	int weight;//点权值和边权值
	NodeOfMargin* p=nullptr;
};
struct NodeOfhead {
	NodeOfhead(int n) :data(n){}
	int data;
	NodeOfMargin* p=nullptr;
};

void bfs( NodeOfhead *heads, int v) {
	int queue[6] = { 0 };
	int i = 0, j = 0 ;
	static int visited[5]{ 0 };
	queue[i] = v;
	i = (i + 1) % 6;
	visited[queue[j]] = 1;
	for (;i!=j;) {
		cout << heads[queue[j]].data << " ";	
		for (NodeOfMargin* p = heads[queue[j]].p; p != nullptr; p = p->p) {
			if (visited[p->data-1] == 0) {
				queue[i] = p->data-1;
				i = (i + 1) % 6;
				visited[p->data-1] = 1;//进队时标记

			}
		}
		j = (j + 1) % 6;

		
	}
	
	
}
void dfs(NodeOfhead* heads, int v) {
	static int visited[5]{ 0 };
	visited[v] = 1;
	cout << heads[v].data << " ";
	for (NodeOfMargin* p=heads[v].p; p != nullptr; p = p->p) {
	if(visited[p->data-1]==0)	dfs(heads, p->data-1);
	}
}
int  main()
{
	
	NodeOfhead * heads = new NodeOfhead[5]{1,2,3,4,5};
	heads[0].p = new NodeOfMargin(2, 7);
	heads[0].p->p = new NodeOfMargin(5, 5);
	heads[1].p = new NodeOfMargin(1, 7);
	heads[1].p->p = new NodeOfMargin(4, 9);
	heads[1].p->p->p = new NodeOfMargin(3, 1);
	heads[2].p = new NodeOfMargin(2, 1);
	heads[3].p = new NodeOfMargin(2, 9);
	heads[4].p = new NodeOfMargin(1, 5);
	dfs(heads, 1);
	cout << "\n";
	bfs(heads, 1);
  
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
