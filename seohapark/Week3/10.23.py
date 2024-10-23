MOD = 10 ** 9 + 7


# 거듭제곱 함수 (mod 연산 포함)
def pow_mod(a, b, MMM):
    ret = 1
    while b:
        if b & 1:
            ret = (ret * a) % MMM
        a = (a * a) % MMM
        b >>= 1
    return ret


# GCD (최대공약수) 함수
def gcd(a, b):
    return b if a % b == 0 else gcd(b, a % b)


# LCM (최소공배수) 함수
def lcm(a, b):
    if a == 0 or b == 0:
        return a + b
    return a // gcd(a, b) * b


# INV (모듈러 역원) 함수
def inv(a, m):
    m0, y, x = m, 0, 1
    if m == 1:
        return 0
    while a > 1:
        q = a // m
        t = m
        m = a % m
        a = t
        t = y
        y = x - q * y
        x = t
    if x < 0:
        x += m0
    return x


# 아미노산 배열 초기화 (-1로)
amino = [-1] * 64


# codon을 숫자로 변환하는 함수
def convert_codon(a):
    ret = 0
    for i in range(3):
        if a[i] == 'A':
            ret = (ret << 2) + 0
        elif a[i] == 'C':
            ret = (ret << 2) + 1
        elif a[i] == 'G':
            ret = (ret << 2) + 2
        else:
            ret = (ret << 2) + 3
    return ret


# DNA 서열을 숫자로 변환하는 함수
def convert_dna(dna_str):
    dna = [0] * (len(dna_str) + 1)
    for i in range(len(dna_str)):
        if dna_str[i] == 'A':
            dna[i + 1] = 0
        elif dna_str[i] == 'C':
            dna[i + 1] = 1
        elif dna_str[i] == 'G':
            dna[i + 1] = 2
        else:
            dna[i + 1] = 3
    return dna


# 주어진 DNA 서열에 대해 가능한 변형의 개수를 계산하는 함수
def main():
    dna_str = input().strip()  # DNA 문자열 입력 받기
    dna = convert_dna(dna_str)  # DNA 문자열을 숫자로 변환
    n = len(dna_str)

    m = int(input())  # codon과 아미노산 매핑 개수
    a2i = {}
    for _ in range(m):
        codon, amino_acid = input().split()  # codon과 아미노산 입력 받기
        if amino_acid not in a2i:
            a2i[amino_acid] = len(a2i)  # 새로운 아미노산은 매핑
        amino[convert_codon(codon)] = a2i[amino_acid]  # codon을 숫자로 변환 후 매핑

    D = [0] * (n + 1)
    sumD = [0] * (n + 1)
    D[0] = 1
    sumD[0] = 1

    occur = [[] for _ in range(4)]  # 각 DNA 염기가 등장한 위치
    before = [-1] * 64  # 이전에 각 아미노산이 생성된 위치

    for i in range(1, n + 1):
        current = [-1] * 64  # 현재 위치에서 아미노산이 생성된 위치

        # DNA[i] 기준 아미노산 생성 여부 확인
        for j in range(4):
            if len(occur[j]) >= 2:
                num = amino[20 * j + dna[i]]
                if num != -1 and current[num] < occur[j][-2]:
                    current[num] = occur[j][-2]

        # 두 염기를 고려하여 아미노산 생성 여부 확인
        for j in range(4):
            if len(occur[j]) < 1:
                continue
            for k in range(4):
                if j == k or len(occur[k]) < 1:
                    continue
                num = amino[16 * j + 4 * k + dna[i]]
                if num == -1:
                    continue
                kpos = occur[k][-1]
                jpos_candidates = [x for x in occur[j] if x < kpos]
                if jpos_candidates:
                    jpos = jpos_candidates[-1]
                    if current[num] < jpos:
                        current[num] = jpos

        # 현재 위치에서 가능한 아미노산 생성으로 D 갱신
        for j in range(64):
            if current[j] != -1 and current[j] > before[j]:
                if before[j] != -1:
                    D[i] = (D[i] + sumD[current[j] - 1] - sumD[before[j] - 1]) % MOD
                else:
                    D[i] = (D[i] + sumD[current[j] - 1]) % MOD
                before[j] = current[j]
                if D[i] < 0:
                    D[i] += MOD

        occur[dna[i]].append(i)  # 어디서 나왓는지?
        sumD[i] = (sumD[i - 1] + D[i]) % MOD  # 항목 누적기록

    ans = (sumD[n] - 1) % MOD  # 가능한 변형의 개수 (시작하는 상태 제외)
    if ans < 0:
        ans += MOD

    print(ans)


if __name__ == "__main__":
    main()
