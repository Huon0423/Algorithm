# 스택에 정수를 추가하며, 입력값이 0일 경우 pop으로 빼낸다.

import sys

k = int(sys.stdin.readline().strip())
stack = []

for _ in range(k) :
    n = int(sys.stdin.readline().strip())
    if n != 0 : stack.append(n)
    else : stack.pop()

print(sum(stack))