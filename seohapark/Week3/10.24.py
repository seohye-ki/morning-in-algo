# 필요한 모듈 임포트
import math

# 전역 변수 선언
cnt = [0] * 10

# num보다 작은 수 중 1의 자리 9인 것 중 가장 큰 수
def last_is_nine(num):
    while True:
        if num % 10 == 9:
            break
        num -= 1
    return num

# A < B
# A는 B보다 작은 수 중 10의 거듭제곱 꼴인 가장 큰 수
# ex) B=9876 => A=1000
# digit : 자릿수 (1의 자리, 10의 자리,...)
def ato_b(A, B, digit):
    # 한 자리수만 남았을 경우
    if B < 10:
        for i in range(A, B + 1):
            cnt[i] += digit
        return

    tmp = last_is_nine(B)  # B보다 작은 값 중 일의 자리가 9인 가장 큰 수

    # tmp+1부터 B까지 애들 다 구하기
    for i in range(tmp + 1, B + 1):
        s = str(i)
        for ch in s:
            idx = int(ch)
            cnt[idx] += digit

    # A부터 tmp까지 구하기
    for i in range(10):
        cnt[i] += (tmp // 10 - A // 10 + 1) * digit

    # 나머지 부분 계산
    ato_b(A // 10, tmp // 10, digit * 10)

# 메인 함수
def main():
    # 사용자 입력 받기
    n = int(input())

    # n이 10 이하인 경우 따로 체크 (무한 루프 방지)
    if n < 10:
        for i in range(1, n + 1):
            cnt[i] += 1
        print(*cnt)
        return

    # n의 길이
    length = len(str(n))
    # A는 B보다 작은 수 중 10의 거듭제곱 꼴인 가장 큰 수
    A = int(math.pow(10, length - 1))

    # n=101 같은 경우, 99가 n보다 작은 수 중 1의 자리가 9인 것 중 가장 큰 수
    # 이런 경우는 따로 체크
    if A > last_is_nine(n):
        # 100...00 ~ n까지 계산
        for i in range(last_is_nine(n) + 1, n + 1):
            s = str(i)
            for ch in s:
                idx = int(ch)
                cnt[idx] += 1

        # 나머지 부분 계산
        A //= 10
        ato_b(A, last_is_nine(n), 1)
        while True:
            if A == 1:
                break
            ato_b(A // 10, A - 1, 1)
            A //= 10
    # 위의 경우가 아닌 경우 그냥 계산
    else:
        ato_b(A, n, 1)
        while True:
            if A == 1:
                break
            ato_b(A // 10, A - 1, 1)
            A //= 10

    # 결과 출력
    print(*cnt)

# 메인 함수 실행
if __name__ == "__main__":
    main()
