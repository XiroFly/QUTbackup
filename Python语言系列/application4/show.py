import time
import matplotlib.pyplot as plt
from function import *
from rand import *
def compare_execution_time():
    greedy_times = []  # 贪心算法的执行时间列表
    dynamic_times = []  # 动态规划的执行时间列表

    for n in range(4,1000):
        # 生成活动数据
        min_start = 0
        max_start = 100
        min_duration = 10
        max_duration = 20
        start_time, end_time = generate_activity_data(n, min_start, max_start, min_duration, max_duration)

        # 测量贪心算法的执行时间
        start = time.time()
        greedy_activity_selection(start_time, end_time)
        end = time.time()
        greedy_time = end - start
        greedy_times.append(greedy_time)

        # 测量动态规划的执行时间
        start = time.time()
        activity_selection(start_time, end_time)
        end = time.time()
        dynamic_time = end - start
        dynamic_times.append(dynamic_time)

    # 绘制曲线
    plt.plot(range(4,1000), greedy_times, label='Greedy')
    plt.plot(range(4,1000), dynamic_times, label='Dynamic Programming')
    plt.xlabel('Number of Activities (n)')
    plt.ylabel('Execution Time (seconds)')
    plt.title('Comparison of Execution Time')
    plt.legend()
    plt.show()

compare_execution_time()
