# 줄을 선 사람의 수 n(1~1000)과 각 사람의 인출 시간 Pi(1~1000)가 주어진다.
# 필요한 시간의 값을 구하는 방식은 1,1+2,1+2+3,1+2+3+4,1+2+3+4...+n
# 앞순서가 중복으로 더해지므로 걸리는 시간이 가장 짧은 순으로 나열하면 된다.
# 정렬된 인출 시간들을 누적 합 함수 cumsum을 사용해 구한다. > numpy 사용 불가
# for 문으로 대체하여, 0부터 i까지의 합을 변수에 모두 더한다.

# import numpy as np

n = int(input())
times = list(map(int, input().split()))
times.sort()
all_sum = 0

# print(sum(np.cumsum(times)))
for i in range(n) :
    all_sum += sum(times[:i+1])

print(all_sum)