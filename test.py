# 점수는 0부터 100까지이므로, 길이가 101인 배열을 만든다.
# 각 수에 해당하는 index에 수가 나올때마다 +1을 해준다.
# 빈도가 가장 높은 index를 출력한다.

T = int(input())

for test_case in range(T) :
    t = int(input())
    students = list(map(int, input().split()))
    scores = [0] * 101
    max = answer = 0
    for s in students :
        scores[s] += 1
    for i in range(101) :
        if scores[i] >= max : max = scores[i]; answer = i
    print(f"#{t}", answer)