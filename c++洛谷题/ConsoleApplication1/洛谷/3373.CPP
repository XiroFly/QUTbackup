#include<iostream>
#define ll long long
#include<string.h>
using namespace std;
int n, q, m;
int arr[(int)4e5];
int N[(int)1e5];
int tagadd[(int)2e5]={0};
int tagproduct[(int)2e5];
void push(int i) {
	arr[i] =((ll)arr[i << 1] + (ll)arr[i << 1 | 1])%m;
}
void push_down(int i ,int pl,int pr) {
	int sl = i << 1, sr = i << 1 | 1;
	int lenl = (pr - pl + 1) >> 1, lenr = (pr - pl + 1) >> 1 | 1;
	arr[sl] =(((ll)arr[sl]* (ll)tagproduct[i])+tagadd[i]*lenl)%m;
	arr[sr] =(((ll)arr[sr]* (ll)tagproduct[i])+tagadd[i]*lenr)%m;
	tagproduct[sl] =((ll)tagproduct[sl]* tagproduct[i])%m;
	tagproduct[sr] =((ll)tagproduct[sr]* tagproduct[i])%m;
	tagadd[sl] = ((ll)tagadd[sl]+ tagadd[i])%m;
	tagadd[sr] = ((ll)tagadd[sr]+ tagadd[i])%m;
	tagadd[i] = 0;

	tagproduct[i] = 1;
}
void build(int l,int r,int i) {
	if (l == r) {
		arr[i] = N[l]; return;
	}
	build(l, l + (r - l) >> 1, i << 1);
	build(l + 1 + (r - l) >> 1, r, i << 1 | 1);
	push(i);
	tagproduct[i] = 1;
}		
void update(int l,int r,int x, int pl,int pr,int i) {
	if (pr<l || pl>r)return;
	if (l <= pl && r >= pr) {
		arr[i] += (pr-pl+1)*x;
		if (pl != pr)tagadd[i]+= x;
		return;
	}
	a(l, r, x, pl,pl+(pr-pl)>>1 , i << 1);
	add(l, r, x, pl +1+ (pr - pl) >> 1,pr , i << 1 | 1);
}
void product(int l, int r, int x, int pl, int pr, int i) {

}
int query(int l,int r,int pl,int pr,int i) {
	if (l <= pl && r >= pr) return arr[i];
	if (tagadd[i]) {
		push_down(i, pl, pr);
	 }
	int ans = 0;
	ans+=query(l, r, pl, pl + (pr - pl) >> 1, i << 1);
	ans+=query(l, r,  pl + (pr - pl) >> 1|1,pr, i << 1|1);
	return ans;
}
int main() {
	cin >> n>>q>>m;

}