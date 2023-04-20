import sys

studentList = list(range(1,31))
homeworkList =[int(input()) for _ in range(28)]

for n in homeworkList:
    if n in studentList:
        studentList.remove(n)
print(studentList[0])
print(studentList[1])