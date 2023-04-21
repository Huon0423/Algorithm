n, m = map(int, input().split())
cardArray = [list(map(int, input().split())) for _ in range(n)]
minArray = [0] * n

for i in range(0,n):
    minArray.append(min(cardArray[i]))

print(max(minArray))