# 건물을 차례대로 검사하면서, -2,-1,+1,+2만큼의 건물 중 나보다 큰 게 있다면 건너뛴다.
# 나보다 작다면, 그 중 가장 큰 건물의 높이를 나한테 뺀다 = 세대 수 차이
# 세대 수를 더해주고 마지막에 반환한다.

import sys

T = 1

for test_case in range(1, T + 1):
    n = int(input()) # 건물의 개수
    buildings =list(map(int,input().split())) # 건물의 높이
    answer = 0
    for i in range(2, n-2) : # 2부터 시작하고, n-3까지 돌린다 > 건물은 2부터 n-2까지 존재 + 마지막 요소는 n-1이므로 n-1-2
        max_height = max(buildings[i-2],buildings[i-1],buildings[i+1],buildings[i+2])
        if max_height < buildings[i] : answer += buildings[i] - max_height
    print(f"#{test_case}", answer)
        
    