#include<iostream>
#include<algorithm>
using namespace std;
int arr[(int)5e5 + 1]={0};
int n, m, a, b, c;
int lowbit(int a) {
	return a & -a;
}
void update(int x, int data) {
	while (x <= n) {
		arr[x] += data;
		x += lowbit(x);
	}
}
int sum(int x) {
	int sum=0;
	while (x>0) {
		sum += arr[x];
		x -= lowbit(x);
	}
	return sum;
}
int main() {
	
	cin >> n >> m;
	for (int i = 1; i <=n; i++) {
		cin >> a;
		update(i, a);
	}
	while (m-- > 0) {
		cin >> a >> b >> c;
		if (a == 1) {
			update(b, c);
		}
		else cout << sum(c)-sum(b-1)<<"\n";
	}
	return 0;
}