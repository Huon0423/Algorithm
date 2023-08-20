# f(n) = a1*n + a0 이므로, 입력받은 수로 f(n)을 구한다.
# 모든 n>=n0에 대하여, f(n) <= c * g(n)인지 확인한다.
# a1 n + a0 <= c n0
# (c-a1) n0 >= a0
# 1. c=a1 무조건 성립 안함
# 2. C는 a1보다 커야함.

a1, a0 = map(int,input().split())
c = int(input().strip())
n0 = int(input().strip())

def isSuccess(a1, a0, c, n):
    for i in range(n, 100+1):
        if a1 * i + a0 > c * i:
            return False
    return True

if (isSuccess(a1, a0, c, n0)):
    print(1)
else:
    print(0)