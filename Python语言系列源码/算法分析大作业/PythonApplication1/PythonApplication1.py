import random
import time
import matplotlib.pyplot as plt


def generate_number_tower(height):
    # 生成高度为height的随机数塔
    tower = []
    for i in range(1, height + 1):
        row = [random.randint(-1000, 1000) for _ in range(i)]
        tower.append(row)
    return tower


def max_path_sum_dp(tower):
    # 使用动态规划求解最大路径和
    height = len(tower)
    dp = [[0] * len(row) for row in tower]
    dp[0][0] = tower[0][0]

    for i in range(1, height):
        for j in range(len(tower[i])):
            if j == 0:
                dp[i][j] = tower[i][j] + dp[i-1][j]
            elif j == len(tower[i]) - 1:
                dp[i][j] = tower[i][j] + dp[i-1][j-1]
            else:
                dp[i][j] = tower[i][j] + max(dp[i-1][j-1], dp[i-1][j])

    max_sum = max(dp[height-1])
    return max_sum

def max_path_sum_brute_force(tower, current_sum, row, index):
    # 使用蛮力法求解最大路径和
    if row == len(tower):
        return current_sum

    left_sum = max_path_sum_brute_force(tower, current_sum + tower[row][index], row + 1, index)
    right_sum = max_path_sum_brute_force(tower, current_sum + tower[row][index + 1], row + 1, index + 1)
    return max(left_sum, right_sum)
def plot_time_complexity():
    heights = [4, 8, 16, 32]
    dp_times = []
    bf_times = []

    for height in heights:
        tower = generate_number_tower(height)

        # 动态规划法计算时间
        start_time = time.time()
        max_path_sum_dp(tower)
        dp_time = time.time() - start_time
        dp_times.append(dp_time)

        # 蛮力法计算时间
        start_time = time.time()
        max_path_sum_brute_force(tower, tower[0][0], 1, 0)
        bf_time = time.time() - start_time
        bf_times.append(bf_time)

    plt.plot(heights, dp_times, label='Dynamic Programming')
    plt.plot(heights, bf_times, label='Brute Force')
    plt.xlabel('Height of Number Tower')
    plt.ylabel('Time (seconds)')
    plt.title('Time Complexity of Different Methods')
    plt.legend()
    plt.show()


# 测试动态规划法
tower = generate_number_tower(10)
max_sum_dp = max_path_sum_dp(tower)
print("Dynamic Programming - Max Path Sum:", max_sum_dp)

# 测试蛮力法
max_sum_bf = max_path_sum_brute_force(tower, tower[0][0], 1, 0)
print("Brute Force - Max Path Sum:", max_sum_bf)

# 绘制时间复杂度曲线图
plot_time_complexity()
