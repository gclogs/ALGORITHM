def demonstrate_set_collision():
    # Python의 Set은 오픈 어드레싱 방식 사용
    numbers = set()
    
    # 의도적으로 해시 충돌이 발생할 수 있는 수 추가
    # Python에서 256과 -256은 같은 해시값을 가질 수 있음
    numbers.add(256)
    numbers.add(-256)
    
    # 충돌이 발생해도 모든 요소가 정확히 저장됨
    print("Set contents:", numbers)
    print("Is 256 in set?", 256 in numbers)    # True
    print("Is -256 in set?", -256 in numbers)  # True
    
    # 해시값 확인
    print("Hash of 256:", hash(256))
    print("Hash of -256:", hash(-256))

if __name__ == "__main__":
    demonstrate_set_collision()
