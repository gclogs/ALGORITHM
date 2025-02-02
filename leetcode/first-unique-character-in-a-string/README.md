# 🔍 [First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/)

---

## 📝 문제 해결 방법 비교 분석

세 가지 다른 접근 방식으로 문제를 해결했습니다:

---

### 🔨 1. ASCII 값을 이용한 방식
```python
def firstUniqChar(self, s: str) -> int:
    res = n = len(s)
    for ch in range(ord('a'), ord('z') + 1):
        index = s.find(chr(ch))
        if index != -1 and s.rfind(chr(ch)) == index:
            res = min(res, index)
    return -1 if res == n else res
```

#### 🛠 사용된 자료구조와 개념:
- **문자열(String)**: 기본 입력 데이터 구조
- **ASCII 값**: 문자를 숫자로 변환하여 처리
- **투 포인터 개념**: find()와 rfind()로 양쪽에서 검색

#### ⏱ 시간복잡도: O(n)
- 알파벳 26개에 대해 각각 O(n) 검색
- 26 * O(n) = O(n)

#### 💾 공간복잡도: O(1)
- 추가 메모리 사용 없음

---

### 🎯 2. Set을 이용한 방식
```python
def firstUniqChar(self, s: str) -> int:
    result = len(s)
    s_set = set(s)
    for char in s_set:
        i = s.index(char)
        if i == s.rindex(char):
            result = min(result, i)
    return result if result != len(s) else -1
```

#### 🛠 사용된 자료구조와 개념:
- **Set(해시 테이블)**: 중복 제거를 위한 자료구조
- **문자열(String)**: 기본 입력 데이터 구조
- **투 포인터 개념**: index()와 rindex()로 양쪽에서 검색

#### ⏱ 시간복잡도: O(n)
- set 생성: O(n)
- 각 고유 문자에 대해 O(n) 검색

#### 💾 공간복잡도: O(k)
- k는 고유 문자의 수 (최대 26)

---

### 🎲 3. 딕셔너리를 이용한 방식
```python
def firstUniqChar(self, s: str) -> int:
    char_count = {}
    for char in s:
        char_count[char] = char_count.get(char, 0) + 1
    
    for i, char in enumerate(s):
        if char_count[char] == 1:
            return i
    return -1
```

#### 🛠 사용된 자료구조와 개념:
- **딕셔너리(해시 테이블)**: 문자 출현 횟수 저장
- **문자열(String)**: 기본 입력 데이터 구조
- **카운터 개념**: 각 문자의 등장 횟수 계산

#### ⏱ 시간복잡도: O(n)
- 첫 번째 순회: O(n)
- 두 번째 순회: O(n)
- 총 2 * O(n) = O(n)

#### 💾 공간복잡도: O(1)
- 최대 26개의 알파벳만 저장

---

## 🔬 코드 상세 분석

### 🔨 1. ASCII 값을 이용한 방식 (코드 분해)

```python
def firstUniqChar(self, s: str) -> int:
    res = n = len(s)                         # 1. 문자열 길이를 결과값과 길이 변수에 저장
    for ch in range(ord('a'), ord('z') + 1): # 2. a부터 z까지 ASCII 값으로 순회
        index = s.find(chr(ch))              # 3. 현재 문자의 첫 번째 위치 찾기
        if index != -1 and s.rfind(chr(ch)) == index:  # 4. 유일한 문자인지 확인
            res = min(res, index)            # 5. 가장 앞에 있는 유일 문자의 위치 저장
    return -1 if res == n else res          # 6. 결과 반환
```

#### 📊 코드 동작 예시 (s = "leetcode")
1. `res = n = 8` (문자열 길이)
2. 'a'부터 'z'까지 순회:
   - 'l' 검사: find('l') = 0, rfind('l') = 0 → 유일 문자! res = 0
   - 'e' 검사: find('e') = 1, rfind('e') = 7 → 중복 문자
   - 't' 검사: find('t') = 3, rfind('t') = 3 → 유일 문자이지만 res(0)보다 큼
   ...

---

### 🎯 2. Set을 이용한 방식 (코드 분해)

```python
def firstUniqChar(self, s: str) -> int:
    result = len(s)                    # 1. 문자열 길이를 초기값으로 설정
    s_set = set(s)                     # 2. 중복 제거된 문자 집합 생성
    for char in s_set:                 # 3. 고유 문자만 순회
        i = s.index(char)              # 4. 문자의 첫 번째 위치 찾기
        if i == s.rindex(char):        # 5. 유일한 문자인지 확인
            result = min(result, i)     # 6. 가장 앞에 있는 유일 문자의 위치 저장
    return result if result != len(s) else -1  # 7. 결과 반환
```

#### 📊 코드 동작 예시 (s = "leetcode")
1. `result = 8` (문자열 길이)
2. `s_set = {'l', 'e', 't', 'c', 'o', 'd'}` (중복 'e' 제거)
3. 각 고유 문자 검사:
   - 'l': index('l') = 0, rindex('l') = 0 → 유일 문자! result = 0
   - 'e': index('e') = 1, rindex('e') = 7 → 중복 문자
   - 't': index('t') = 3, rindex('t') = 3 → 유일 문자이지만 result(0)보다 큼
   ...

---

### 🎲 3. 딕셔너리를 이용한 방식 (코드 분해)

```python
def firstUniqChar(self, s: str) -> int:
    char_count = {}                    # 1. 빈 딕셔너리 생성
    for char in s:                     # 2. 첫 번째 순회: 문자 개수 세기
        char_count[char] = char_count.get(char, 0) + 1
    
    for i, char in enumerate(s):       # 3. 두 번째 순회: 첫 번째 유일 문자 찾기
        if char_count[char] == 1:      # 4. 개수가 1인 문자 확인
            return i                    # 5. 찾으면 바로 인덱스 반환
    return -1                          # 6. 못 찾으면 -1 반환
```

#### 📊 코드 동작 예시 (s = "leetcode")
1. 첫 번째 순회 후 딕셔너리 상태:
   ```python
   char_count = {
       'l': 1, 'e': 2, 't': 1, 
       'c': 1, 'o': 1, 'd': 1
   }
   ```
2. 두 번째 순회:
   - 'l': count = 1 → 유일 문자 발견! 인덱스 0 반환
   - 이후 문자는 검사하지 않음

---

## 🔄 각 방식의 특징적인 차이점

### 1️⃣ 순회 방식
- **ASCII**: 알파벳 26개에 대해 문자열 전체 검색
- **Set**: 중복 제거된 문자에 대해 문자열 전체 검색
- **딕셔너리**: 문자열을 단 두 번만 순회

### 2️⃣ 메모리 사용
- **ASCII**: 추가 메모리 거의 없음
- **Set**: 중복 제거된 문자 저장
- **딕셔너리**: 문자별 카운트 저장

### 3️⃣ 조기 종료
- **ASCII**: 모든 알파벳 검사 필요
- **Set**: 모든 고유 문자 검사 필요
- **딕셔너리**: 첫 유일 문자 발견 시 즉시 종료

---

## 📌 결론

### 🏃 성능 비교
1. **시간 효율성**:
   - 딕셔너리 방식이 가장 효율적 (단 두 번의 순회)
   - ASCII 방식은 일정한 성능 (26번의 전체 순회)
   - Set 방식은 중복이 많은 경우 효율적

2. **공간 효율성**:
   - ASCII 방식이 가장 효율적 (추가 공간 불필요)
   - 딕셔너리와 Set 방식은 추가 공간 필요

### 📖 코드 가독성
1. 딕셔너리 방식: 가장 직관적이고 이해하기 쉬움
2. Set 방식: 중간 정도의 복잡성
3. ASCII 방식: 가장 기술적이고 복잡함

### 💡 권장 사용 상황
- **메모리 제약이 심한 경우**: ASCII 방식
- **일반적인 상황**: 딕셔너리 방식
- **중복이 많은 데이터**: Set 방식
