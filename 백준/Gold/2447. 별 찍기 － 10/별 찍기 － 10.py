#별 찍기

import sys

n = int(sys.stdin.readline())

def star(s):
    if s == 3:
        return ['***','* *','***']

    arr = star(s//3)
    stars = []

    for i in arr:
        stars.append(i*3)

    for i in arr:
        stars.append(i+' '*(s//3)+i)

    for i in arr:
        stars.append(i*3)

    return stars

print('\n'.join(star(n)))