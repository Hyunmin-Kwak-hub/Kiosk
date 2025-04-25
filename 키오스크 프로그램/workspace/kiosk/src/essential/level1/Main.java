package essential.level1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String menu1 = 1 + ". ShackBurger | W" + 6.9 + " | 토마토, 양상추, 쉑소스가 토핑된 치즈버거";
        String menu2 = 2 + ". SmokeShack | W" + 6.9 + " | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거";
        String menu3 = 3 + ". Cheeseburger | W" + 6.9 + " | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거";
        String menu4 = 4 + ". Hamburger | W" + 6.9 + " | 비프패티를 기반으로 야채가 들어간 기본버거";

        int choice = 0;

        while(true) {
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println(menu1);
            System.out.println(menu2);
            System.out.println(menu3);
            System.out.println(menu4);
            System.out.println(0 + ". 종료     | 종료");

            try {
                choice = scanner.nextInt();

            } catch (Exception e) {
                System.out.println("오류: 옳바른 입력 값이 아닙니다. 다시 입력해주세요!" + e);
                scanner.nextLine();
                continue;
            }

            if (choice > 4 || choice < 0) {
                System.out.println("입력이 잘못되었습니다.");
                scanner.nextLine();
                continue;
            }

            if (choice == 0) {
                System.out.println("종료를 선택하셨습니다.");
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println(menu1);
                    break;
                case 2:
                    System.out.println(menu2);
                    break;
                case 3:
                    System.out.println(menu3);
                    break;
                case 4:
                    System.out.println(menu4);
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }

            System.out.println();
        }
    }
}
