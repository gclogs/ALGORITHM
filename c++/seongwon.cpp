#include <iostream>
#include <vector>
using namespace std;

class Point {
private:
    double x, y;
public:
    Point() : x(0.0), y(0.0) {}
    Point(double x, double y) : x(x), y(y) {}
    
    ~Point() {
        cout << "Point 객체가 소멸됩니다.\n";  // 필요 없으면 주석 처리
    }

    double get_x() const {
        return x;
    }
    double get_y() const {
        return y;
    }
    void set_x(double x) {
        this->x = x;
    }
    void set_y(double y) {
        this->y = y;
    }

    bool isValid() const {
        return x >= 0 && x <= 100 && y >= 0 && y <= 100;
    }
};

class Rectangle {
private:
    Point top_left;
    Point bottom_right;

public:
    Rectangle(Point tl, Point br) : top_left(tl), bottom_right(br) {}

    bool isValidRectangle() {
        return top_left.isValid() && bottom_right.isValid();
    }

    void fullRectangle() const {
        int width = bottom_right.get_x() - top_left.get_x();
        int height = bottom_right.get_y() - top_left.get_y();
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cout << "*";
            }
            cout << endl;
        }
    }

    void outlineRectangle() const {
        int width = bottom_right.get_x() - top_left.get_x();
        int height = bottom_right.get_y() - top_left.get_y();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    cout << "*";
                } else {
                    cout << " ";
                }
            }
            cout << endl;
        }
    }

    void drawCorners() const {
        int width = bottom_right.get_x() - top_left.get_x();
        int height = bottom_right.get_y() - top_left.get_y();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i == 0 && j == 0) || (i == height - 1 && j == width - 1)) {
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
    double x1, y1, x2, y2;
    cout << "x1, y1, x2, y2 값을 입력하세요 (공백으로 구분): ";
    cin >> x1 >> y1 >> x2 >> y2;

    Point top_left(x1, y1);
    Point bottom_right(x2, y2);

    if (!top_left.isValid() || !bottom_right.isValid()) {
        cout << "out of bound" << endl;
        return 0;
    }

    Rectangle rect(top_left, bottom_right);

    int menu;
    while (true) {
        cout << "메뉴: 1. 전체 사각형 2. 둘레 사각형 3. 모서리 점 그리기 0. 종료\n";
        cin >> menu;

        switch (menu) {
        case 0:
            return 0;
        case 1:
            rect.fullRectangle();
            break;
        case 2:
            rect.outlineRectangle();
            break;
        case 3:
            rect.drawCorners();
            break;
        default:
            cout << "잘못된 선택입니다.\n";
            break;
        }
    }

    return 0;
}
