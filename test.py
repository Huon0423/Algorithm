# 하루에 1개만 살 수 있기에, 제일 매매가가 큰 날 전까지 계속 사는게 좋다.
# max값을 찾아서 max값의 index를 반환하는 함수를 만든다.
# list에서 max값을 찾아 그 전까지 매일 구매한다 > 지출을 따로 저장한다.
# max의 index 이후 값부터 새로 list를 만들어 반복한다.
# 번 돈은 max값이 바뀌기 전에 max*index - 지출을 sum에 저장한다.

T = int(input())

def findMaxIndex(p_list) : # max값의 index를 반환해주는 함수
    index = 0
    max = p_list[0]
    for i in range(len(p_list)) :
        if p_list[i] >= max : max= p_list[i]; index = i
    return index

for test_case in range(1, T + 1):
    p_len = int(input())
    prices = list(map(int, input().split()))
    p_exp = 0 # 지출
    p_sum = 0 # 이익
    while len(prices) > 0 :
        max_index = findMaxIndex(prices)
        p_exp = sum(prices[i] for i in range(max_index)) # 최댓값 이전까지의 지출
        p_sum += prices[max_index] * max_index - p_exp # 지출을 제외한 순이익
        if len(prices) == max_index + 1 : break # 최댓값이 리스트의 마지막 값이었으면 종료
        else : prices = prices[max_index+1:] # 아니라면 최댓값 이후부터 리스트 슬라이싱
    print(p_sum)
    
        
    