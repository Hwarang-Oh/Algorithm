/**
 * IMP : 2025-03-07
 * IMP : https://www.acmicpc.net/problem/30404
 * TYPE : Reverse 탐색의 Greedy
 */
#include <bits/stdc++.h>
using namespace std;
int N, K;
string line;
int main()
{
  cin >> N >> K;
  cin.ignore();
  getline(cin, line);

  int num;
  vector<int> numberList;
  istringstream iss(line);
  while (iss >> num)
  {
    numberList.push_back(num);
  }

  int count = 1;
  int currentClap = numberList[N - 1];
  for (int i = N - 1; i >= 0; i--)
  {
    num = numberList[i];
    if (num >= currentClap - K)
      continue;
    currentClap = num;
    count++;
  }

  cout << count << endl;

  return 0;
}
