# 문제 URL: https://www.codetree.ai/trails/complete/curated-cards/challenge-The-2D-wind-blows/description

def move(sx, sy, fx, fy, a) -> list[int]:
    # 시계방향으로 이동하는 함수
    '''
    회전은 좌표 기준으로 확인
    목적지 기준으로 생각
    '''
    dr = 0
    # 시계방향으로 90도 회전 
    # i, j+1 (우) i+1, j (하) i, j-1 (좌) i-1, j (상) 
    dxs, dys = [0, 1, 0, -1], [1, 0, -1, 0]

    x, y = sx, sy
    tmp = a[x][y]

    while True:
        # 다음 위치 계산
        nx, ny = x + dxs[dr], y + dys[dr]

        # 값 이동 및 위치가 시작 값이면 값 이동 후 종료
        if sx <= nx < fx+1 and sy <= ny < fy+1:
            # 시작점으로 돌아오면 종료 
            if sx == nx and sy == ny:
                a[nx][ny] = tmp
                break

            a[nx][ny], tmp = tmp, a[nx][ny]
            x, y = nx, ny

        # 방향 전환이 필요한 경우
        else:
            dr = (dr + 1) % 4


def avg(n, m, sx, sy, fx, fy, a) -> int:
    # 평균 값으로 변환하는 과정은 동시에 일어남 
    tmp_a = [row[:] for row in a]  # 기존 배열 복사

    for x in range(sx, fx+1):
        for y in range(sy, fy+1):
            total, cnt = a[x][y], 1

            # i, j의 상좌하우 원소가 존재하는지 확인 -> 있으면 더하기
            dxs, dys = [-1, 0, 1, 0], [0, 1, 0, -1]
            for dx, dy in zip(dxs, dys):
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m:
                    total += a[nx][ny]
                    cnt += 1

            tmp_a[x][y] = total // cnt

    return tmp_a


def solution(n, m, q, a, winds) -> list[int]:
    # 회전 시키고, 평균 값 변경하는 함수 
    for i in range(q):
        x1, y1, x2, y2 = winds[i]

        sx, sy, fx, fy = x1-1, y1-1, x2-1, y2-1
        # step 1. 가장자리 회전 
        # -> 무슨 정보가 필요하지? 직사각형 범위만 있으면 됨
        move(sx, sy, fx, fy, a)
        
        # step 2. 직사각형 원소 값 바꾸기(평균 - 소수점 버림)
        a = avg(n, m, sx, sy, fx, fy, a)
    
    return a


def main():
    n, m, q = map(int, input().split())

    # Create 2D array for building state
    a = [list(map(int, input().split())) for _ in range(n)]

    # Process wind queries
    winds = [tuple(map(int, input().split())) for _ in range(q)]

    a = solution(n, m, q, a, winds)

    for row in a:
        print(*row)


if __name__ == "__main__":
    import sys, io

    sys.stdin = io.StringIO(
        """4 6 1
4 5 2 5 6 6
2 1 6 1 0 5
5 2 2 1 6 5
4 5 2 8 8 6
2 2 4 6"""
    )
    # 예제 출력
    # 4 5 2 5 6 6 
    # 2 3 2 2 3 3 
    # 5 3 3 4 3 4 
    # 4 4 5 5 6 5 

    main()