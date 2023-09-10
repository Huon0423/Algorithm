# 분수 A/B는 A를 B로 나눈 상태를 말한다.
# 기약분수로 만들기 위해 최대공약수로 두 수를 나누면 된다.

import sys

a, b = map(int,sys.stdin.readline().strip().split())
c, d = map(int,sys.stdin.readline().strip().split())
aa, bb = a*d+c*b, b*d

while bb != 0:
    aa = aa % bb
    aa, bb = bb, aa

print((a*d+c*b) // aa, (b*d) // aa)