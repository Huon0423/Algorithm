# 중복을 허용하므로, for문에서 중복을 체크하는 조건문을 없애준다.

import sys

n, m = map(int, sys.stdin.readline().split())
answer = []

def backTracking() :
    if len(answer) == m : print(" ".join(map(str, answer))); return # m개만큼 뽑으면 그만

    for i in range(1, n+1) :
        answer.append(i) # 중복 상관없이 순서대로 집어넣는다.
        backTracking() # 재귀 함수 호출
        answer.pop() # 자식 노드를 돌고 지움 > 자식 노드를 다 돌고나면 부모 노드 지움

backTracking()