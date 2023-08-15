# 과일의 개수 n과 현재 길이 L, 과일들의 높이가 주어진다.
# 먼저 과일들을 오름차순으로 정렬하여, for문에서 차례대로 검사해준다.
# L보다 작거나 같은 과일이 생기면 +1 하고, 그 과일을 없애고 다시 for문을 돌린다.

n, height = map(int,input().split())
fruits = list(map(int, input().split()))
fruits.sort()
i = 0

while i < len(fruits) :
    if fruits[i] <= height :
        height += 1
        del fruits[i]
        i = 0
    else : i += 1

print(height)