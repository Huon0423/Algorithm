# dfs를 사용하여 초기 전파된 컴퓨터의 인접 정점을 검사한다.

import sys
from collections import deque
sys.setrecursionlimit(10**5)

n = int(sys.stdin.readline()) # 컴퓨터 수 == 정점의 수
m = int(sys.stdin.readline()) # 간선의 수
computers = [False] * (n+1) # 정점 집합
e_list = [[] for _ in range(n+1)] # 간선 집합
infection_list = []
answer = 0

for _ in range(m) :
    u, v = map(int, sys.stdin.readline().split())
    e_list[u].append(v)
    e_list[v].append(u)

def dfs(v,e,r) :
    infection_list.append(str(r))
    computers[r] = True # 정점 방문 체크
    for x in e_list[r] :
        if computers[x] == 0 : dfs(v,e,x)

dfs(computers, e_list, 1)

for c in computers :
    if c : answer += 1

print(answer-1)