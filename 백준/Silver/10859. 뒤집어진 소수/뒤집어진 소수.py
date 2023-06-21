# n이 2보다 작거나 짝수라면 소수가 아니고,
    # 3부터 n의 제곱근까지 2씩 건너뛰며 나눠서 떨어지면 소수가 아님
# 만약 input값에 3, 4, 7이 있다면 no를 출력
# 만약 input값이 소수가 아니라면 no를 출력
# input값의 길이에서 0까지 거꾸로 for문을 돌면서
# 만약 값이 6이나 9라면, 해당하는 자리만큼(10을 index로 제곰)
# 9나 6으로 바꿔 answer에 더해준다
# 만약 9나 6이 아니라면 바꾸지 않고 자리만큼만 곱해서 더해준다
# 나온 값이 소수라면 yes 아니라면 no 출력

timer = input()
answer = 0

def isPrime(n) :
    if n < 2 : return True
    for i in range(3, int(n ** 0.5)+1, 2):
            if n % i == 0:
                return True
    return False

if '3' in timer or '4' in timer or '7' in timer: print("no")
elif isPrime(int(timer)) : print("no")
else :
    for i in reversed(range(0, len(timer))) :
        value = timer[i]
        if value == '6' :
            answer += 9 * 10 ** i
        elif value == '9' :
            answer += 6 * 10 ** i
        else :
            answer += int(value) * 10 ** i
                 
    if isPrime(answer) : print("no")
    else : print("yes")
