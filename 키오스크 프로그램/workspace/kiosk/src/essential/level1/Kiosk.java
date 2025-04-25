package essential.level1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {

    // 속성
    private int input; // 입력받은 숫자
    private String step; // 입력 단계
    private Menu menu;


    // 생성자
    public Kiosk(Menu menu) {
        this.menu = menu;
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

    public void start() {

        // Scanner 선언
        Scanner scanner = new Scanner(System.in);


        // 반복문 시작
        while (true) {
            System.out.print("메뉴의 번호를 입력해주세요 1)버거, 2)음료, 3) 사이드메뉴 0) 종료 : ");

            int firstChoice = 0;
            int secondChoice = 0;
            int thirdChoice = 0;

            try {
                firstChoice = scanner.nextInt();

            } catch (Exception e) {
                System.out.println("오류: 옳바른 입력 값이 아닙니다. 다시 입력해주세요!" + e);
                scanner.nextLine();
                continue;
            }

            if (firstChoice > 3 || firstChoice < 0) {
                System.out.println("입력이 잘못되었습니다.");
                scanner.nextLine();
                continue;
            }

            if (firstChoice == 0) {
                System.out.println("종료를 선택하셨습니다.");
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (firstChoice) {
                case 1:
                    System.out.println("버거 메뉴를 선택하셨습니다.");
                    menu.printMenu();
                    System.out.print("원하시는 메뉴의 번호를 선택해주세요.");

                    try {
                        secondChoice = scanner.nextInt();

                    } catch (Exception e) {
                        System.out.println("오류: 옳바른 입력 값이 아닙니다. 다시 입력해주세요!" + e);
                        scanner.nextLine();
                        continue;
                    }

                    if (secondChoice > menu.getMenuList().size() || secondChoice < 0) {
                        System.out.println("입력이 잘못되었습니다.");
                        scanner.nextLine();
                        continue;
                    }

                    if (secondChoice == 0) {
                        System.out.println("돌아가기를 선택하셨습니다.");
                        System.out.println("처음으로 돌아갑니다.");
                        scanner.nextLine();
                        break;
                    }

                    if (secondChoice <= menu.getMenuList().size()) {
                        MenuItem selectedItem = menu.findMenu(secondChoice);

                        if (selectedItem != null) {

                            System.out.println("선택한 메뉴: " + selectedItem.getMenuName() + " | " + selectedItem.getPrice() + " | "
                                    + selectedItem.getIntroduce());
                            break;
                        } else {
                            System.out.println("없는 메뉴 입니다.");
                            scanner.nextLine();
                            continue;
                        }

                    } else {
                        System.out.println("없는 메뉴입니다.");
                        scanner.nextLine();
                    }

                    break;
                case 2:
                    System.out.println("음료 메뉴를 선택하셨습니다.");

                    break;
                case 3:
                    System.out.println("사이드 메뉴를 선택하셨습니다.");

                    break;
                default:
                    System.out.println("잘못된 입력입니다. 처음으로 돌아갑니다.");
                    scanner.nextLine();
                    break;
            }

        }
    }
}
