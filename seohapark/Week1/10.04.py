class UnionFind:
    def __init__(self, sz):#시작
        self.parent = list(range(sz))
        self.rank = [1] * sz
        self.cnt = [1] * sz

    def find(self, u):
        if u == self.parent[u]:
            return u
        self.parent[u] = self.find(self.parent[u])
        return self.parent[u]

    def merge(self, u, v):
        u = self.find(u)
        v = self.find(v)
        if u == v:
            return
        if self.rank[u] > self.rank[v]:
            u, v = v, u
        self.parent[u] = v
        self.cnt[v] += self.cnt[u]
        if self.rank[u] == self.rank[v]:
            self.rank[v] += 1

    def get_cnt(self, u):
        u = self.find(u)
        return self.cnt[u]

def main():
    n = int(input())
    ball_idx = [[] for _ in range(n + 1)]
    top_pairs = [0] * (n + 1)
    solved = [False] * (n + 1)

    for i in range(1, n + 1):
        a, b = map(int, input().split())
        ball_idx[a].append(i * 2)
        ball_idx[b].append(i * 2 + 1)

    uf = UnionFind(n + 1)

    for i in range(1, n + 1):
        uf.merge(ball_idx[i][0] // 2, ball_idx[i][1] // 2)

    for i in range(1, n + 1):
        if ball_idx[i][0] % 2 == 0 and ball_idx[i][1] % 2 == 0:
            root_idx = uf.find(ball_idx[i][0] // 2)
            top_pairs[root_idx] += 1

    for i in range(1, n + 1):
        root_idx = uf.find(ball_idx[i][0] // 2)
        if top_pairs[root_idx] >= 2:
            print(-1)
            return

    ans = 0

    for i in range(1, n + 1):
        root_idx = uf.find(ball_idx[i][0] // 2)
        if solved[root_idx]:
            continue
        solved[root_idx] = True
        x = uf.get_cnt(root_idx)
        if x >= 2:
            ans += x + 1

    print(ans)

if __name__ == "__main__":
    main()