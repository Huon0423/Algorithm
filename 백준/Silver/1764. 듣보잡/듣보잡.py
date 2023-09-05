n,m = map(int, input().split())

a = set()
for i in range(n) :
    a.add(input())
b = set()
for i in range(m) :
    b.add(input())
answer = sorted(list(a&b))
print(len(answer))
for i in answer : print(i)