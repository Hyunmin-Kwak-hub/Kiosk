package essential.level5;

import java.util.Scanner;

public class Kiosk {
    // 속성
    private Scanner scanner = new Scanner(System.in);
    private Menu menu;


    // 생성자
    public Kiosk(Menu menu) {
        this.menu = menu;
    }

    // 게터
    // 세터

    // 기능
    // 키오스크 시작
    public void start() {

        // 반복문 시작
        // 첫번째 메뉴 선택
        while (true) {
            System.out.print("메뉴의 번호를 입력해주세요 1)버거, 2)음료, 3) 사이드메뉴 0) 종료 : ");

            int firstChoice = 0;
            int secondChoice = 0;

            // 입력값 예외처리
            try {
                firstChoice = scanner.nextInt();

            } catch (Exception e) {
                System.out.println("오류: 옳바른 입력 값이 아닙니다. 다시 입력해주세요!" + e);
                scanner.nextLine();
                continue;
            }

            // 입력값이 범위 밖일때
            if (firstChoice > 3 || firstChoice < 0) {
                System.out.println("입력이 잘못되었습니다.");
                scanner.nextLine();
                continue;
            }

            switch (firstChoice) {
                // 프로그램 종료
                case 0:
                    System.out.println("종료를 선택하셨습니다.");
                    System.out.println("프로그램을 종료합니다.");
                    return;
                    // 버거 메뉴 선택
                case 1:
                    System.out.println("버거 메뉴를 선택하셨습니다.");
                    menu.printMenu();
                    System.out.print("원하시는 메뉴의 번호를 선택해주세요.");

                    // 입력값 예외처리
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

                    // 이전단계로 돌아가기
                    if (secondChoice == 0) {
                        System.out.println("돌아가기를 선택하셨습니다.");
                        System.out.println("처음으로 돌아갑니다.");
                        scanner.nextLine();
                        break;
                    }

                    // 입력값이 메뉴 갯수에 맞게 정상일때
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
