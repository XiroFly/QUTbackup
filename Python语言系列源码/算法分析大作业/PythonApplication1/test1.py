import random
import time
import matplotlib.pyplot as plt


def generate_random_list(size):
    # 生成指定大小的随机整数列表
    return [random.randint(1, 10000) for _ in range(size)]


def merge_sort(arr):
    # 归并排序
    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])

    return merge(left, right)


def merge(left, right):
    # 归并操作
    merged = []
    i = j = 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            merged.append(left[i])
            i += 1
        else:
            merged.append(right[j])
            j += 1

    merged.extend(left[i:])
    merged.extend(right[j:])

    return merged


def quick_sort(arr):
    # 快速排序
    if len(arr) <= 1:
        return arr

    pivot = arr[0]
    smaller = [x for x in arr[1:] if x <= pivot]
    greater = [x for x in arr[1:] if x > pivot]

    return quick_sort(smaller) + [pivot] + quick_sort(greater)


def measure_time_complexity():
    sizes = []
    merge_times = []
    quick_times = []
    sorted_times = []

    size = 64
    while True:
        sizes.append(size)

        arr = generate_random_list(size)

        start_time = time.time()
        merge_sort(arr)
        merge_time = time.time() - start_time
        merge_times.append(merge_time)

        start_time = time.time()
        quick_sort(arr)
        quick_time = time.time() - start_time
        quick_times.append(quick_time)

        start_time = time.time()
        sorted(arr)
        sorted_time = time.time() - start_time
        sorted_times.append(sorted_time)

        if merge_time > 180 or quick_time > 180 or sorted_time > 180:
            break

        size *= 2

    plt.plot(sizes, merge_times, label='Merge Sort')
    plt.plot(sizes, quick_times, label='Quick Sort')
    plt.plot(sizes, sorted_times, label='Python Sorted')
    plt.xlabel('Input Size')
    plt.ylabel('Time (seconds)')
    plt.title('Time Complexity of Sorting Algorithms')
    plt.legend()
    plt.show()


# 测量运行时间并绘制曲线图
measure_time_complexity()
