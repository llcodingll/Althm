# 십자 모양 폭발: https://www.codetree.ai/trails/personalized/curated-cards/challenge-cross-shape-bomb/description

'''
조건
1. 선택된 좌표의 원소값에 비례하여 커진다. 
ex) 3 -> 자신 포함 + 2까지 터진다. 
2. 터진 이후에는 중력에 의해 숫자들이 아래로 떨어진다. 
'''
# Write your code here!

# 선택된 원소를 기준으로 터트리는 함수
def bomb(grid, n, r, c):
    x, y = r-1, c-1
    num = grid[x][y]
    grid[x][y] = 0
    
    dxs, dys = [-1, 0, 1, 0], [0, 1, 0, -1]
    for dx, dy in zip(dxs, dys):

        # 원소값-1 만큼 터트리기
        for i in range(1, num): 
            nx, ny = x + (dx * i), y + (dy * i)

            # 격자 안이면, 터트리기
            if 0 <= nx < n and 0 <= ny < n:
                grid[nx][ny] = 0 


# 터진 이후 숫자들을 아래로 떨어뜨리는 함수
def gravity(grid, n):
    # 1. 임시 2차원 배열 만들기 
    tmp = [[0] * n for _ in range(n)]
    
    # 2. 아래->위, 비어있지 않을 때만 tmp에 넣어준다. 
    for j in range(n):
        k = n-1
        for i in range(n-1, -1, -1):
            if grid[i][j] != 0:
                tmp[k][j] = grid[i][j]
                k -= 1

    # 3. tmp 값을 기존 배열에 다시 옮겨준다. 
        for i in range(n):
            grid[i][j] = tmp[i][j]


def solution(n, grid, r, c):
    bomb(grid, n, r, c)

    gravity(grid, n)

    for row in grid:
        print(*row)


import sys
def main():
    input = sys.stdin.readline
    n = int(input())
    grid = [list(map(int, input().split())) for _ in range(n)]
    r, c = map(int, input().split())

    solution(n, grid, r, c)

main()