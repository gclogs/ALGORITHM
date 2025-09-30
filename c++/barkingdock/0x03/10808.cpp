#include <bits/stdc++.h>
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  string s;
  cin >> s;

  char alphabet[26] = {0, };

  for(int i = 0; i < s.length(); i++) {
    alphabet[s[i] - 'a']+= 1;
  }

  for(int i = 0; i < 26; i++) {
    cout << alphabet[i] << " ";
  }

  return 0;
}