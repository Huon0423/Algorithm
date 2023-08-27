# 삽입정렬 - 2번째부터 차례대로 앞과 비교해서 삽입할 위치를 지정하여 옮긴다.

n = int(input().strip())
list = list(map(int,list(input().strip() for _ in range(n))))

for i in range(1,n) :
    tmp = list[i] # 크기를 비교하여 이동할 숫자
    j = i-1
    while j >= 0 and list[j] > list[j+1] :
        list[j+1] = list[j]
        list[j] = tmp
        j -= 1

print("\n".join(str(i) for i in list))