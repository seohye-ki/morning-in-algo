MAX = 100000

# 선형 함수 f(x) = ax + b를 정의하는 클래스
class Line:
    def __init__(self, slope, intercept, x_cross=0.0):
        self.slope = slope
        self.intercept = intercept
        self.x_cross = x_cross

# 두 직선의 교점을 구하는 함수
def find_cross(f, g):
    return (g.intercept - f.intercept) / (f.slope - g.slope)

# 입력 처리
n = int(input())
x_vals = list(map(int, input().split()))
y_vals = list(map(int, input().split()))

# 필요한 변수 초기화
lines = []
dp = [0] * MAX

# 동적 계획법을 사용하여 dp 배열 계산
for i in range(1, n):
    new_line = Line(y_vals[i - 1], dp[i - 1])  # (slope, intercept)

    # 선형 경로에서 교점을 계산하여 불필요한 직선을 제거
    while len(lines) >= 1:
        new_line.x_cross = find_cross(new_line, lines[-1])

        if new_line.x_cross < lines[-1].x_cross:
            lines.pop()  # new_line이 top보다 밑에 있으므로 top을 제거
        else:
            break

    lines.append(new_line)

    x = x_vals[i]
    best_line_index = 0

    left, right = 0, len(lines) - 1

    # 이진 탐색을 통해 x에 가장 적합한 선형 함수 찾기
    while left <= right:
        mid = (left + right) // 2
        if lines[mid].x_cross < x:
            best_line_index = mid
            left = mid + 1
        else:
            right = mid - 1

    # dp 값 갱신
    dp[i] = lines[best_line_index].slope * x + lines[best_line_index].intercept

# 결과 출력
print(dp[n - 1])
