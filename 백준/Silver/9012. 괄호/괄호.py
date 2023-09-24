# 스택에 (괄호가 추가되면 1을 더하고 )괄호가 추가되면 1을 뺀다
# 합이 0이 아니거나, 중간에 -1이 되면 No를 출력

import sys

t = int(sys.stdin.readline().strip())
for _ in range(t) :
    ps = list(sys.stdin.readline().strip())
    sum = 0
    for i in ps :
        if i == "(" : sum += 1;
        elif i == ")" : sum -= 1;

        if sum < 0 : break
    if sum != 0 : print("NO")
    else : print("YES");