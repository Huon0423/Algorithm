timer = list(input())

def find_prime(n) :
    if n < 2 : return False
    for i in range(3, int(n ** 0.5) + 1, 2):
            if n % i == 0:
                return False
    return True

if not find_prime(int(''.join(timer))) : print("no")
elif '3' in timer or '4' in timer or '7' in timer: print("no")
else :
    timer.reverse()
    for i in range(len(timer)) :
        if timer[i] == '6' : timer[i] = '9'
        elif timer[i] == '9' : timer[i] = '6'
    timer = int(''.join(timer))
    print("yes") if find_prime(timer) else print("no")
