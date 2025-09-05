#include <stdio.h>      // printf, scanf 등 입출력
#include <stdlib.h>     // malloc, free, abs 등
#include <string.h>     // strlen, strcpy 등 문자열 함수
#include <math.h>       // sqrt, pow 등 수학 함수
#include <stdbool.h>    // bool, true, false (C99 이상)

int func1(int n) {
    int sum = 0;
    for(int i = 1; i <= n; i++) {
        if(i % 3 == 0 || i % 5 == 0) {
            sum += i;
        }
    }
    return sum;
}

void test1() {
    printf("test1\n");
    int n[3] = {16, 34567, 27639};
    int ans[3] = {60, 278812814, 178254968};
    for(int i = 0; i < 3; i++) {
        int res = func1(n[i]);
        printf("TC #%d\n", i);
        printf("expected %d, got %d\n", ans[i], res);
        if(ans[i] == res) printf(": pass\n");
        else printf(": fail\n");
    }
    printf("*************************\n\n");
}

/**
    주어진 길이 N의 int 배열 arr에서 합이 100인 
    서로 다른 위치의 두 원소가 존재하면 1을, 
    존재하지 않으면 0을 반환하는 함수 func2(int arr[], int N)을 작성하라.
    arr의 각 수는 0 이상 100 이하이고 N은 1000 이하이다.
*/

int func2(int arr[], int N) {
    for(int i = 0; i < N; i++) {
        for(int j = i + 1; j < N; j++) {
            if(arr[i] + arr[j] == 100) return 1;
        }
    }
    return 0;
}

int func2_optimized(int arr[], int N) {
    bool occur[101] = {false};  // 0~100 범위 체크 배열
    
    for(int i = 0; i < N; i++) {
        int complement = 100 - arr[i];  // 보완 값 계산
        if(complement >= 0 && complement <= 100 && occur[complement]) {
            return 1;  // 이미 등장한 보완 값 발견
        }
        occur[arr[i]] = true;  // 현재 값 등장 표시
    }
    return 0;
}


void test2(){
    printf("****** func2 test ******\n");
    int arr[3][4] = {{1,52,48}, {50,42}, {4,13,63,87}};
    int n[3] = {3, 2, 4};
    int ans[3] = {1, 0, 1};
    for(int i = 0; i < 3; i++){
      int result = func2_optimized(arr[i], n[i]);
      printf("TC #%d\n", i);
      printf("expected : %d result : %d\n", ans[i], result);
      if(ans[i] == result) printf(" ... Correct!\n");
      else printf(" ... Wrong!\n");
    }
    printf("*************************\n\n");
  }

/*
  N이 제곱수이면 1을 반환하고 제곱수가 아니면 
  0을 반환하는 함수 func3(int N)을 작성하라. 
  N은 10억 이하의 자연수이다.
*/
int func3(int N) {
    for(int i = 0; i * i <= N; i++) {
        // printf("i : %d = %d\n", i, i * i); 실제 시뮬레이션 확인
        if(i * i == N) return 1;
    }
    return 0;
}

void test3() {
    printf("test3/n");
    int n[3] = {9, 693953651, 756580036};
    int ans[3] = {1, 0, 1};
    for(int i = 0; i < 3; i++) {
        int result = func3(n[i]);
        printf("TC #%d\n", i);
        printf("expected : %d result : %d\n", ans[i], result);
        if(ans[i] == result) printf(" ... Correct!\n"); 
        else printf(" ... Wrong!\n");
    }
    printf("*************************\n\n");
}

/*
    N이하의 수 중에서 가장 큰 2의 거듭제곱수를 반환하는 함수 
    func4(int N)을 작성하라. 
    N은 10억 이하의 자연수이다.
*/
int func4(int N) {
    int res = 1;
    for(int i = 1; i <= N; i++) {
        res *= 2;
        if(res > N) return res / 2;
    }
    return res;
}

int func4_optimized(int N) {
    return 1 << (int)(log2(N));  // 수학 라이브러리 활용
}

void test4() {
    printf("test4");
    int n[3] = {5, 97615282, 1024};
    int ans[3] = {4, 67108864, 1024};
    for(int i = 0; i < 3; i++) {
        int res = func4_optimized(n[i]);
        printf("TC #%d\n", i);
        printf("expected : %d result : %d\n", ans[i], res);
        if(ans[i] == res) printf(" ... Correct!\n"); 
        else printf(" ... Wrong!\n");
    }
}

int main() {
    test4();
    return 0;
}