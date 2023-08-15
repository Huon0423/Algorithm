# 정해진 개수를 배열로 저장해서 들어오는 값과 비교한다.
# 두 수의 차이만큼을 배열에 저장하여 출력한다.

chess = [1,1,2,2,2,8]
whitePiece = list(map(int, input().split()))
answer= ""

for i in range(len(whitePiece)) :
    answer = answer + str(chess[i] - whitePiece[i]) + " "

print(answer.strip())