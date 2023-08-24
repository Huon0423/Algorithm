# 1부터 주어진 수 n까지 반복문을 통해 생성자를 구하여 출력한다.
# 생성자는 map을 사용하여, 문자열로 바꾼 n을 list로 변환하여 sum으로 구한다.

n = int(input().strip())
i = 1

while i <= n :
    temp = map(int, list(str(i)))
    if sum(temp) + i == n :
        print(i)
        break
    if i == n :
        print(0)
    i = i+1