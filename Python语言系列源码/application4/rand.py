import random

def generate_activity_data(n, min_start, max_start, min_duration, max_duration):
    start_time = []
    end_time = []

    for _ in range(n):
        duration = random.randint(min_duration, max_duration)
        start = random.randint(min_start, max_start )
        end = start + duration

        start_time.append(start)
        end_time.append(end)

    return start_time, end_time


