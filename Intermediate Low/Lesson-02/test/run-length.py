A = input()

# Write your code here!
word, tmp, mn = list(A), A[0], float('inf')
while True:
    # run-length encoding
    cnt, res = 1, ''
    for i in range(1, len(word)):
        if word[i] != word[i-1]:
            res += word[i-1] + str(cnt)
            cnt = 1
        else:
            cnt += 1
    
    res += word[-1] + str(cnt)
    
    mn = min(mn, len(res))

    # shift
    w = word[-1]
    for i in range(len(word)-1, 0, -1):
        word[i] = word[i-1]
    
    word[0] = w
    
    if word == list(A):
        break

print(mn)