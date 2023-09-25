# 파이썬에서는 큐를 스택처럼 list로 활용하며, pop(0)을 사용
# 하지만 list를 사용시 시간초과가 나기 때문에 dequeue 사용
# 길이가 1만 남을 때까지 앞의 수를 버리고, 2번째 수를 뒤로 옮김

import sys
from collections import deque

n = int(sys.stdin.readline())
queue = deque([i for i in range(1,n+1)])
while len(queue) > 1 :
    queue.popleft()
    queue.append(queue.popleft())
print(queue[0])