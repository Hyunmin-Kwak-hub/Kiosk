package essential.level1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {

    // 속성
    private int input; // 입력받은 숫자
    private String step; // 입력 단계

    // 생산자
    public Kiosk() {

    }

    // 기능
    // 게터
    public void setInput(int input) {
        this.input = input;
    }

    public void setStep(String step) {
        this.step = step;
    }
    // 세터
    public int getInput() {
        return input;
    }
    public String getStep() {
        return step;
    }

    public static void start() {

        // Scanner 선언
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        // 반복문 시작
        while (true) {
            System.out.println("메뉴의 번호를 입력해주세요 1)버거, 2)음료, 3) 사이드메뉴 0) 종료 : ");

            int firstStep = 0;

            try {
                firstStep = scanner.nextInt();

            } catch (Exception e) {
                System.out.println("오류: 옳바른 입력 값이 아닙니다. 다시 입력해주세요!" + e);
                scanner.nextLine();
                continue;
            }

            if (firstStep > 3 || firstStep < 0) {
                System.out.println("입력이 잘못되었습니다.");
                continue;
            }

            if (firstStep == 0) {
                System.out.println("종료를 선택하셨습니다.");
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            menu.selectMenu(firstStep);

        }
    }
}
