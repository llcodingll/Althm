n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# Write your code here!
def solution(x, y):
    cnt = 0
    for i in range(x, x+3):
        for j in range(y, y+3):
            if grid[i][j] == 1:
                cnt += 1
    
    return cnt


max_coin = 0
for i in range(n):
    for j in range(n):
        if i + 2 < n and j + 2 < n:
            num_coin = solution(i, j)
            max_coin = max(max_coin, num_coin)

print(max_coin)