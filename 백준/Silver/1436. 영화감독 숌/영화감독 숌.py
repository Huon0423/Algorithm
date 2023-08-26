# 666부터 숫자를 증가시키며, 6이 연속되는 경우를 저장한다.
# 저장된 리스트의 개수가 n가 같아지면 반복문을 종료한다.
# 1'666'6과 16'666'으로 같은 수를 2번 이상 세는 경우가 존재하므로, break 처리

n = int(input().strip())
t = 666
n_list = []

while len(n_list) < n :
    str_t = list(str(t))
    for i in range(len(str_t)-2) :
        if str_t[i] == '6' and str_t[i+1] == '6' and str_t[i+2] == '6' :
            n_list.append(t)
            break
    t += 1
print(max(sorted(n_list)))