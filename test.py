# list를 이차원 배열로 받아서 이중반복문으로 검사한다.
# 0인 요소를 만나면 가로, 세로, 대각선, 사각형을 검사한다.
# 만약 1~9까지 어떤 숫자도 만족하지 않는다면 이전 값으로 돌아간다?
# i가 위의 조건을 만족한다면 list의 값을 i값으로 수정한다.
# 행의 숫자가 9가 되면 출력한다.

import sys

sudoku = [list(map(int,sys.stdin.readline().split())) for _ in range(9)]
answer = [arr[:] for arr in sudoku]
s_len = 0

def backTracking() :
    if s_len == 9 : print(" ".join(map(str, answer)));

    for i in range(9) :
        for j in range(9) :
            if sudoku[i][j] == 0 :
                answer[i][j] = j
                s_len += 1
                backTracking()
                # answer[i][j] = j # 중복 상관없이 순서대로 집어넣는다.
                # backTracking() # 재귀 함수 호출
                # answer.pop() # 자식 노드를 돌고 지움 > 자식 노드를 다 돌고나면 부모 노드 지움

backTracking()