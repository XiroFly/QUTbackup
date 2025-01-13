#include <iostream>
using namespace std;
#include<algorithm>
#include<fstream>
typedef  long long ll;
int t, n, h;
ll r;
struct boll {
    int x;
    int  y;  int  z;
    int next = -1;
};
boll bolls[1000];
int root(int i) {
    if (bolls[i].next == i)return i;
    bolls[i].next = root(bolls[i].next);
    // weight[i]=abs(bolls[i].z-bolls[bolls[i].next].z);
    return bolls[i].next;
}
void judge() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            if (root(i) == root(j))
                if (bolls[i].z <= r && bolls[j].z >= h - r) { cout << "Yes\n"; return; }
   }
    cout << "No\n";
}
bool dist(boll x, boll y) {
    if (4 * r * r < (long long)(x.x - y.x) * (long long)(x.x - y.x) + (long long)(x.y - y.y) * (long long)(x.y - y.y) + (long long)(x.z - y.z)* (long long)(x.z - y.z))return false;
    return true;
}

void merge(int i, int j) {
    if (root(i) != root(j)) {
        bolls[bolls[i].next].next = bolls[j].next;
    }
}

int main() {
    //std::ifstream inputFile("D:\\Download\\P3958_5.txt"); // 指定输入文件名
    //std::cin.rdbuf(inputFile.rdbuf()); // 将cin的缓冲区重定向到文件
    cin >> t;
    while (t-- > 0) {
        cin >> n >> h >> r;
        for (int i = 0; i < n; i++) {
            cin >> bolls[i].x >> bolls[i].y >> bolls[i].z;
            bolls[i].next = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (abs(bolls[i].x - bolls[j].x) > 2 * r || abs(bolls[i].y - bolls[j].y) > 2 * r || abs(bolls[i].z - bolls[j].z) > 2 * r)continue;
                if (dist(bolls[i], bolls[j]))
                    merge(i, j);
            }
        }
        judge();

    }
}