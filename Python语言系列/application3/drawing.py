from branch import *
from brute_force import *
from backtrack import *
from  rand import *
import time
import matplotlib.pyplot as plt
# 定义参数和结果列表
N_values = [i for i in range(1,29)]#问题规模
brute_force_times = []
backtrack_times = []
branch_and_bound_times = []
#定义时间函数
def measure_time(algorithm, items, capacity):
    start_time = time.time()
    algorithm(items, capacity)
    end_time = time.time()
    return end_time - start_time
# 针对不同的问题规模进行求解和计时
for N in N_values:
    items, capacity = generate_items(N)

    brute_force_time = measure_time(brute_force_knapsack, items, capacity)
    backtrack_time = measure_time(backtrack_knapsack, items, capacity)
    branch_and_bound_time = measure_time(branch_and_bound_knapsack, items, capacity)

    brute_force_times.append(brute_force_time)
    backtrack_times.append(backtrack_time)
    branch_and_bound_times.append(branch_and_bound_time)

# 绘制图像
plt.plot(N_values, brute_force_times, label='Brute Force')
plt.plot(N_values, backtrack_times, label='Backtracking')
plt.plot(N_values, branch_and_bound_times, label='Branch and Bound')
plt.xlabel('N')
plt.ylabel('Time (seconds)')
plt.title('0/1 Knapsack Problem Solving Time')
plt.legend()
plt.show()
"""图像的生成可以让您更直观地了解不同算法在求解 0/1 背包问题时的求解时间变化。通过观察图像，您可以得出以下结论：

蛮力法：随着问题规模的增大，求解时间呈指数级增长。由于需要遍历所有可能的组合，蛮力法的时间复杂度很高，不适用于大规模问题。

回溯法：回溯法通过不断回溯和搜索来寻找最优解，其求解时间随着问题规模的增大也呈指数级增长。然而，回溯法可以在搜索过程中进行剪枝操作，
减少无效的搜索空间，因此相对于蛮力法，回溯法在一定程度上具有更高的效率。

分支限界法：分支限界法通过引入上界来优化搜索过程，它可以提前剪枝，减少搜索空间，因此相对于蛮力法和回溯法，
分支限界法在求解时间上具有明显的优势。随着问题规模的增大，分支限界法的求解时间增长较为缓慢。

综上所述，回溯法和分支限界法相对于蛮力法在求解0/1背包问题时具有优势，它们可以通过剪枝和优化搜索策略来减少搜索空间，提高求解效率。分支限界法在求解时间上通常比回溯法更优，尤其在处理大规模问题时。"""