# 이차원 배열에 나이와 이름과 index를 저장한다.
# sort를 사용하여 정렬한다. >> 파이썬은 stable sort지향(순서 보장)

n = int(input().strip())
members = []

for i in range(n) :
    age, name = input().split()
    members.append((int(age),name))
members.sort(key=lambda x:(x[0]))
for m in members :
    print(m[0],m[1])