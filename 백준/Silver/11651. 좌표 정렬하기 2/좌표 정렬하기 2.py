# 내장 함수 sort를 이용하여 정렬한다.

n = int(input().strip())
list = [list(map(int,(input().split()))) for _ in range(n)]
list.sort(key=lambda x: (x[1], x[0]))
for i in range(n) :
    print(" ".join(map(str,list[i])))