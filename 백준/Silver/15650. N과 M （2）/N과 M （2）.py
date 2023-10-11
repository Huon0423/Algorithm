# 이전에 풀었던 문제에서 재귀함수에 뽑은 수+1부터 돌아가도록 변수를 넣어준다.

import sys

n, m = map(int, sys.stdin.readline().split())
answer = []

def backTracking(idx) :
    if len(answer) == m : print(" ".join(map(str, answer))); return # m개만큼 뽑으면 그만

    for i in range(idx, n+1) :
        if i not in answer : # 이미 뽑힌 수가 아니라면
            answer.append(i) # 답에 집어넣는다
            backTracking(i+1) # 나보다 큰 수부터 재귀함수 호출
            answer.pop() # 자식 노드를 돌고 지움 > 자식 노드를 다 돌고나면 부모 노드 지움

backTracking(1)