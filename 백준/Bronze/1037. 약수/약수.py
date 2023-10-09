# 제일 첫번째 수와 마지막 수를 곱하면 해당 수가 나온다.
# 따라서 약수를 순서대로 배열하고 0번째와 마지막 번째를 곱해서 출력한다.

import sys

_ = int(sys.stdin.readline())
list = list(map(int, sys.stdin.readline().split()))
list.sort()
print(list[0]*list.pop())