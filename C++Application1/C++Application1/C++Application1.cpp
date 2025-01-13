#include <iostream>
#include <fstream>
#include <algorithm>

 long long ai[int(2e5 + 1)];
 long long bi[int(2e5 + 1)];
int sortbi[int(2e5 + 1)]; // multitude > divide in efficiency
int n, L, v, q;

bool compare(long long a, long long b) {
    return a > b;
}

bool compare1(int a, int b) {
    return bi[a] < bi[b];
}

int main() {
    std::ifstream inputFile("G:\\Download\\P6473_1.in");
    if (!inputFile) {
        std::cerr << "Error opening file!" << std::endl;
        return 1;
    }

    inputFile >> n >> L >> v;
    for (int i = 1; i <= n; i++) {
        inputFile >> ai[i];
    }
    std::sort(ai + 1, ai + n + 1, compare);
    for (int i = 1; i <= n; i++) {
        ai[i] += ai[i - 1];
    }

    inputFile >> q;
    for (int i = 1; i <= q; i++) {
        inputFile >> bi[i];
        bi[i] *= v;
        sortbi[i] = i;
    }
    std::sort(sortbi + 1, sortbi + q + 1, compare1);
   // for (int i = 1; i <= 100; i++) {std::cout << bi[sortbi[i]] << "\n"; }
    for (int i = 1, j = 0; i <= q; i++) {
        while (j <= n) {
            if (bi[sortbi[i]] < ai[j] + L) {
                bi[sortbi[i]] = j;
                break;
            }
            else {
                j++;
            }
        }
        if (j > n) bi[sortbi[i]] = -1;
    }
  
    // Output results to console
    for (int i = 1; i <= q; i++) {
        std::cout << bi[i] << '\n';
    }

    inputFile.close();
    return 0;
}
