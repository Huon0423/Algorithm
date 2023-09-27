# 파이썬에서는 큐를 스택처럼 list로 활용하며, pop(0)을 사용
# 하지만 list를 사용시 시간초과가 나기 때문에 deque 사용
import sys
from collections import deque

n = int(sys.stdin.readline())
deque = deque([])
for _ in range(n) :
    order = list(map(str,sys.stdin.readline().split()))
    length = len(deque)

    if order[0] == "1" : deque.appendleft(order[1])
    elif order[0] == "2" : deque.append(order[1])
    elif order[0] == "3" : 
        if length < 1 : print(-1)
        else : print(deque.popleft())
    elif order[0] == "4" : 
        if length < 1 : print(-1)
        else : print(deque.pop())
    elif order[0] == "5" : print(length)
    elif order[0] == "6" :
        if length < 1 : print(1)
        else : print(0)
    elif order[0] == "7" : 
        if length < 1 : print(-1)
        else : print(deque[0])
    else : 
        if length < 1 : print(-1)
        else : print(deque[length-1])
    
