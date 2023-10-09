# 왜 안되지 push...

import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
word_lst = {}

for _ in range(N):
    word = input().rstrip()
    
    if len(word) < M: # 단어가 M미만인 경우
        continue
    else:
        if word in word_lst: # 단어가 있는 경우
            word_lst[word] += 1
        else:
            word_lst[word] = 1

word_lst = sorted(word_lst.items(), key = lambda x : (-x[1], -len(x[0]), x[0]))

for i in word_lst:
    print(i[0])