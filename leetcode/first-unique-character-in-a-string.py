class Solution:
    def firstUniqChar(self, s: str) -> int:
        char_count = {}
        for char in s:
            char_count[char] = char_count.get(char, 0) + 1
        
        for i, char in enumerate(s):
            if char_count[char] == 1:
                return i
        return -1

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
