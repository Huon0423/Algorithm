# 이중 반복문을 통해 문자열의 부분집합을 만들어 추가한다.
# 추가된 set은 중복을 허용하지 않으므로, 길이를 출력한다.

s = input()
answer = set()
for i in range(len(s)) :
    for j in range(i,len(s)) :
        answer.add(s[i:j+1])

print(len(answer))