class Solution:
    def firstUniqChar(self, s: str) -> int:
        # 1. 각 문자의 등장 횟수를 딕셔너리에 저장
        char_count = {}
        for char in s:
            char_count[char] = char_count.get(char, 0) + 1
        
        # 2. 문자열을 순회하면서 등장 횟수가 1인 첫 번째 문자의 인덱스 찾기
        for i, char in enumerate(s):
            if char_count[char] == 1:
                return i
        return -1  # 중복되지 않은 문자가 없는 경우

# 테스트
if __name__ == "__main__":
    solution = Solution()
    test_cases = [
        "leetcode",      # 예상 출력: 0 ('l'은 첫 번째 중복되지 않은 문자)
        "loveleetcode",  # 예상 출력: 2 ('v'는 첫 번째 중복되지 않은 문자)
        "aabb"          # 예상 출력: -1 (중복되지 않은 문자가 없음)
    ]
    
    for test in test_cases:
        result = solution.firstUniqChar(test)
        print(f"문자열: {test}")
        print(f"첫 번째 중복되지 않은 문자의 인덱스: {result}")
        print("---")