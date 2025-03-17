n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
commands = [int(input()) for _ in range(m)]

# Please write your code here.
# 십자 모양 폭발 터트리기 
def bomb(r, c):
    num = grid[r][c-1]
    grid[r][c-1] = 0 

    x, y = r, c-1
    dxs, dys = [-1, 0, 1, 0], [0, 1, 0, -1]
    for dx, dy in zip(dxs, dys):
        for i in range(1, num):
            nx, ny = x + (dx * i), y + (dy * i)
            if 0 <= nx < n and 0 <= ny < n:
                grid[nx][ny] = 0 

    # 중력으로 값 떨어뜨리기 
    tmp = [[0] * n for _ in range(n)]

    for j in range(n):
        k = n-1
        for i in range(n-1, -1, -1):
            if grid[i][j] != 0:
                tmp[k][j] = grid[i][j]
                k -= 1

    for i in range(n):
        for j in range(n):
            grid[i][j] = tmp[i][j] 

    return grid


# M번에 걸쳐 폭탄이 터지고, 중력이 작용한 것을 반복한 이후의 결과
for c in commands:
    for i in range(n):
        if grid[i][c-1] != 0:
            bomb(i, c)
            break


for row in grid:
    print(*row)