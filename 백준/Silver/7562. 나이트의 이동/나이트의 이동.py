from collections import deque
import sys
input = sys.stdin.readline

dx = [-2, -2, 1, -1, 2, 2, 1, -1]
dy = [1, -1, -2, -2, 1, -1, 2, 2]


def bfs(sx, sy, ex, ey):
    d = 0
    q = deque()
    q.append((sx, sy, d))

    while q:
        x, y, d = q.popleft()
        if x == ex and y == ey:
            print(d)
            return
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < b and 0 <= ny < b and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny, d + 1))


t = int(input())
for _ in range(t):
    b = int(input())

    sx, sy = map(int, input().split())
    ex, ey = map(int, input().split())
    if sx == ex and sy == ey:
        print(0)
        continue
    board = [[0] * b for _ in range(b)]
    visited = [[False] * b for _ in range(b)]
    bfs(sx, sy, ex, ey)