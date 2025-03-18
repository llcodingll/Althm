n, m = map(int, input().split())
numbers = [int(input()) for _ in range(n)]

# Please write your code here.

# 연속되는 숫자 마지막 위치 구하기 
def get_end_idx_of_explosion(start_idx, curr_num):
    for end_idx in range(start_idx + 1, len(numbers)):
        if numbers[end_idx] != curr_num:
            return end_idx - 1
        
    return len(numbers) - 1  # 끝까지 탐색했을 때 


while True:
    did_explode = False
    curr_idx = 0 

    while curr_idx < len(numbers):
        end_idx = get_end_idx_of_explosion(curr_idx, numbers[curr_idx])

        if end_idx - curr_idx + 1 >= m:  # 연속 숫자가 m개보다 같거나 많을 때
            del numbers[curr_idx:end_idx+1]  # 해당 부분 수열 삭제 
            did_explode = True
        else:
            curr_idx = end_idx + 1  # 터질 수 없는 경우, 시작 위치 갱신

    if not did_explode:  # 폭발이 안 일어나면 종료
        break 

print(len(numbers))
for number in numbers:
    print(number)