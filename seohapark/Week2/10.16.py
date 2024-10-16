n, m = map(int, input().split())
board = [input() for _ in range(n)]
min_result = float('inf')  # 초기값을 무한대로 설정

for i in range(n - 7):
    for j in range(m - 7):
        draw1 = 0  # 시작이 B인 경우
        draw2 = 0  # 시작이 W인 경우
        
        # 8x8 체스보드 부분만 검사
        for a in range(8):
            for b in range(8):
                # 체스판 패턴에 맞춰 현재 위치의 색상 비교
                if (a + b) % 2 == 0:
                    if board[i + a][j + b] != 'B':
                        draw1 += 1
                    if board[i + a][j + b] != 'W':
                        draw2 += 1
                else:
                    if board[i + a][j + b] != 'W':
                        draw1 += 1
                    if board[i + a][j + b] != 'B':
                        draw2 += 1
        
        # draw1과 draw2의 최소값을 구해 min_result와 비교 후 업데이트
        min_result = min(min_result, draw1, draw2)

print(min_result)
