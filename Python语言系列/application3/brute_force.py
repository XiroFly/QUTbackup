def brute_force_knapsack(items, capacity):
    num_items = len(items)  # 物品数量
    max_value = 0  # 最大价值
    best_combination = None  # 最佳组合

    # 遍历所有可能的组合
    for i in range(2**num_items):
        current_value = 0  # 当前组合的总价值
        current_weight = 0  # 当前组合的总重量
        current_combination = []  # 当前组合的物品索引列表

        # 检查每个物品是否被选择
        for j in range(num_items):
            if (i >> j) & 1:  # 通过位运算检查第j位是否为1
                item_weight, item_value = items[j]  # 获取物品的重量和价值
                if current_weight + item_weight <= capacity:  # 检查背包容量是否超过限制
                    current_weight += item_weight  # 更新当前组合的总重量
                    current_value += item_value  # 更新当前组合的总价值
                    current_combination.append(j)  # 将物品索引添加到当前组合中

        if current_value > max_value:  # 如果当前组合的总价值更大，则更新最大价值和最佳组合
            max_value = current_value
            best_combination = current_combination

    return max_value, best_combination  # 返回最大价值和最佳组合
#90时会非常大！进行剪枝
def evl_brute_force_knapsack(items, capacity):
    num_items = len(items)  # 物品数量
    max_value = 0  # 最大价值
    best_combination = None  # 最佳组合
    array=[0 for _ in range(num_items+1)]
    
         
        
        
    
