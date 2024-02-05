# 퀸끼리 서로 공격할 수 없으려면 가로, 세로, 대각선에 위치해서는 안된다.
# 퀸의 위치는 i,j로 표시하되 2차원 배열이 아닌, i번째 인덱스에 j값을 위치
# 한 행에 하나의 말만 놓기에 행 체크를 할 필요가 없다.
# 열 체크는 j값이므로 0-n까지 행을 돌며 chess[행]의 값이 같은지를 체크
# 0에서부터 채우기 때문에 대각선은 놓은 말보다 위의 말에만 체크하면 된다.
# 대각선 체크는 인덱스와 값의 차가 같으면 같은 대각선이므로 오른쪽/왼쪽 절댓값 검사로 체크한다.

import sys

n = int(sys.stdin.readline())
answer = 0
chess = [0] * n

def checkQueen(count):
    for i in range(count):
        if chess[count] == chess[i] or abs(chess[count] - chess[i]) == abs(count-i) :
            return False
    return True

def backTracking(count) : # count == 놓은 체스말의 수 > 1씩 증가
    global answer
    if count == n :  answer += 1; return # 체스말을 다 놓으면 방법 개수 1 증가
    else : # if문에서 함수가 끝나지 않기 때문에 필요
        for i in range(n) :
            chess[count] = i
            if checkQueen(count) :
                backTracking(count+1)
backTracking(0)
print(answer)