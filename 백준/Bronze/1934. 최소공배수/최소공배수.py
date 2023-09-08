# 최대공약수로 풀면 시간초과에 걸리기 쉬우므로 유클리드 알고리즘으로 푼다.
# 수학적으로 두 수를 곱한 값은 두 수의 최대공약수와 최대공배수의 곱과 같다.

import sys

T=int(input())

for i in range(T):
    a, b=map(int,sys.stdin.readline().strip().split())
    aa, bb = a, b
    while bb != 0:
        aa = aa % bb
        aa, bb = bb, aa
    print(a * b // aa)