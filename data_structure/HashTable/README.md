# 🔑 해시 함수 (Hash Functions)

## 1. Division Hash Function (나머지 연산)

### 기본 원리
```java
hash(key) = key % table_size
```

### 특징
- **장점**:
  - 구현이 매우 간단
  - 계산 속도가 빠름
- **단점**:
  - table_size 선택이 중요 (소수 선호)
  - 특정 패턴의 키에서 충돌 가능성 높음

### 예시
```java
public int hash(String key) {
    return Math.abs(key.hashCode()) % tableSize;
}
```

## 2. Additive Hash Function (더하기 해시)

### 기본 원리
```java
hash = 0;
for each character in key:
    hash += ascii_value(character)
return hash % table_size
```

### 특징
- **장점**:
  - 구현이 간단
  - 문자열에 적합
- **단점**:
  - 순서가 다른 같은 문자들에 대해 동일한 해시값 생성
  - 예: "abc" 와 "cba"가 같은 해시값

### 예시
```java
public int hash(String key) {
    int hash = 0;
    for (char c : key.toCharArray()) {
        hash += c;
    }
    return hash % tableSize;
}
```

## 3. Rotating Hash Function (회전 해시)

### 기본 원리
```java
hash = 0;
for each character in key:
    hash = (hash << 4) ^ (hash >> 28) ^ ascii_value(character)
return hash % table_size
```

### 특징
- **장점**:
  - 비트 연산으로 빠른 처리
  - 더 균일한 분포
- **단점**:
  - 구현이 복잡
  - 하드웨어 의존적

### 예시
```java
public int hash(String key) {
    int hash = 0;
    for (char c : key.toCharArray()) {
        hash = (hash << 4) ^ (hash >> 28) ^ c;
    }
    return Math.abs(hash % tableSize);
}
```

## 4. Universal Hash Function (범용 해시)

### 기본 원리
```
hash(key) = ((ak + b) mod p) mod m
where:
- a, b: 임의의 상수
- p: 큰 소수
- m: 테이블 크기
```

### 특징
- **장점**:
  - 수학적으로 증명된 충돌 확률
  - 키 분포에 독립적
- **단점**:
  - 구현이 복잡
  - 계산 비용이 상대적으로 높음

### 예시
```java
public int hash(int key) {
    int a = 1717; // 임의의 소수
    int b = 31;   // 임의의 상수
    int p = 524287; // 메르센 소수
    return ((a * key + b) % p) % tableSize;
}
```

## 5. Perfect Hash Function (완전 해시)

### 기본 원리
- 모든 키에 대해 고유한 해시값 생성
- 충돌이 전혀 발생하지 않음

### 특징
- **장점**:
  - 충돌이 없어 O(1) 검색 보장
  - 추가 처리 불필요
- **단점**:
  - 특정 키 집합에만 적용 가능
  - 실제 구현이 매우 어려움
  - 새로운 키 추가 시 재구성 필요

### 사용 예
- 정적 데이터 (컴파일러의 키워드 테이블)
- 알려진 유한 키 집합

## 📌 해시 함수 선택 기준

1. **효율성**
   - 계산 속도가 빠를 것
   - 메모리 사용이 적절할 것

2. **균일성**
   - 해시값이 고르게 분포될 것
   - 충돌 확률이 낮을 것

3. **결정성**
   - 같은 입력에 대해 항상 같은 해시값 생성

4. **사용 상황**
   - 데이터의 특성 (문자열, 숫자 등)
   - 데이터의 크기와 분포
   - 성능 요구사항
