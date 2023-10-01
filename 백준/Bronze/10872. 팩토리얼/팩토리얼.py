# 한 개의 상의와 겹치지 않는 색 n-1(겹치는 색 제외)개의 바지 쌍이 총 n개

import sys

n = int(sys.stdin.readline())
answer = 1

for i in range(1,n+1) :
    answer *= i
if n == 0 : print(1)
else : print(answer)