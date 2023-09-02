# n만큼 입력받으며 dict에 이름과 순서를 저장한다.
# 원활하게 찾기 위해, 반대의 경우(순서, 이름)의 dict를 만든다.
# m만큼 입력받은 질문 리스트를 dict에서 key나 value를 찾아 출력한다.

import sys

n, m = map(int,sys.stdin.readline().split())
pocketmons1 = dict()
questions = []
for i in range(1, n+1) :
    pocketmons1[i] = sys.stdin.readline().strip()
pocketmons2 = {v:k for k,v in pocketmons1.items()} # 뒤집힌 dict 생성
for j in range(m) :
    questions.append(sys.stdin.readline().strip()) # 질문 리스트 생성
for k in questions :
    if k.isdecimal() == True : print(pocketmons1[int(k)])
    else : print(pocketmons2[k])