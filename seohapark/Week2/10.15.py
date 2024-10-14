import sys

# 입력 받기
A_size = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))

# A를 정렬하고 인덱스를 매핑
sorted_A = sorted((value, index) for index, value in enumerate(A))

# 순위 정보를 저장할 리스트
P = [0] * A_size

# 정렬된 리스트를 기반으로 순위를 매김
for rank, (value, index) in enumerate(sorted_A):
    P[index] = rank

# 결과 출력
sys.stdout.write(' '.join(map(str, P)) + '\n')
