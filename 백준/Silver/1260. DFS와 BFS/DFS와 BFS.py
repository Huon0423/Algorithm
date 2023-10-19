# n개의 행을 가진 이차원 배열의 각 인덱스 열에 인접 정점을 추가한다.
# 너비 우선 탐색이므로 양방향 접근이 가능한 dequeue를 사용한다.

import sys
from collections import deque
sys.setrecursionlimit(10**5)

n, m, r = map(int, sys.stdin.readline().split())
v_list = [False] * (n+1) # 정점 집합
e_list = [[] for _ in range(n+1)] # 간선 집합
dq = deque()
d_visited_list = []
b_visited_list = []

for _ in range(m) :
    u, v = map(int, sys.stdin.readline().split())
    e_list[u].append(v)
    e_list[v].append(u)

for i in range(n+1) : # 인접 정점을 오름차순으로 정렬
    e_list[i].sort()

def dfs(v,e,r) :
    d_visited_list.append(str(r))
    v_list[r] = True # 정점 방문 체크
    for x in e_list[r] :
        if v_list[x] == 0 : dfs(v,e,x)

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

dfs(v_list, e_list, r)
v_list = [False] * (n+1) # 정점 집합 초기화
bfs(v_list, e_list, r)
print(" ".join(d_visited_list))
print(" ".join(b_visited_list))