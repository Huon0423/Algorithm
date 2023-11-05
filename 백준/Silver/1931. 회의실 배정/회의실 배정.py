# 끝나는 시간이 가장 이른 순서대로 회의를 미리 정렬한다.
# 끝나는 시간이 같다면 시작하는 시간이 가장 이른 순서대로 회의를 미리 정렬한다.
# 정렬한 순서대로 회의를 진행한다면, 가장 많은 회의를 끝낼 수 있다.

import sys

n = int(sys.stdin.readline())
meeting_list = []
count = 0 # 끝마친 회의의 개수

for _ in range(n) :
    meeting_list.append(list(map(int, sys.stdin.readline().split())))

meeting_list.sort(key = lambda x : (x[1], x[0]))
last = 0

for m in meeting_list :
    if m[0] >= last : # 회의의 시작 시간이 이전 회의의 끝나는 시간 이후라면
        count += 1 # 회의를 하나 진행시키고
        last = m[1] # 진행시킨 회의의 끝나는 시간으로 last 변경

print(count)