# 소수는 에라토스테네스의 체로 찾는다.
# 입력된 수부터 입력된 수까지 소수를 찾아 출력한다.

import sys, math

def prime(x): # 소수를 판명하는 함수
    if x == 0 or x == 1:
        return False
    for i in range(2, int(math.sqrt(x))+1):
        if x % i == 0:
            return False
    return True

a, b = map(int, sys.stdin.readline().split())

for i in range(a,b+1) :
    if prime(i):
        print(i)