# 입력값으로 양의 정수 n개와, 주어진 수 m이 들어온다.
# n의 세제곱만큼 삼삼중반복문을 돌며, 숫자 2개를 정하고, 나머지 하나를 정해 m에 가까운 값을 저장한다.
# 저장된 값 중 가장 m에 가까운 합을 저장한다.

n, m = map(int, input().split())
cards = list(map(int, input().split()))
answer = 0

for i in range(n) :
    for j in range(i+1, n) :
        for k in range(j+1, n) :
            sum =  cards[i] + cards[j] + cards[k]
            if sum <= m :
                answer = max(answer, sum)
print(answer)