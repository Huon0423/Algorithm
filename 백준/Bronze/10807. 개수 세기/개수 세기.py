n = int(input())
findList = list(map(int,input().split()))
findNum = int(input())
totalFind = 0

for i in findList:
    if i == findNum:
        totalFind += 1

print(totalFind)