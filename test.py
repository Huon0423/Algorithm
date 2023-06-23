# 64보다 작거나 같은 입력값 x가 주어진다.
# 재귀함수를 사용하여 막대의 길이가 x보다 작아질 때까지 절반으로 쪼갠다.
# 막대가 1만큼 작아지거나, 막대와 x의 길이가 같다면 count를 증가시켜 반환한다.

x = int(input())
n = 64
count = 0

def divide_half(x, n) :
    if n == 1 or x == n : count += 1; return count
    elif x < n : divide_half(x, n // 2)
    elif x > n : x = x-n; divide_half(x, n)
    print(count)

print(divide_half(x, n))