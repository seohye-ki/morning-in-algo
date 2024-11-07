def main():
    n = int(input())
    A = []

    for i in range(n):
        value = int(input())
        A.append((value, i))  # 메모

    A.sort()  # 정렬

    P = [0] * n
    for i in range(n):
        P[A[i][1]] = i  # 지금 인덱스 메모

    print(" ".join(map(str, P)))  # 결과 출력
