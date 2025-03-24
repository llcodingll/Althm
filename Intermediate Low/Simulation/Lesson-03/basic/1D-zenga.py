n = int(input())
blocks = [int(input()) for _ in range(n)]
s1, e1 = map(int, input().split())
s2, e2 = map(int, input().split())

# Write your code here!

lst = [(s1, e1), (s2, e2)]

for i in lst:
    tmp = []
    for j in range(len(blocks)):  # 0, 1, 2
        if j < i[0]-1 or j >= i[1]:
            tmp.append(blocks[j])
    blocks = tmp

print(len(blocks))
for i in blocks:
        print(i)