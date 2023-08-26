# 주어진 n에서 5를 최대한 빼고 나머지가 3에 맞아 떨어지는 경우를 출력

n = int(input().strip())
num = n // 5
answer = 0

while True :
    temp = n
    if num < 0 : print(-1); break
    if (temp - num * 5) % 3 == 0 :
        print((temp - num * 5)//3 + num); break
    else :
        num -= 1