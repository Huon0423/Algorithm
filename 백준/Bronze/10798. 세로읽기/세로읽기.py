from itertools import zip_longest

first = list(input())
second = list(input())
third = list(input())
forth = list(input())
fifth = list(input())

verticalArray = list(zip_longest(first, second, third, forth, fifth, fillvalue=""))
verticalRead = ""

for i in range(len(verticalArray)):
    for j in range(len(verticalArray[i])):
            verticalRead += verticalArray[i][j]


print(verticalRead)