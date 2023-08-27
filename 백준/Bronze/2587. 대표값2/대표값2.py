# 삽입정렬 - 2번째부터 차례대로 앞과 비교해서 삽입할 위치를 지정하여 옮긴다.

list = [int(input()) for _ in range(5)]

for i in range(1,5) :
    tmp = list[i] # 크기를 비교하여 이동할 숫자
    j = i-1
    while j >= 0 and list[j] > list[j+1] :
        list[j+1] = list[j]
        list[j] = tmp
        j -= 1

print(sum(list)//5)
print(list[2])