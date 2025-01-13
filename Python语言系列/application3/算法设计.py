from branch import *
from brute_force import *
from backtrack import *
from  rand import *
import time
num_items = 10
while True:
    items, capacity = generate_items(num_items)
    print(f"Number of items: {num_items}")#数量
    print(f"Items: {items}")#物品大小，价值（weight，value）
    print(f"Capacity: {capacity}")#背包容量

    # Brute Force
    bf_start = time.time()
    bf_result = brute_force_knapsack(items, capacity)
    bf_end = time.time()

    print(f"Brute Force Result: {bf_result}")
    print(f"Brute Force Time: {bf_end - bf_start} seconds")

    # Backtracking
    bt_start = time.time()
    bt_result = backtrack_knapsack(items, capacity)
    bt_end = time.time()

    print(f"Backtracking Result: {bt_result}")
    print(f"Backtracking Time: {bt_end - bt_start} seconds")

    # Branch and Bound
    bb_start = time.time()
    bb_result = branch_and_bound_knapsack(items, capacity)
    bb_end = time.time()

    print(f"Branch and Bound Result: {bb_result}")
    print(f"Branch and Bound Time: {bb_end - bb_start} seconds")
    #检查是否超过五分钟
    if bf_end - bf_start > 300 or bt_end - bt_start > 300 or bb_end - bb_start > 300:
        break
    #增加问题规模
    num_items *= 2#28:584s
    
