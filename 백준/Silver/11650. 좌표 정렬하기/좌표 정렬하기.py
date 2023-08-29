# 내장 함수 sort를 이용하여 정렬한다.

n = int(input().strip())
list = sorted([list(map(int,(input().split()))) for _ in range(n)])
for i in range(n) :
    print(" ".join(map(str,list[i])))