# max, min으로 최댓값과 최솟값을 구한다.
# index로 두 수의 index를 알아내 숫자를 각각 1씩 줄이고 더해서 바꿔준다.

T = 10

for test_case in range(1, T + 1):
    dump = int(input())
    box_list = list(map(int, input().split()))
    while dump > 0 :
        m = max(box_list)
        n = min(box_list)
        box_list[box_list.index(m)] = m - 1
        box_list[box_list.index(n)] = n + 1
        dump -= 1
    print(f"#{test_case}", max(box_list)-min(box_list))