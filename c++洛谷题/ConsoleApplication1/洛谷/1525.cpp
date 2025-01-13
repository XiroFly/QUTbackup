#include<iostream>
#include<algorithm>
using namespace std;
int n, m;
struct con{
	int a;
	int b;
	int c;
}arr[100001];
bool comp(con a,con b) {
	return a.c > b.c;
}
int root(int *arr,int a ) {
	if (arr[a] == a)return a;
	arr[a] = root(arr, arr[a]);
	return arr[a];
}
void merge(int *arr, int a, int b) {
	a = root(arr ,a);
	b = root(arr, b);
	arr[a] = b;
}
int mate[20001]; int enemy[20001];
int main() {
	cin >> n >> m;
	for (int i = 1; i <= m; i++) {
		cin >> arr[i].a >> arr[i].b >> arr[i].c;
	}
	for (int i = 1; i <= n; i++) { mate[i] = i; enemy[i] = i; }
	sort(arr + 1, arr + m + 1, comp);
	for (int i = 1; i < m + 1; i++) {
		if (root(mate, arr[i].b) != root(mate, arr[i].a)) {
			if (enemy[arr[i].b] != arr[i].b)
				merge(mate, arr[i].a, enemy[arr[i].b]);
			else enemy[arr[i].b] = arr[i].a;
			if (enemy[arr[i].a] != arr[i].a)
				merge(mate, arr[i].b, enemy[arr[i].a]);
			else enemy[arr[i].a] = arr[i].b;
			
		}
			else { cout << arr[i].c; return 0; }
	}
	cout << 0;
}