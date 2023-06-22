# 중복되지 않는 n개의 문자열과 m개의 문자열이 주어진다
# m개의 문자열 중 n개의 문자열과 겹치는 개수를 출력
# 최대 만 개의 문자열(m,n 각각) > 해쉬 사용해서 시간 감소
# for문으로 들어오는 모든 n개의 문자열을 해쉬 테이블에 저장
# for문으로 들어오는 모든 m개의 문자열을 해쉬 코드로 변환하여
# hash table에서 search하고 일치하는 개수를 count하여 반환

import hashlib

n, m = map(int,input().split())
hash_table = {}
count = 0

for _ in range(n) :
    value = input()
    hash_code = hashlib.sha256(value.encode()).hexdigest()
    hash_table[hash_code] = value

for _ in range(m) :
    value = input()
    search_code = hashlib.sha256(value.encode()).hexdigest()
    if search_code in hash_table : count += 1

print(count)