import sys

n = int(sys.stdin.readline())
ans = 0
cities = list(map(int, input().split()))
prices = list(map(int, input().split()))

min_price = 1000000000
min_price_index = -1
for i in range(n-1):
    if prices[i] < min_price:
        min_price = prices[i]
        min_price_index = i

for i in range(n-1):
    if i == min_price_index:
        ans += (prices[i] * sum(cities[i:]))
        break
    
    else:
        ans += (prices[i] * cities[i])

print(ans)