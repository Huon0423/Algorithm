# -999부터 999까지 이중반복문을 돌며, x와 y를 찾는다.

a, b, c, d, e,f = map(int,input().split())

for x in range(-999,1000) :
    for y in range(-999, 1000) :
        if a*x + b*y == c and d*x + e*y == f :
            print(x,y)
            break
            