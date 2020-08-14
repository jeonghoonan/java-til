package s03;

/**
 * 열거형 (Enumeration)
 * enum 키워드로 표현
 * 내부적인 구현은 enum -> java.lang.Enum 클래스를 상속
 * enum 은 다른 클래스를 상속하지 못함 (윗줄을 상속하고 있기 때문에)
 *
 * 열거형은 다른 클래스를 상속하지 못하지만, 인터페이스 구현은 가능(상속과 별개로 가능함)
 * 열거형 타입에는 열거형 상수와 mull 값 할당 가능
 */
enum Job { // 각 상수는 0부터 숫자를 가지지만, 심블로만 사용하고 숫자는 사용하지 않음
    STUDENT, MARKETING, DEVELOPER, CEO, CHIEF_EXECUTIONAL_OFFICER; // 열거형 상수 Enumeration Constant
}

class Foo {
    enum Symbol {
        ONE, TWO, THREE;
    }
}

// 열거형 내부에서 메소드 구현
enum Symbol {
    ONE, TWO, THREE, FOUR;

    public Symbol nextSymbol() {
        if(this.equals(ONE)) {
            return TWO;
        } else if (this.equals(TWO)) {
            return THREE;
        } else if (this.equals(THREE)) {
            return FOUR;
        } else {
            return ONE;
        }
    }
}

// 열거형 생성자를 이용한 ennum 상수 초기화
enum Family {
    FATHER("아버지"), MOTHER("어머니"), SON("아들"), DAUGHTER("딸"); // 열거형 상수(객체) // new  가 안쓰였지, 객체이다
    private String koreanWord; // 멤버 변수(객체에 속하는 변수)

    private Family(String koreanWord) {
        this.koreanWord = koreanWord;
    }

    public String getKoreanWord() {
        return koreanWord;
    }

    public void setKoreanWord(String koreanWord) {
        this.koreanWord = koreanWord;
    }
}

public class Enumeration {
    public static void main(String[] args) {
        Job job = Job.STUDENT; // 클래스 변수와 유사하게 사용

        if (job == Job.CHIEF_EXECUTIONAL_OFFICER) {
            System.out.println("사장님 안녕하세요");
        }

        char c = 'A';
        switch (c) {
            case 'A':
                break;
            case 'B':
                break;
            default:
        }

        switch (job) { // switch ~ case 문에는 열거형 자료형을 생략
            case STUDENT:
                System.out.println("you will be a great one");
                break;
            case MARKETING:
                System.out.println("you sells");
                break;
            case DEVELOPER:
                System.out.println("you make things");
                break;
            case CHIEF_EXECUTIONAL_OFFICER:
                System.out.println("you choose");
                break;
            default:
                System.out.println("who are you?");
        }

        System.out.println(Foo.Symbol.ONE); // ONE // 심볼그자체로 쓰인다

        // 열거형 메소드
        Symbol sym = Symbol.ONE; // 얘는 객체이다 // 열거형 상수는 객체이다. Class Variable 와 다르다
        Symbol nextSym = sym.nextSymbol(); // 객체는 메소드를 실행할수있다. nextSymbol을 실행가능
        System.out.println(nextSym); // TWO
        nextSym = nextSym.nextSymbol();
        System.out.println(nextSym); // THREE

        // 열거형 생성자와 멤버변수 활용
        Family fam = Family.SON;
        System.out.println(fam.getKoreanWord()); // 아들
        fam.setKoreanWord("버린 자식");
        System.out.println(fam.getKoreanWord()); // 버린 자식
        System.out.println(Family.SON.getKoreanWord());
    }
}