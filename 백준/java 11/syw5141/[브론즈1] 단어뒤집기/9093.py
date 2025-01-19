# 테스트 케이스의 개수 입력 받기
t = int(input())

# t번 만큼 반복
for _ in range(t):
    # 문자열을 입력받고 공백(" ")을 기준으로 단어들을 분리
    # 예: "I am happy" -> ["I", "am", "happy"]
    word = input().split(" ")
    
    # 각 단어별로 처리
    for i in range(len(word)):
        # 파이썬의 슬라이싱 [::-1]을 사용해 단어를 뒤집기
        # 예: "happy" -> "yppah"
        word[i] = word[i][::-1]
    
    # 뒤집어진 단어들을 다시 공백으로 이어붙여 출력
    # 예: ["I", "ma", "yppah"] -> "I ma yppah"
    print(" ".join(word))