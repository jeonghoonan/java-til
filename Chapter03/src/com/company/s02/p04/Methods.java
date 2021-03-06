package com.company.s02.p04;

/**
 * 메소드 (Methods)
 * 객체가 하는 동(행위)작을 정의하는 작업을 수행하는 코드의 집합, 나열
 * 코드의 중복을 방지, 유지보수성을 향상, 코드의 가독성을 개선
 */

class Foo { // 메소드를 만들기 전에 클래스 만들어야함
    int value;
}

class Bar {
    // 인스턴스 메소드 (보통 그냥 메소드)
        // Return type (출력의 자료형)
    public int add(int x, int y) { // 입력 파라미터(int x, int y) (메소드 호출)
        return x + y; // 반환값 (return value)
    }
    // 선언(Declaration) - ~한 것이 있다. 실제 구현은X public int add(int x. int y)만 하면 선언.
    // 정의(Definition) - 선언 + 구현(초기화) // public int add(int x, int y) {
                                    //        return x + y; // 반환값 (return value)
    //    }
        // static - 정적 메소드(static method), 클래스 메소드
    // void 리턴 타입은 아무 것도 반환하지 않는다.
    public static void classMethod() {
        System.out.println("클래스메소드 호출");
        // return 이라고 적어도 되지만 안적어도 된다.
    }

    // x, y 뒤집기
    public static void swapPrimitive(int x, int y) {
        // int x, int y 의 사본이 넘어온다
        // 기본형 타입 (Primitive type)인 경우에 해당
        // call by value: 메소드 호출을 할때, 값을 복사해서 넘긴다.
        int temp = x;
        x = y;
        y = temp;
    }

    public static void swapReference(Foo x, Foo y) {
        // Foo 는 class이다. class는 참조형 변수이다.
        int temp = x.value;
        x.value = y.value;
        y.value = temp;
    }
                            // 여러개의 int를 입력 받는다.
                            // 입력 받은 결과는 배열로 주어진다.
                            // 가변 인자 (Variable arguments)
    public static int sumAll(int... params) {
        int sum = 0;
        for (int value: params) {
            sum += value;
        }
        return sum;
    }

    // 메소드 오버로딩 Overloading
    // 함수명은 같고, 입력 인자가 달라야 한다.
    // 입력 인자의 개수도 다를 수 있다.
    public static float sumAll(float... params) {
        float sum = 0;
        for (float value: params) {
            sum += value;
        }
        return sum;
    }
}

class Person {
    static String korWord = "사람";
    boolean isHungry = true; // 인스턴스 멤버 변수

    // 클래스 메소드
    public static void describe() {
        System.out.println(korWord + "입니다.");
        // 클래스 메소드는 클래스 변수를 사용할 수 있다.
        // 단, 객체에 속하는 속성은 사용할 수 없다.
    }

    // 인스턴드 메소드 // 각각이 가지고 있는 속성을 바꿔준다
    public void eat() {
        isHungry = false;
    }
}

public class Methods {
    public static void classMethod() {
        System.out.println("클래스 메소드 호출");
    }

    public void instanceMethod() {
        System.out.println("인스턴스 메소드 호출");
    }


    public static void main(String[] args) {
        Bar.classMethod(); // 클래스메소드 호출
        // Bar.add(1, 2); 이건 콜이 되지 않는다
        Bar bar = new Bar();
        System.out.println(bar.add(1, 2)); // 3 // 메소드 호출이 되면 리턴되는 값으로 바뀐다 // 인서턴스
        // bar.classMethod(); // 호출은 가능하나 권장하지 않다

        Person p1 = new Person(); // person 이라는 클래스로 만든 객체. 객체를 새로 생선한거임. 클래스로부터 객체를 생성가능
        Person p2 = new Person();

        // 인스턴스 메소드는 객체의 속성을 변화시킨다. // 변화시킬수도 변화안시킬수도있다.
        p1.eat();
        System.out.println(p1.isHungry);
        System.out.println(p2.isHungry);

        // 클래스 메소드는 객체의 속성과 상관이 없다.
        Person.describe(); //사람입니다.

        int x = 10;
        int y = 20;
        Bar.swapPrimitive(x, y);
        System.out.println(x + ", " + y); // 10 20

        Foo f1 = new Foo();
        Foo f2 = new Foo();

        f1.value = 10;
        f2.value = 20;
        Bar.swapReference(f1, f2);
        System.out.println(f1.value + ", " + f2.value); // 20 10
        // call by reference 공부하기

        System.out.println(Bar.sumAll(2, 5, 2, 10, 6, -2));
        System.out.println(Bar.sumAll(2.2f, 0.2f));

        Bar.classMethod(); // 동일 클래스에 속한 클래스 메소드 호출
        Methods.classMethod(); // 클래스메소드 호출
        Methods m = new Methods(); // 클래스 메소드 호출
        m.instanceMethod(); // 인스턴스 메소드 호출
    }
}


