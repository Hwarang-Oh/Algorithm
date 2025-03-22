class SegTree {
  constructor(size) {
    this.size = size;
    this.tree = Array.from({ length: calTreeSize(size) }, () => [Infinity, -Infinity]);
    // * new Array(calTreeSize(size)).fill(null).map(() => [Infinity, -Infinity]);
  }

  add(idx, value) {
    this._add(1, 1, this.size, idx, value);
  }

  _add(node, start, end, idx, value) {
    if (start === end) {
      this.tree[node] = [value, value];
    } else {
      let mid = Math.floor((start + end) / 2);
      let lChild = 2 * node;
      let rChild = 2 * node + 1;

      if (idx <= mid) this._add(lChild, start, mid, idx, value);
      else this._add(rChild, mid + 1, end, idx, value);

      this.tree[node][0] = Math.min(this.tree[lChild][0], this.tree[rChild][0]);
      this.tree[node][1] = Math.max(this.tree[lChild][1], this.tree[rChild][1]);
    }
  }

  query(l, r) {
    return [this._queryMin(1, 1, this.size, l, r), this._queryMax(1, 1, this.size, l, r)];
  }

  _queryMin(node, start, end, l, r) {
    if (r < start || end < l) return Infinity;
    if (l <= start && end <= r) return this.tree[node][0];
    let mid = Math.floor((start + end) / 2);
    let lMin = this._queryMin(2 * node, start, mid, l, r);
    let rMin = this._queryMin(2 * node + 1, mid + 1, end, l, r);
    return Math.min(lMin, rMin);
  }

  _queryMax(node, start, end, l, r) {
    if (r < start || end < l) return -Infinity;
    if (l <= start && end <= r) return this.tree[node][1];
    let mid = Math.floor((start + end) / 2);
    let lMax = this._queryMax(2 * node, start, mid, l, r);
    let rMax = this._queryMax(2 * node + 1, mid + 1, end, l, r);
    return Math.max(lMax, rMax);
  }
}

function calTreeSize(size) {
  let h = Math.ceil(Math.log2(size));
  return 2 ** (h + 1) - 1;
}

// Main
const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

let [N, M] = input[0].split(' ').map(Number);
const segTree = new SegTree(N);
for (let i = 1; i <= N; i++) segTree.add(i, parseInt(input[i]));

// 연산
const results = [];
for (let q = 1; q <= M; q++) {
  const [l, r] = input[N + q].split(' ').map(Number);
  const [minVal, maxVal] = segTree.query(l, r);
  results.push(minVal + ' ' + maxVal);
}

console.log(results.join('\n'));
