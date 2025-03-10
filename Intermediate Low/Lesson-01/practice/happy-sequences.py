# 문제 URL: https://www.codetree.ai/trails/complete/curated-cards/challenge-number-of-happy-sequence/description

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]


def solution(x):
    res = 0
    # 가로 방향 체크
    r_tmp, r_cnt = grid[x][0], 1
    for i in range(1, n):
        if grid[x][i] == r_tmp:
            r_cnt += 1
        else:
            r_cnt = 1  # 다른 숫자가 나오면 카운터 초기화

        if r_cnt >= m:
            res += 1
            break
        r_tmp = grid[x][i]

    # 세로 방향 체크
    c_tmp, c_cnt = grid[0][x], 1
    for i in range(1, n):
        if grid[i][x] == c_tmp:
            c_cnt += 1
        else:
            c_cnt = 1  # 다른 숫자가 나오면 카운터 초기화

        if c_cnt >= m:
            res += 1
            break
        c_tmp = grid[i][x]

    return res


if m == 1:
    print(n * 2)
else:
    happy = 0
    for i in range(n):
        happy += solution(i)
    print(happy)