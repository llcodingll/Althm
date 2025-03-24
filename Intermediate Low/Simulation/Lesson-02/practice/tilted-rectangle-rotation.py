# 문제 URL: https://www.codetree.ai/trails/complete/curated-cards/challenge-rotate-slanted-rectangle/description

def solution(r, c, k, l, dir, grid):
    tmp = grid[r][c]
    move = [k, l, k, l]
    x, y = r, c

    # 반시계
    if dir == 0:
        dxs, dys = [-1, -1, 1, 1], [1, -1, -1, 1]
        for dx, dy, m in zip(dxs, dys, move):
            for i in range(m):
                nx, ny = x + dx, y + dy

                if nx == r and ny == c:
                    grid[nx][ny] = tmp
                    break 

                grid[nx][ny], tmp = tmp, grid[nx][ny]
                x, y = nx, ny

    # 시계
    if dir == 1:
        dxs, dys = [-1, -1, 1, 1], [-1, 1, 1, -1]

        for dx, dy, m in zip(dxs, dys, move[::-1]):
            for i in range(m):
                nx, ny = x + dx, y + dy

                if nx == r and ny == c:
                    grid[nx][ny] = tmp
                    break

                grid[nx][ny], tmp = tmp, grid[nx][ny]
                x, y = nx, ny


def main():
    n = int(input())
    grid = [list(map(int, input().split())) for _ in range(n)]

    # r행 c열에서 시작하여, 
    # 1번 방향으로 m1만큼, 2번 방향으로 m2만큼, 3번: m3, 4번: m4 
    # dir == 0 (반시계), dir == 1 (시계)
    r, c, m1, m2, m3, m4, dir = map(int, input().split())
    
    solution(r-1, c-1, m1, m2, dir, grid)

    for row in grid:
        print(*row)


if __name__ == "__main__":
    import sys, io

    sys.stdin = io.StringIO(
        """5
1 2 2 2 2
1 3 4 4 4
1 2 3 3 3
1 2 3 3 3
1 2 3 3 3
4 2 2 1 2 1 1"""
    )
    # 예제 출력
    # 4 5 2 5 6 6 
    # 2 3 2 2 3 3 
    # 5 3 3 4 3 4 
    # 4 4 5 5 6 5 

    main()