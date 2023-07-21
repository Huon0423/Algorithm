# 입력값으로 배열의 크기와, 제한 크기, 배열이 주어진다.
# 많이 나오고, 먼저 나온 순서대로 배열을 정렬한다.
# 배열의 크기만큼 반복문을 돌며 숫자와 나온 횟수를 같이 저장한다.
# 순서를 기억하기 위해, orderedDict를 사용한다.
# sort를 사용하여 해쉬의 값의 크기대로 내림차순으로 정렬한다.
# 반복문을 돌며, 순서대로 값만큼 키를 반복하여 출력한다.

from collections import OrderedDict

od = OrderedDict()

n, c = map(int, input().split())
psword = list(map(int, input().split()))

for i in range(len(psword)) :
    if psword[i] in od.keys() : # 배열의 숫자가 이미 나왔다면
        od[psword[i]] = od[psword[i]] + 1
    else : # 배열의 숫자가 처음 나왔다면
        od[psword[i]] = 1

sorted_od = OrderedDict(sorted(od.items(), key=lambda x: x[1], reverse=True))

for k in sorted_od.keys() :
    print(((str(k)+' ') * sorted_od[k]).rstrip(), end=' ')