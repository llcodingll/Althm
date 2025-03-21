# 격자 크기, 블록 크기, 떨어질 시작 열
n, m, k = map(int, input().split())

# N x N 크기의 격자, 0은 빈 칸, 1은 블럭 채워진 칸
grid = [list(map(int, input().split())) for _ in range(n)]

# 블럭이 차지하는 시작, 끝 열
s, e = k - 1, k + m - 1

# 블럭이 떨어질 위치 찾기
for i in range(n):
    if any(grid[i][j] == 1 for j in range(s, e)):  # 블럭이 닿으면 멈춤
        i -= 1
        break

# 블럭 놓기
for j in range(s, e):
    grid[i][j] = 1

# 배열 출력
for row in grid:
    print(*row)
