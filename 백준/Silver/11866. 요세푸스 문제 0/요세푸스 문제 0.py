# 파이썬에서는 큐를 스택처럼 list로 활용하며, pop(0)을 사용
# 하지만 list를 사용시 시간초과가 나기 때문에 deque 사용
# deque를 주기-1만큼 시계 반대방향으로 돌린다 > 빼주어야할 수가 주기에 위치하기 때문
# 가장 왼쪽으로 몰아온 수를 빼서 list에 넣는다

import sys
from collections import deque

n, k = map(int,sys.stdin.readline().split())
deque = deque([i for i in range(1,n+1)])
answer = []

while len(deque) > 0 : 
    deque.rotate(-(k-1))
    answer.append(str(deque.popleft()))
print("<" + ", ".join(answer) + ">")