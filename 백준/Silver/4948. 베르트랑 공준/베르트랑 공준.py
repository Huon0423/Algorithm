# 소수는 에라토스테네스의 체로 찾는다.
# 입력된 수부터 입력된 수까지 소수를 찾아 저장한다.
# 저장된 리스트의 길이를 출력한다.

import sys, math

def prime(x): # 소수를 판명하는 함수
    if x == 0 or x == 1:
        return False
    for i in range(2, int(math.sqrt(x))+1):
        if x % i == 0:
            return False
    return True

while True :
    n = int(sys.stdin.readline())
    if n == 0 : break
    list = []
    for i in range(n+1,2*n+1) :
        if prime(i):
            list.append(i)
    print(len(list))