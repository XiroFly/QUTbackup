using namespace std;
#include<iostream>
#include<cmath>
long long int fun(int i,long long int res,int m ) {
	if (m == 1) { res = 2; return 2; }
	if (i == m)return res;
	if (2 * i <= m) { res *= res; i = 2 * i; return fun(i, res% 6662333, m); }
	else { res = res * fun(1,2,m-i); 	return res % 6662333;
	}
}
int main() {
	long long int n, y = 6662333;
	cin >> n;// ‰»În«Û2^£®m£©%6662333
	 int arr[60]{0};
	if (n == 1) { cout << 1; return 0; };
	n--;
		long long ress = 2;
		arr[0] = 1;
		arr[1] = 2;
		for (long long int i = 1; true;) {
			if (i * 2 <= n) {
				ress = (ress * ress) % y; arr[int(log2(2 * i))] = ress; 
				i = 2 * i;
			}
			else {
				n = n - i;
				break;
			}
		}
		while(n!=0) {
			ress = (ress * arr[int(log2(n))]) % y;
			n =n-(long long int) pow(2, int(log2(n)));

		}
		cout << ress; 
	
}

