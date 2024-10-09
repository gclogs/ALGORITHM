#include <iostream>
#include <vector>

using namespace std;

class Point {
    private:
        double x, y;
    public:
        Point() : x(0.0), y(0.0) {}
        ~Point() {
            cout << "[객체가 소멸됩니다.]\n";
        }

        double get_x() {
            return x;
        }
        double get_y() {
            return y;
        }
        void set_x(double x) {
            this->x = x;
        }
        void set_y(double y) {
            this->y = y;
        }
        bool checkOverflowNumbers(const vector<int>& nums) {
            for (int num : nums) {
                if (num <= 0 || num > 100) {
                    return false;
                }
            }
            return true;
        }
};

class Rectangle {
    private:
        Point top_left;
        Point top_right;
    public:
        bool isTopLeft() {
            return top_left.get_x() != 0 || top_left.get_y() != 0;
        }
        bool isTopRight() {
            return top_right.get_x() != 0 || top_right.get_y() != 0;
        }
        void fullRectangle() {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    cout << "*";
                }
                cout << endl;
            }
        }
        void roundRectangle(int x, int y) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (i == 0 || i == 4 || j == 0 || j == 4) {
                        cout << "*";
                    } else {
                        cout << " ";
                    }
                }
                cout << endl;
            }
        }
};

int main() {
    Rectangle rect; // 객체 생성

    vector<int> numbers;
    int x1, y1, x2, y2;

    cout << "x1, y1, x2, y2 값을 입력하세요 (공백으로 구분): ";
    cin >> x1 >> y1 >> x2 >> y2;

    numbers.push_back(x1);
    numbers.push_back(y1);
    numbers.push_back(x2);
    numbers.push_back(y2);

    try {
        // 예외 발생: 범위를 벗어난 인덱스 접근
        for (int i = 0; i <= numbers.size(); i++) {
            cout << "numbers[" << i << "] = " << numbers.at(i) << endl;
        }
    } catch (const out_of_range& e) {
        cout << "예외 발생: " << e.what() << " (out of bound)" << endl;
    }

    if (checkOverflowNumbers(numbers)) {
        int menu;
        while (true) {
            cout << "메뉴: 1. 전체 사각형 2. 둘레 사각형 0. 종료\n";
            cin >> menu;

            switch (menu) {
                case 0:
                    return 0;
                case 1:
                    rect.fullRectangle();
                    break;
                case 2:
                    rect.roundRectangle();
                    break;
                case 3:
                    rect.
                default:
                    cout << "잘못된 선택입니다.\n";
                    break;
            }
        }   
    }

    return 0;
}
