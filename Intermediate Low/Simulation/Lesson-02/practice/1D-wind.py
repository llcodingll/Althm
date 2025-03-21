# 문제 URL: https://www.codetree.ai/trails/complete/curated-cards/challenge-The-1D-wind-blows/description

def chk(m, a, rowIdx, dr, visited) -> list[tuple[int, str]]:
    # 밀린 행 위아래 행과 열의 숫자와 일치하는지 확인
    moves = []
    # print(f"chk 함수 - rowIdx: {rowIdx}, dr: {dr}")

    row = rowIdx - 1

    # 첫 번째 행이 아닌 경우 위쪽 검사
    if 0 < row:
        next_row = row  # 현재 행 위의 행이 이동할 차례 
        next_dir = 'R' if dr == 'L' else 'L'
        
        if (next_row, next_dir) not in visited:
            for i in range(m):
                if a[row][i] == a[row-1][i]:
                    moves.append((next_row, next_dir))
                    # print(f"위쪽 검사: {next_row}행 이동 필요")
                    break

    # 마지막 행이 아닌 경우 아래쪽 검사                      
    if row < len(a)-1:
        next_row = row + 2  # 1-based index로 변환
        next_dir = 'R' if dr == 'L' else 'L'

        if (next_row, next_dir) not in visited:
            for i in range(m):
                if a[row+1][i] == a[row][i]:
                    moves.append((next_row, next_dir))
                    # print(f"아래쪽 검사: {next_row}행 이동 필요")
                    break
    
    # print(f"moves: {moves}")
    return moves


def move(m, a, rowIdx, dr) -> list[int]:
    # 왼쪽으로 밀기 
    if dr == 'L':
        tmp = a[rowIdx-1][m-1]
        for i in range(m-1, 0, -1):
            a[rowIdx-1][i] = a[rowIdx-1][i-1]
        a[rowIdx-1][0] = tmp

    # 오른쪽으로 밀기 
    else:
        tmp = a[rowIdx-1][0]
        for i in range(1, m):
            a[rowIdx-1][i-1] = a[rowIdx-1][i]
        a[rowIdx-1][m-1] = tmp

    return a


def solution(m, a, rowIdx, dr) -> list[int]:
    visited = set()

    # 첫 번째 이동
    a = move(m, a, rowIdx, dr)
    visited.add((rowIdx, dr))  # 첫 이동 기록

    # 전파 이동 체크 및 실행
    moves = chk(m, a, rowIdx, dr, visited)
    while moves:
        new_moves = []
        for curr_row, curr_dir in moves:
            if (curr_row, curr_dir) in visited:
                continue

            a = move(m, a, curr_row, curr_dir)
            visited.add((curr_row, curr_dir))  # 이동 기록

            # 이동 후 추가 전파 이동 체크
            add_moves = chk(m, a, curr_row, curr_dir, visited)
            new_moves.extend(add_moves)
        moves = new_moves

    return a


def main():
    n, m, q = map(int, input().split())
    a = [list(map(int, input().split())) for _ in range(n)]
    winds = [(int(r), d) for r, d in [input().split() for _ in range(q)]]
    
    for rowIdx, dr in winds:
        a = solution(m, a, rowIdx, dr)

    for row in a:
        print(*row)


if __name__ == "__main__":
    import sys, io

    sys.stdin = io.StringIO(
        """3 3 2
1 2 3
3 2 1
3 3 3
3 L
1 L"""
    )
    # 예제 출력
    # 3 1 2
    # 2 1 3
    # 3 3 3 

    main()