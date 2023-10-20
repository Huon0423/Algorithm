# bfs를 사용하여 미로를 탐색한다.
# 시계방향대로 위에서부터 벽을 0,1,1,0(예)로 저장한다.

import sys
from collections import deque
sys.setrecursionlimit(10**5)

n, m =  map(int, sys.stdin.readline().split()) # 미로의 크기
pre_location = 1 # 현재 위치
maze = [] # 미로
relation = [[]] * (n*m) # 미로의 각 위치에 대한 상하좌우 정보 저장 배열
dq = deque()
answer = 0

for _ in range(n) :
    maze.append(list(map(int,str(sys.stdin.readline().strip()))))


# def bfs(v,e,r) :
#     dq.append(r) # 큐에 시작 정점 추가
#     while len(dq) > 0 :
#       u = dq.popleft() # 방문한 정점을 큐에서 제거
#       for x in relation[u] :
#         if not maze[x]: # 아직 방문하지 않은 인접 정점이라면
#            maze[x] = True # 정점 방문 체크
#            dq.append(x) # 큐에 방문 정점 추가

# bfs(maze, relation, 1)