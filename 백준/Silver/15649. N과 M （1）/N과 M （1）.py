# n개 중에서 m개를 뽑는 조합이므로 백트래킹을 사용한다.
# 백트래킹은 모든 가능한 경우의 수 중에 특정한 조건을 만족하는 경우만 살피는 것이다.
# 재귀 함수를 이용한 백트래킹 함수를 만들어 사용한다.
# answer에 str(i)로 append했더니 이미 뽑힌 수임에도 아니라고 판명나서 출력오류..

import sys

n, m = map(int, sys.stdin.readline().split())
answer = []

def backTracking() :
    if len(answer) == m : print(" ".join(map(str, answer))); return # m개만큼 뽑으면 그만

    for i in range(1, n+1) :
        if i not in answer : # 이미 뽑힌 수가 아니라면
            answer.append(i) # 답에 집어넣는다
            backTracking() # 재귀함수 호출
            answer.pop() # 자식 노드를 돌고 지움 > 자식 노드를 다 돌고나면 부모 노드 지움
backTracking()