# 일단 내장함수로 써보기

n = int(input().strip())
list = [int(input()) for _ in range(n)]
list.sort()
print("\n".join(str(i) for i in list))