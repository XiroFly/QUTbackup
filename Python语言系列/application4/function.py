# 贪心算法求近似解
def greedy_activity_selection(start_time, end_time):
    activities = list(zip(start_time, end_time))  
    selected_activities = []  # 已选择的活动

    # 将活动按结束时间从小到大排序
    activities.sort(key=lambda x: x[1])

    # 选择第一个活动（结束时间最早的活动）
    selected_activities.append(activities[0])
    prev_end_time = activities[0][1]

    # 对剩下的活动进行判断是否相容，并选择相容的活动
    for i in range(1, len(activities)):
        if activities[i][0] >= prev_end_time:
            selected_activities.append(activities[i])
            prev_end_time = activities[i][1]

    return selected_activities


def activity_selection(start, finish):
    n = len(start) # 活动数量
    activities = list(zip(start, finish)) # 活动列表

    # 按照结束时间对活动进行排序
    activities.sort(key=lambda x: x[1])

    # 初始化dp数组和path数组
    dp = [0] * (n + 1)
    path = [0] * (n + 1)#1到n

    # 动态规划计算
    for i in range(1, n + 1):
        dp[i] = 1  # 初始值，至少可以安排一个活动
        path[i] = i  # 初始路径为当前活动
        for j in range(1, i):
            if activities[i - 1][0] >= activities[j - 1][1]:
                if dp[j] + 1 > dp[i]:
                    dp[i] = dp[j] + 1
                    path[i] = j

    # 构建选定活动的路径
    activity_path = []
    current = n
    while True :
        activity_path.append(activities[current-1])#0到n-1,被选中事件的开始时间
        if current != path[current]:
            current=path[current]
        else :
            break
 
    activity_path.reverse()  # 反转路径列表，使其按照起始时间递增的顺序排列

    return  activity_path

"""首先，对活动按照结束时间进行排序，以确保结束时间早的活动排在前面。这可以确保在后续的计算中，选择的活动是按照结束时间递增的顺序进行的。

定义一个数组dp，长度为n+1，其中dp[i]表示前i个活动能够安排的最大相容活动数量。

初始化dp数组，将所有元素初始化为0。

对于每个活动i（从1到n），计算dp[i]的值：

首先将dp[i]的初始值设为1，表示至少可以安排一个活动。

然后从第一个活动开始，遍历前面的活动j（从1到i-1)

如果活动i与活动j相容（即活动i的起始时间si晚于活动j的结束时间fi），则可以将活动j加入安排中，此时dp[i]的值为dp[j] + 1。

如果活动i与活动j不相容，则不将活动j加入安排中，dp[i]的值保持不变。

在遍历完所有的活动j后，dp[i]的值即为前i个活动能够安排的最大相容活动数量。

最后，dp[n]即为问题的解，表示前n个活动能够安排的最大相容活动数量。
"""