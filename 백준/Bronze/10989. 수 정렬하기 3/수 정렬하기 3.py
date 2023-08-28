# 4byte의 int형을 천만 번 검사하면 40MB로 제한을 넘는다.
# 따라서 길이가 10000인 배열에 입력된 자연수의 개수를 해당하는 index에 저장한다.
# input 대신 int(sys.stdin.readline()) 를 써야한다...

import sys

n = int(input().strip())
sorted_list = [0]*10001

for i in range(n) :
    sorted_list[int(sys.stdin.readline())] += 1 # 입력값에 해당하는 index의 값을 1 증가시킨다.

for i in range(10001) :
    if sorted_list[i] > 0 :
        for j in range(sorted_list[i]) :
            print(i)