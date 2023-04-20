n, m, k = map(int, input().split())
nArray = list(map(int, input().split()))
nArray.sort(reverse=True)
# maxCount는 제일 큰 수가 k+1번 반복되는 주기 안에서 한 주기마다 k번,
# 주기가 끝나고 남은 숫자만큼 반복되는 횟수를 모두 더한 값
maxCount = m // (k+1) * k + m % (k+1)
print(maxCount * nArray[0] + (m-maxCount) * nArray[1])