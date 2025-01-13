class Node:
    def __init__(self, level, weight, value, inclusion, bound):
        self.level = level  # 当前节点所在的层级（物品索引）
        self.weight = weight  # 当前节点的总重量
        self.value = value  # 当前节点的总价值
        self.inclusion = inclusion  # 当前节点的物品索引列表（包含的物品）
        self.bound = bound  # 当前节点的上界：基于剩余容量可容纳的物品的价值密度来进行估计的

def branch_and_bound_knapsack(items, capacity):
    num_items = len(items)  # 物品数量
    max_value = 0  # 最大价值
    best_combination = None  # 最佳组合

    def compute_bound(node):
        if node.weight >= capacity:  # 如果节点的重量超过背包容量，则返回0
            return 0

        bound = node.value  # 上界初始化为节点的总价值
        total_weight = node.weight  # 当前总重量为节点的总重量
        level = node.level + 1  # 从下一个层级开始计算上界

        while level < num_items and total_weight + items[level][0] <= capacity:
            # 如果还有物品可选择且加入当前物品后不超过背包容量，则更新上界和总重量
            bound += items[level][1]  # 更新上界，加上当前物品的价值
            total_weight += items[level][0]  # 更新总重量，加上当前物品的重量
            level += 1

        if level < num_items:
            # 如果还有物品可选择但加入当前物品后超过背包容量，则计算剩余容量可容纳的价值密度
            bound += (capacity - total_weight) * (items[level][1] / items[level][0])

        return bound

    queue = [Node(-1, 0, 0, [], 0)]  # 使用队列保存节点，初始根节点为-1层级的节点

    while queue:
        current_node = queue.pop(0)  # 取出队列中的当前节点

        if current_node.bound > max_value:  # 如果当前节点的上界大于最大价值，则继续扩展子节点
            level = current_node.level + 1  # 已考虑过的物品的数量+1。

            # 探索左子节点（包含当前物品）
            inclusion_weight = current_node.weight + items[level][0]  # 包含当前物品后的总重量
            inclusion_value = current_node.value + items[level][1]  # 包含当前物品后的总价值
            inclusion = current_node.inclusion + [level]  # 更新包含的物品列表

            if inclusion_weight <= capacity and inclusion_value > max_value:
                # 如果包含当前物品的组合满足约束条件且总价值大于最大价值，则更新最大价值和最佳组合
                max_value = inclusion_value
                best_combination = inclusion

            if level < num_items and inclusion_weight <= capacity:
                # 如果还有物品可选择且包含当前物品后不超过背包容量，则添加左子节点到队列中
                queue.append(
                    Node(level, inclusion_weight, inclusion_value, inclusion,
                         compute_bound(Node(level, inclusion_weight, inclusion_value, inclusion, 0))))

            # 探索右子节点（不包含当前物品）
            exclusion_weight = current_node.weight  # 不包含当前物品的总重量不变
            exclusion_value = current_node.value  # 不包含当前物品的总价值不变
            exclusion = current_node.inclusion  # 不包含当前物品，物品列表不变

            if level < num_items and exclusion_value + compute_bound(
                    Node(level, exclusion_weight, exclusion_value, exclusion, 0)) > max_value:
                # 如果还有物品可选择且包含当前物品后的上界大于最大价值，则添加右子节点到队列中
                queue.append(
                    Node(level, exclusion_weight, exclusion_value, exclusion,
                         compute_bound(Node(level, exclusion_weight, exclusion_value, exclusion, 0))))

    return max_value, best_combination  # 返回最大价值和最佳组合
"""
该函数使用分支限界法的方法来解决0/1背包问题。它使用了一个Node类来表示节点，每个节点包含了当前层级、总重量、总价值、包含的物品索引列表和上界。

函数中的compute_bound函数用于计算节点的上界。它首先检查节点的总重量是否超过背包容量，如果超过则返回0。
然后，根据剩余容量可容纳的物品的价值密度来计算上界。

主函数中使用一个队列来保存待扩展的节点。开始时，将根节点加入队列中。然后，循环从队列中取出当前节点，判断其上界是否大于最大价值。
如果是，则扩展其左子节点（包含当前物品）和右子节点（不包含当前物品）。左子节点的扩展需要满足约束条件且总价值大于最大价值，
右子节点的扩展需要其上界大于最大价值。

最后，返回最大价值和最佳组合作为结果返回。
"""
