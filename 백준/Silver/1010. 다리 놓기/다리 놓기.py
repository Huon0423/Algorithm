# m개에서 미리 n개만큼 골라서 n개에 배정해주면 되기 때문에
# 즉, m개에서 n개를 고르는 조합과 같다.
import sys, math

t = int(sys.stdin.readline())

for _ in range(t) :
    n, m = map(int, sys.stdin.readline().split())
    print(math.factorial(m)//(math.factorial(m-n)*math.factorial(n)))