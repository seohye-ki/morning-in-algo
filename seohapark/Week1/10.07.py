import sys

input = sys.stdin.read
sys.setrecursionlimit(100000)


class Tree:
    def __init__(self, Ans=0, mx=float('-inf'), mn=float('inf')):
        self.Ans = Ans
        self.mx = mx
        self.mn = mn


class SegmentTree:
    def __init__(self, arr):
        self.n = len(arr)
        self.arr = arr
        self.tree = [Tree() for _ in range(4 * self.n)]
        self.init(1, 0, self.n - 1)

    def init(self, node, s, e):
        if s == e:
            self.tree[node] = Tree(Ans=0, mx=self.arr[s], mn=self.arr[s])
            return self.tree[node]

        mid = (s + e) // 2
        left_child = self.init(node * 2, s, mid)
        right_child = self.init(node * 2 + 1, mid + 1, e)

        Ans = max(left_child.Ans, right_child.Ans, right_child.mx - left_child.mn)
        mx = max(left_child.mx, right_child.mx)
        mn = min(left_child.mn, right_child.mn)

        self.tree[node] = Tree(Ans, mx, mn)
        return self.tree[node]

    def query(self, node, s, e, l, r):
        if r < s or e < l:
            return Tree(Ans=-1, mx=float('-inf'), mn=float('inf'))

        if l <= s and e <= r:
            return self.tree[node]

        mid = (s + e) // 2
        left_child = self.query(node * 2, s, mid, l, r)
        right_child = self.query(node * 2 + 1, mid + 1, e, l, r)

        Ans = max(left_child.Ans, right_child.Ans, right_child.mx - left_child.mn)
        mx = max(left_child.mx, right_child.mx)
        mn = min(left_child.mn, right_child.mn)

        return Tree(Ans, mx, mn)

    def change(self, node, s, e, idx, val):
        if idx < s or e < idx:
            return

        if s == e:
            self.tree[node].Ans = 0
            self.tree[node].mx = self.tree[node].mn = val
            return

        mid = (s + e) // 2
        self.change(node * 2, s, mid, idx, val)
        self.change(node * 2 + 1, mid + 1, e, idx, val)

        left_child = self.tree[node * 2]
        right_child = self.tree[node * 2 + 1]

        self.tree[node].Ans = max(left_child.Ans, right_child.Ans, right_child.mx - left_child.mn)
        self.tree[node].mx = max(left_child.mx, right_child.mx)
        self.tree[node].mn = min(left_child.mn, right_child.mn)


def main():
    data = input().split()
    idx = 0
    N = int(data[idx])
    idx += 1
    arr = list(map(int, data[idx:idx + N]))
    idx += N

    seg_tree = SegmentTree(arr)

    Q = int(data[idx])
    idx += 1
    output = []
    for _ in range(Q):
        a = int(data[idx])
        b = int(data[idx + 1]) - 1
        c = int(data[idx + 2])
        idx += 3

        if a == 1:
            seg_tree.change(1, 0, N - 1, b, c)
        else:
            res = seg_tree.query(1, 0, N - 1, b, c - 1).Ans
            output.append(res)

    print("\n".join(map(str, output)))


if __name__ == "__main__":
    main()
