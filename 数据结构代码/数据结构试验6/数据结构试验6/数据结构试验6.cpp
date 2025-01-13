// 数据结构试验6.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include<cstdlib>
#include<time.h>
using namespace std;
//#define max 100
struct Sequence {
	static const int max = 100;
	int array[max]={0};
	int length = 0;
	
	Sequence(int* array, int n) {
		length = n;
		for (int i = 0; i < n;i++) {
			this->array[i] = array[i];
		}
	}
	void print() {
		int i = -1;
		while (++i != length) {
			cout << array[i] << " ";
		}
		cout << "\n";
	}
	void bubblesort(){
		
		for (int i = 0;i< length - 1; i++) {
			for (int j = 0;j< length - 1 -i; j++) {
				if (array[j] > array[j + 1]) { exchange(array[j], array[j + 1]); }
			}
		}
		cout << "这是冒泡排序：";  print();
	}
	void Heapsort() {//从小到大
		for (int i = length / 2; i >= 1; i--) {
			sink(i - 1,length);
		}
		for (int j = length - 1;j>0;) {
			exchange(array[0], array[j--]);
			sink(0,j+1);//长度变为j+1；
		}
		cout << "这是堆排序："; print();
	}

	//保证效率需要将数组随机化
	void Qsort(int lo,int hi) {
		if (lo >= hi)return;
	int a=	qsort(lo, hi);
	Qsort(lo, a-1);
	Qsort(a+1, hi);
	
	}
private :
	int  qsort( int lo,int hi) {
		int i = lo , j = hi+1;
		while (true) {
			while (array[++i] < array[lo])if (i == hi)break;//防止越界//找到array【i】>=array[lo];
			while (array[--j] > array[lo]);			
			if (i >= j) {
				exchange(array[lo], array[j]);
				return j;
			}
			exchange(array[i], array[j]);
		}

	}
	void exchange(int &a, int& b) {
		int temp;
		temp = a; a = b; b = temp;
	}
	void swim(int t) {
		int k = t + 1;
		while (array[k / 2-1] < array[k-1]) { exchange(array[k / 2-1], array[k-1]); k = k / 2; }
	}
	void sink(int t,int length) {
		int k = t + 1;
		while (2 * k <= length) {//取等无右子值//下沉结束条件
			if (2 * k < length && array[2 * k - 1] < array[2 * k]) { if (array[k - 1] > array[2 * k])return; exchange(array[k - 1], array[2 * k]); k = 2 * k + 1; }
			else { if (array[k - 1] > array[2 * k - 1])return; exchange(array[k - 1], array[2 * k - 1]); k = 2 * k; }
		}
	}
};
int main()
{
	srand((unsigned int)time(NULL));
	int array[50];
	for (int i = 0; i < 50; i++) {
		array[i] = rand();
		for (int j = 0; j < i; j++)if (array[j] == array[i])i--;
	}
	Sequence se(array, 50);
	cout << "原数组："; se.print();
	/*se.bubblesort();*/
	/*se.heapsort();*/
	se.Qsort(0,49);
	cout << "快速排序："; se.print();
   
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
