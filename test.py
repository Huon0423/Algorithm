# 같은 수의 삽입은 허용하되, 숫자가 모두 동일한 수열은 존재하면 안된다.
# 따라서 중복을 체크하는 조건문을 없애되, 삽입 후 삽입한 수부터 반복문을 시작한다.
import sys

n, m = map(int, sys.stdin.readline().split())
answer = []

def backTracking(idx) :
    if len(answer) == m : print(" ".join(map(str, answer))); return # m개만큼 뽑으면 그만

    for i in range(idx, n+1) :
        answer.append(i) # 중복 상관없이 순서대로 집어넣는다.
        backTracking(i) # 재귀 함수 호출
        answer.pop() # 자식 노드를 돌고 지움 > 자식 노드를 다 돌고나면 부모 노드 지움

backTracking(1)