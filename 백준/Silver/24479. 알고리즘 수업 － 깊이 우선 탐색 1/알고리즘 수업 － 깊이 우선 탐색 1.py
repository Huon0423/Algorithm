# n개의 행을 가진 이차원 배열의 각 인덱스 열에 인접 정점을 추가한다.
# 각 행에 추가할 열은 set으로 한다 > 자동으로 중복 제거, 오름차순 정렬

import sys
sys.setrecursionlimit(10**5)

n, m, r = map(int, sys.stdin.readline().split())
v_list = [0] * (n+1)
e_list = [[] for _ in range(n+1)]
visited_list = ["0"] * n
count = 1

for _ in range(m) :
    u, v = map(int, sys.stdin.readline().split())
    e_list[u].append(v)
    e_list[v].append(u)

for i in range(n+1) :
    e_list[i].sort()

def dfs(v,e,r) :
    global count
    visited_list[r-1] = str(count)
    count += 1
    v_list[r] = 1 # 정점 방문 체크
    for x in e_list[r] :
        if v_list[x] == 0 : dfs(v,e,x)

dfs(v_list, e_list, r)
print("\n".join(visited_list))