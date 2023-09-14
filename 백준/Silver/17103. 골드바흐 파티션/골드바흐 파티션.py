# 입력 범위까지 미리 소수 리스트를 만든다.
# 주어진 수에 소수를 뺀 값이 소수 리스트에 있는지 확인한다.

import sys

t = int(sys.stdin.readline()) # 테스트 케이스
prime_list = [True] * 1000001

for i in range(2, 1001): # 에라토스테네스의 체를 사용
    if prime_list[i] :
        for j in range(2 * i, 1000001, i):
            prime_list[j] = False

for _ in range(t) :
    answer = 0
    n = int(sys.stdin.readline().strip())
    for i in range(2,n//2+1) : # 소수인 2부터 n의 절반까지 반복문을 돌며 검사
        if prime_list[i] and prime_list[n-i] :
            answer += 1
    print(answer)

