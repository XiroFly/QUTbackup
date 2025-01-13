def backtrack_knapsack(items, capacity):
    num_items = len(items)  # 物品数量
    max_value = 0  # 最大价值
    best_combination = None  # 最佳组合

    def backtrack(index, current_weight, current_value, current_combination):
        nonlocal max_value, best_combination

        if current_weight > capacity:  # 如果当前重量超过背包容量，则返回
            return

        if current_value > max_value:  # 如果当前价值大于最大价值，则更新最大价值和最佳组合
            max_value = current_value
            best_combination = current_combination[:]

        if index == num_items:  # 如果遍历完所有物品，则返回
            return

        item_weight, item_value = items[index]  # 获取当前物品的重量和价值

        # 选择当前物品
        backtrack(index + 1, current_weight + item_weight, current_value + item_value,
                  current_combination + [index])

        # 不选择当前物品
        backtrack(index + 1, current_weight, current_value, current_combination)

    # 从第一个物品开始进行回溯
    backtrack(0, 0, 0, [])

    return max_value, best_combination  # 返回最大价值和最佳组合
