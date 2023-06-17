import sys
from collections import deque

k = int(input())

for _ in range(k) :
    
    n, q = map(int, input().split())
    m = list(map(int,input().split()))
    queue = deque(m)
    count = 0

    while True :
        q -= 1
        max_element = max(queue)
        e = queue.popleft()

        if e < max_element :
            queue.append(e)
            if(q < 0) : q = len(queue) - 1
        else :
            count += 1
            if(q < 0) : print(count); break
            