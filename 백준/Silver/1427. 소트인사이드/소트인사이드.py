# 입력받은 수를 문자열 리스트로 바꾼뒤, 숫자로 바꿔 정렬한다.

n = int(input().strip())
list = sorted(list(str(n)), reverse=True)
print("".join(list))