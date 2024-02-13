n = int(input().strip())
num = n // 5
while True :
    if num < 0 : print(-1); break
    if (n - num * 5) % 3 == 0 : print((n - num * 5)//3 + num); break
    num -= 1