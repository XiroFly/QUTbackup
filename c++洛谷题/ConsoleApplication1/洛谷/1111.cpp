#include <iostream>
#include<algorithm>
#include<string.h>
using namespace std;
int n, m, x, y, t;
int tree;
int arr[1001];

struct node {
    int x;
    int y;
    int t;
};
node mm[100000];
bool comp(node& a, node& b) {
    return a.t < b.t;
}
int findroot(int x) {
    if (x == arr[x])return x;
    arr[x] = findroot(arr[x]);
    return arr[x];
}
void merge(int x, int y) {
    int a = findroot(x);
    int b = findroot(y);
    if (a != b) {
        tree--;
        arr[a] = b;
    }
}
int main() {

    cin >> n >> m;
    tree = n;
    for (int i = 0; i < 1001; i++) {
        arr[i] = i;
    }
    for (int i = 0; i < m; i++) {
        cin >> mm[i].x >> mm[i].y >> mm[i].t;
    }
    sort(mm, mm + m, comp);
    for (int i = 0; i < m; i++) {
        merge(mm[i].x, mm[i].y);
        if (tree == 1) {
            cout << mm[i].t;
            return 0;
        }
    }
    cout<< -1;
}