# 입력 받기
n, c, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

# dp 배열 초기화
dp = [0] * 500010

# 각 칼럼을 순회하며 dp 갱신
for j in range(1, c):
    dp = [0] * 500010
    for i in range(n):
        for k in range(1, m + 1):
            if k - arr[i][j - 1] < 0:
                continue
            dp[k] = max(dp[k], dp[k - arr[i][j - 1]] + (arr[i][j] - arr[i][j - 1]))
    m += dp[m]

# 결과 출력
print(m)
