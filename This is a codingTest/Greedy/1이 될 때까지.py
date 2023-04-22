n, k = map(int, input().split())
count = 0

while n > 1:
    n = n // k if n % k ==0 else n - 1
    count += 1

print(count)