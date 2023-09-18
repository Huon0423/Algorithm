# 주어진 명령대로 구현한다.

import sys

stack = []
n = int(sys.stdin.readline().strip())
for _ in range(n) :
    x = list(map(int, sys.stdin.readline().split()))
    if x[0] == 1 : stack.append(x[1])
    elif x[0] == 2 :
        if len(stack) != 0 : print(stack.pop())
        else : print(-1)
    elif x[0] == 3 : print(len(stack))
    elif x[0] == 4 : 
        if len(stack) != 0 : print(0)
        else : print(1)
    else : 
        if len(stack) != 0 : print(stack[-1])
        else : print(-1)
