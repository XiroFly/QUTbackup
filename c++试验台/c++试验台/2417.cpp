#include<iostream>
#include <string.h>
using namespace std;
int classes[int(2e4 + 1)];
int students[int(2e4 + 1)];
bool bitmap[int(2e4 + 1)];
long long iter = 1;
struct edge {
    int to;
    int w;
    int next;
}edges[int(1e6)];
bool fun(int i) {
    int clas = classes[i], student = edges[clas].to, nextedge = edges[clas].next; bool match = false;
    bitmap[i] = true;
    do {
        if (!students[student]) {
            match = true;
            students[student] = iter;
            edges[iter++].to = i;
           // bitmap[i] = false;
        }
        else if (!bitmap[edges[students[student]].to] && fun(edges[students[student]].to)) {
            match = true;
            edges[students[student]].to = i;
            //bitmap[i] = false;
        }
        else {
            student = edges[nextedge].to;
            nextedge = edges[nextedge].next;
        }
    } while (!match && student);
 
    return match;
}
int main() {
    int T, m, n, k, p;

    cin >> T;
    while (T--) {
        cin >> m >> n;
        for (int i = 1; i <= m; i++) {
            cin >> k;
            classes[i] = iter;
            while (k--) {
                cin >> edges[iter].to;
                edges[iter].w = 1;
                if (k) {
                    edges[iter].next = iter + 1;
                }
                iter++;
            }
        }
        int i;
        for (i = 1; i <= m; i++) {
            bool result = fun(i); 
            memset(bitmap, 0, sizeof(bool) * (2e4 + 1));
            if (!result) {
                cout << "NO" << endl;
                break;
            }
        }
        if (i == m + 1)cout << "YES" << endl;
    }

}