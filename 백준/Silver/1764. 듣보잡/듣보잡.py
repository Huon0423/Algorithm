# 듣도 못한 사람과 보도 못한 사람을 각각 set에 넣어 저장한다.
# 두 set 중 교집합을 찾아 sort하여 answer에 리스트로 저장한다.

n,m = map(int, input().split())

hear = set()
for i in range(n) :
    hear.add(input())
see = set()
for i in range(m) :
    see.add(input())
answer = sorted(list(hear&see))
print(len(answer))
for i in answer : print(i)