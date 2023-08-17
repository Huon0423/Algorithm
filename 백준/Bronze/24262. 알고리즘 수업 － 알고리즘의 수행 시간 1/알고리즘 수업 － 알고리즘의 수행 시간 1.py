# 입력받은 n에 관계없이 함수는 1번만 실행되므로, 1과 0을 출력한다.

A = []
n = int(input().strip())

def MenOfPassion(A, n) :
    i = [n / 2]
    return A[i]; # 코드1

print("""1
0""")