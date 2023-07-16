# 동기 수 n과 친구관계 리스트 m개만큼의 관계가 입력
# 먼저 m만큼 돌면서 앞에 1이 나오면, 뒤의 숫자를 친구 리스트에 저장
# 친구 리스트에 존재하는 숫자가 앞에 나오면, 뒤의 숫자를 초대 리스트에 저장
# 친구리스트와 초대리스트를 구분하는 이유 : 친구의 친구의 친구는 초대X

n = int(input())
m = int(input())
relations = []
friends = []
visitor = []

for i in range(m) :
    relations.append(list(map(int, input().split())))
    if relations[i][0] == 1 : # 1은 가장 작은 수이므로, 친구 관계에서 항상 앞에 존재
        if relations[i][1] <= n : 
            friends.append(relations[i][1])

for i in range(len(relations)) : # friends는 이미 앞의 반복문에서 n보다 작은걸 확인
    if relations[i][0] in friends : # 다른 친구들은 1보다 크므로 [0][1]을 구분해서 추가
        if relations[i][1] <= n : 
            visitor.append(relations[i][1])
    elif relations [i][1] in friends and relations[i][0] != 1 :
        if relations[i][0] <= n : 
            visitor.append(relations[i][0])

visitor = visitor + friends
visitor = list(set(visitor))
print(len(visitor))