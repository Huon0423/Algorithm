# 재귀를 이용해 팩토리얼을 구현한다

import sys

n = int(sys.stdin.readline())

def factorial(num) :
    if num <= 1 : return 1
    return num * factorial(num-1)

print(factorial(n))