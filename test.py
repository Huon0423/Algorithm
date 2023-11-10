# 뱀을 다 피하는 방법이 꼭 최단 방법은 아니다.
# 뱀과 사다리를 간선으로 사용하여 찾는다.
# BFS를 사용한다.

import sys
from collections import deque
sys.setrecursionlimit(10**5)

n, m = map(int, sys.stdin.readline().split())
ladders = [] # 사다리 모음
snakes = [] # 뱀 모음
dq = deque()

for _ in range(n) :
    ladders.append(list(map(int, sys.stdin.readline().split())))
for _ in range(m) :
    snakes.append(list(map(int, sys.stdin.readline().split())))

def bfs(v,e,r) :
    b_visited_list.append(str(r)) # 방문 정점 추가
    v_list[r] = True # 정점 방문 체크
    dq.append(r) # 큐에 시작 정점 추가
    while len(dq) > 0 :
      u = dq.popleft() # 방문한 정점을 큐에서 제거
      for x in e_list[u] :
        if not v_list[x]: # 아직 방문하지 않은 인접 정점이라면
           b_visited_list.append(str(x)) # 방문한 정점의 순서 저장
           v_list[x] = True # 정점 방문 체크
           dq.append(x) # 큐에 방문 정점 추가