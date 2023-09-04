# n,m으로 두 숫자 리스트를 입력받아, for문을 돌며 n의 중복된 숫자 개수를 hash에 저장한다.
# hash에서 m리스트의 숫자의 개수를 뽑아 출력한다.

from sys import stdin

_ = stdin.readline()
n = map(int,stdin.readline().split())
_ = stdin.readline()
m = map(int,stdin.readline().split())
hashmap = {}
for i in n:
    if i in hashmap:
        hashmap[i] += 1
    else:
        hashmap[i] = 1

print(' '.join(str(hashmap[j]) if j in hashmap else '0' for j in m))