# 숫자를 기준으로 앞뒤로 가므로, 기준 index는 숫자로 하여 함수에 인자로 준다.
# 정답 리스트에 값을 넣고 max와 min으로 출력

import sys

n = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
ops = list(map(int, sys.stdin.readline().split())) # 연산자 리스트
answer = []

# tmp = 중간값, count = nums의 index
def backTracking(tmp, count) :
    if count == n : answer.append(tmp); return

    for i in range(4) :
        if ops[i] > 0 :
            ops[i] -= 1
            if i == 0 : backTracking(tmp + nums[count], count + 1)
            elif i == 1 : backTracking(tmp - nums[count], count + 1)
            elif i == 2 : backTracking(tmp * nums[count], count + 1)
            else : 
                if tmp > 0 : backTracking(tmp // nums[count], count + 1)
                else : backTracking((-1 * tmp) // nums[count] * -1, count + 1)
            ops[i] += 1

backTracking(nums[0], 1)
print(max(answer))
print(min(answer))