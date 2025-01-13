import random

def generate_items(num_items):
    items = []
    total_weight = 0
    for _ in range(num_items):
        weight = random.randint(1, 10)
        value = random.randint(10, 50)
        items.append((weight, value))
        total_weight += weight
    return items, total_weight // 2#背包容量设置为一半
"""通常情况下，为了使问题具有更好的可解性，背包的容量应该设置为物品总重量的一部分，例如总重量的一半。这样可以确保背包不会被过度装满，
从而留下空间放入其他有潜在更高价值的物品。
在生成随机物品并计算背包容量时，将总重量的一半作为背包的容量返回是一个常见的做法。这样可以尽量满足问题的约束条件，并保持问题的合理性。"""