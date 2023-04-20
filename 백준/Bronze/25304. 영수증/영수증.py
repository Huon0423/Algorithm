receipt = int(input())
type = int(input())
sum = 0

for _ in range(type):
    itemList = list(map(int,input().split()))
    sum += itemList[0] * itemList[1]

if sum == receipt:
    print("Yes")
else:
    print("No")