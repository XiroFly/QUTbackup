from rand import *
from function import *
n = 50  # 活动数量
min_start = 0  # 最小起始时间
max_start = 20  # 最大起始时间
min_duration = 1  # 最小持续时间
max_duration = 10  # 最大持续时间

start_time, end_time = generate_activity_data(n, min_start, max_start, min_duration, max_duration)

print("start_time:",start_time)
print("end_time:",end_time)
greedy_solution = greedy_activity_selection(start_time, end_time)
print("贪心算法近似解：", greedy_solution)

dynamic_solution = activity_selection(start_time, end_time)
print("动态规划最优解：", dynamic_solution)
