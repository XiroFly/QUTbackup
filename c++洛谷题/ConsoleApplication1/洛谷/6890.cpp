#include<set>
#include<iostream>
using namespace std;
#include<string.h>
static int arr[int(5e5 + 1)][3];//0:链接，1：可到达mark 2：被指向mark(父节点)
struct comp {
	int a, b;
	comp(int a,int b):a(a),b(b){}
	bool operator<(const comp& other) const{
		return b < other.b;
	}
};
int dfs(int node, int k) {
	if (k == -1)return node;
	arr[node][1] = k;
	if(k>arr[arr[node][0]][1])return dfs(arr[node][0], --k); 
	return arr[node][0];
}
int find_ans(int k,int n) {
	static int ans = 0;
	dfs(1,k);
	for(int i=2;i<=n;i++){
		if (arr[i][2] == -1) {
			arr[i][2] == 1;
			ans++;
			dfs(i, k-1);
		}
	}
	set<comp> s;
	for (int i =2 ; i <= n; i++) {
		if ( arr[i][1]==0&&arr[i][0]!=-1) {
			int z = 0;
			for (int j = 0,ks=i; j < k; j++) {
				if (arr[arr[ks][0]][1] == -1)
				z++;
				ks= arr[ks][0];
			}
			s.insert({i,z});
		}
	}
	for (auto i : s) {

		if (arr[i.a][0] == -1) {
			ans++;
			dfs(i.a, k - 1);
		}
	}

	for (int i = 2; i <= n; i++) {
		if (arr[i][1] == -1)
		{
			ans++;
			int node=dfs(i, k - 1);
			while(arr[node][1] == -1) {
				ans++;
				dfs(node, k - 1);
			}
		}
	}
	return ans;
}
int main() {
	int n, k;
	cin >> n >> k;
	memset(arr, -1, sizeof(arr));
	for (int i = 1,j=0; i < n + 1; i++) {
		cin >> j;
		cin>>arr[j][0];
		arr[arr[j][0]][2] = j;
	}
	
	cout<<find_ans(k,n);
}