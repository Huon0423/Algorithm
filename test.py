# 패턴이 제곱수마다 존재하므로 제곱때마다 추가해준다.

import sys

n = int(sys.stdin.readline())
result = 0
x = 1

while x * x <= n:
    x += 1
    result +=1

print(result)