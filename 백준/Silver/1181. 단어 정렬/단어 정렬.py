# 이차원 배열에 단어의 길이와, 단어를 각각 저장한다.
# sort를 사용하여 정렬하고, 중복은 set을 사용하여 제거한다.
# set은 hashable한 자료형만 실행가능하므로 tuple을 사용한다

n = int(input().strip())
words = [[0]*2 for _ in range(n)]

for i in range(n) :
    word = input().strip()
    words[i][0] = len(word)
    words[i][1] = word
words = list(set(map(tuple, words)))
words.sort(key=lambda x:(x[0],x[1]))
for i in range(len(words)) :
    print(words[i][1])