#include <bits/stdc++.h>
using namespace std;

void insert(int idx, int num, int arr[], int& len){
  if (idx < 0 || idx > len) {
    cout << "idx error\n";
    return;
  }

  if (len == 10) {
    cout << "array is full\n";
    return;
  }

  for(int i = len; i > idx; i--) {
    arr[i] = arr[i - 1];
  }
  arr[idx] = num;
  len++;
}

void remove(int idx, int arr[], int& len){
  if (idx < 0 || idx >= len) {
    cout << "idx error\n";
    return;
  }

  if (len == 0) {
    cout << "array is empty\n";
    return;
  }

  for(int i = idx; i < len - 1; i++) {
    arr[i] = arr[i + 1];
  }
  len--;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  
  int arr[10] = {1, 2, 3, 4, 5};
  int len = 5; // 배열에서 사용중인 원소의 개수

  cout << "메뉴 \n";
  cout << "1. 삽입 \n";
  cout << "2. 삭제 \n";
  cout << "3. 출력 \n";
  cout << "4. 종료 \n";

  int menu;
  cin >> menu;

  if (menu == 1) {
    cout << "삽입하고 싶은 위치: ";
    int idx;
    cin >> idx;
    cout << "삽입하고 싶은 수: ";
    int num;
    cin >> num;
    insert(idx, num, arr, len);
  }
  
  if (menu == 2) {
    cout << "삭제하고 싶은 위치: ";
    int idx;
    cin >> idx;
    remove(idx, arr, len);
  }

  if (menu == 3) {
    for(int i = 0; i < len; i++) {
      cout << arr[i] << " ";
    }
  }

  if (menu == 4) {
    return 0;
  }
}