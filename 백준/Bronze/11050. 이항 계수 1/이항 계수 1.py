# 이항 계수 (N/K)는 N개 중에서 K개를 고르는 것을 말한다.
# 즉 N개에서 K개를 고르는 조합 문제와 같으므로 수식을 사용한다.

import sys, math

n, k = map(int, sys.stdin.readline().split())

print(math.factorial(n)//(math.factorial(n-k)*math.factorial(k)))