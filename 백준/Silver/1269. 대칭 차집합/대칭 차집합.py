# 집합 A와 B의 원소를 받을 set 2개를 생성하여 input()값을 받는다.
# 두 집합의 차집합을 구하고, 합집합으로 만들어 출력한다.

n,m = map(int, input().split())
A = set(map(int, input().split()))
B = set(map(int, input().split()))
print(len((A - B)|(B - A)))