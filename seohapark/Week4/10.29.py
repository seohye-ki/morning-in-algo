import sys
input = sys.stdin.read

# 비트마스크 배열 및 보드 초기화
bit_mask = [[-1] * (1 << 10) for _ in range(10)]
board = [[''] * 10 for _ in range(10)]

def dfs(lines, dfs_array, index, m):
    # 모든 인덱스에 대해 값을 채운 경우 문자열로 변환하여 저장
    if index == m:
        line = ''.join(map(str, dfs_array))
        lines.append(line)
        return
    
    dfs_array[index] = 0
    dfs(lines, dfs_array, index + 1, m)

    if index > 0 and dfs_array[index - 1] != 0:
        return
    
    dfs_array[index] = 1
    dfs(lines, dfs_array, index + 1, m)

def dp(lines, line_number, before_bits, n, m):
    if line_number == n:
        return 0

    if bit_mask[line_number][before_bits] != -1:
        return bit_mask[line_number][before_bits]

    answer = 0
    for line in lines:
        bits = 0
        count = 0
        for i in range(m):
            if line[i] == '0':
                continue
            if board[line_number][i] == 'x':
                continue
            if i > 0 and (before_bits & (1 << (i - 1))):
                continue
            if i < m - 1 and (before_bits & (1 << (i + 1))):
                continue

            count += 1
            bits |= (1 << i)

        answer = max(answer, dp(lines, line_number + 1, bits, n, m) + count)

    bit_mask[line_number][before_bits] = answer
    return answer

def solve(n, m, board_data):
    global board, bit_mask
    # 비트마스크와 보드를 매 케이스마다 초기화
    bit_mask = [[-1] * (1 << 10) for _ in range(10)]
    board = [[''] * 10 for _ in range(10)]

    # 보드 데이터 설정
    for i in range(n):
        for j in range(m):
            board[i][j] = board_data[i][j]

    dfs_array = [0] * 10
    lines = []
    dfs(lines, dfs_array, 0, m)

    # 결과 계산
    result = dp(lines, 0, 0, n, m)
    return result

if __name__ == "__main__":
    # 입력 받기
    data = input().splitlines()
    test_cases = int(data[0].strip())
    idx = 1
    results = []

    for _ in range(test_cases):
        n, m = map(int, data[idx].split())
        idx += 1
        board_data = [data[idx + i].strip() for i in range(n)]
        idx += n
        results.append(solve(n, m, board_data))

    # 출력 결과
    for result in results:
        print(result)
