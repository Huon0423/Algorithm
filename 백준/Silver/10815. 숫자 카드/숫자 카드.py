# 시간초과 >> dict를 사용하여 cards의 숫자와 checks의 숫자를 비교한다.

import sys

n = int(sys.stdin.readline())
cards = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
checks = list(map(int, sys.stdin.readline().split()))

_dict = {}
for i in range(n):
    _dict[cards[i]] = 0  # 0으로 초기화

for j in range(m):
    if checks[j] not in _dict:
        print(0, end=' ')
    else:
        print(1, end=' ')