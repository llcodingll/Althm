# 문제 URL : https://www.codetree.ai/trails/complete/curated-cards/challenge-tromino/description

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]


# Write your code here!
def in_range(dr):
    x, y = dr
    return 0 <= x < n and 0 <= y < m


def block1(x, y):
    # x, y 기준으로 (위, 오른쪽), (오른쪽, 아래), (아래, 왼쪽), (왼쪽, 위) 비교
    arr = []

    # 좌, 상, 우, 하
    left, up, right, down = (x, y - 1), (x - 1, y), (x, y + 1), (x + 1, y)

    mx, num = 0, grid[x][y]

    # 범위 확인
    if in_range(left) and in_range(up):
        lx, ly = left
        ux, uy = up
        mx = max(mx, num + grid[lx][ly] + grid[ux][uy])

    if in_range(up) and in_range(right):
        rx, ry = right
        ux, uy = up
        mx = max(mx, num + grid[rx][ry] + grid[ux][uy])

    if in_range(right) and in_range(down):
        rx, ry = right
        dx, dy = down
        mx = max(mx, num + grid[rx][ry] + grid[dx][dy])

    if in_range(down) and in_range(left):
        lx, ly = left
        dx, dy = down
        mx = max(mx, num + grid[lx][ly] + grid[dx][dy])

    return mx


def block2(x, y):
    # x, y 기준으로 세로로 3칸, 가로로 3칸 더해서 최댓값 비교
    col = 0
    if x + 3 <= n:
        for i in range(x, x + 3):
            col += grid[i][y]

    # 가로
    row = 0
    if y + 3 <= m:
        for i in range(y, y + 3):
            row += grid[x][i]

    return max(row, col)


answer = 0
for i in range(n):
    for j in range(m):
        b1 = block1(i, j)
        b2 = block2(i, j)

        answer = max(answer, b1, b2)

print(answer)