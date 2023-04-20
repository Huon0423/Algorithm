import sys

currentHours, currentMinutes = map(int, input().split())
cookingMinutes = int(input())
temp = cookingMinutes + currentMinutes

currentHours += temp//60
currentMinutes = temp%60
currentHours %= 24

print(currentHours, currentMinutes)