class HashTable:
    def __init__(self, length=5):
        self.max_len = length
        self.table = [[] for _ in range(length)]
        
    def _hash(self, key):
        res = sum([ord(c) for c in key])
        return res % self.max_len
    
    def set(self, key, value):
        h = self._hash(key)
        self.table[h].append((key, value))

    def get(self, key):
        h = self._hash(key)
        v = self.table[h]

        if not v:
            return None
        
        for val in v:
            if val[0] == key:
                return val[1]
        
        return None

if __name__ == "__main__":
    capital = HashTable()
    country = ["Korea", "America", "China", "England", "Türkiye"]
    city = ["Seoul", "Washington", "Beijing", "London", "Ankara"]
    for co, ci in zip(country, city):
        capital.set(co, ci)

    print("해시 테이블의 상태")
    print("===============")
    for i, v in enumerate(capital.table):
        print(i, v)
    print()
    print("해시 테이블의 검색 결과")
    print("====================")
    print(f"Captial of America = {capital.get('America')}")
    print(f"Captial of Korea = {capital.get('Korea')}")
    print(f"Captial of England = {capital.get('England')}")
    print(f"Captial of China = {capital.get('China')}")
    print(f"Captial of Japan = {capital.get('Japan')}")
    print(f"Captial of Türkiye = {capital.get('Türkiye')}")