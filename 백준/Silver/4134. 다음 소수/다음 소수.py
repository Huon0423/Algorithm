# 소수는 에라토스테네스의 체로 찾는다.
# n부터 소수가 나올 때까지 반복한다.

import sys, math

def prime(x): # 소수를 판명하는 함수
    if x == 0 or x == 1:
        return False
    for i in range(2, int(math.sqrt(n))+1):
        if x % i == 0:
            return False
    return True

t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    while True:
        if prime(n):
            print(n)
            break
        else: n += 1