# 체스판이 만들어질 모든 경우의 수를 따진다.
# 8보다 더 크게 돌 수 있는 만큼을 범위로, 이중반복문을 통해 시작점을 정한다.
# 총 경우의 수만큼 돌면서, 첫시작이 W과 B로 돌아가는 2가지 경우로 다시 나눠 센다.

n,m = map(int, input().split())
board = [list(map(str, input())) for _ in range(n)]
sum_list = []
                
# 전체 보드에서 남는 만큼 이중반복문을 돈다
for i in range(0, n-7) :
    for j in range(0, m-7) :
        start = board[i][j] # 보드의 시작 색을 기준점으로 잡는다
        sumW =0; sumB = 0
        for r in range(i, i+8) :
            for c in range(j, j+8) :
                if (r+c) % 2 == 0: # 시작점과 색이 같아야하는 경우
                    if board[r][c] != 'W': # 시작점이 하얀색일 경우
                        sumW += 1
                    if board[r][c] != 'B': # 시작점이 까만색일 경우
                        sumB += 1
                else: # 시작점과 색이 달라야 하는 경우
                    if board[r][c] != 'B':
                        sumW += 1
                    if board[r][c] != 'W':
                        sumB += 1
        sum_list.append(min(sumW, sumB))
print(min(sum_list))