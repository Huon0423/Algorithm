# input을 리스트에 저장하고, 순서대로 나올 때까지 스택에 저장한다.
# 만약 스택의 길이가 0이 아니면 input과 스택을 같이 검사한다.
# 둘 다 순서에 안 맞으면 list의 수를 스택에 저장한다.

import sys

n = int(sys.stdin.readline())
list = list(map(int, sys.stdin.readline().split()))
stack = []
index = 1

for i in list :
    if index == i :
        index += 1 # 다음 순서로 세팅
    elif stack[-1] == index :
        stack.pop()
    else :
        stack.append[i]
if len(stack) > 1 :print("Sad")
else : print("Nice")