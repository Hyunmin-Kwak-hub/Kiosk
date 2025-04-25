package essential.level3;

import essential.level2.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // 속성
    private List<MenuItem> menuItems = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    //생성자
    public Kiosk() {

    }

    //기능
    public void start() {

        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        MenuItem item0 = new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem item1 = new MenuItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem item2 = new MenuItem(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem item3 = new MenuItem(4, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");
        menuItems.add(item0);
        menuItems.add(item1);
        menuItems.add(item2);
        menuItems.add(item3);

        int choice = 0;

        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");

            // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
            for (MenuItem menuItem : menuItems) {
                System.out.println(menuItem.getItemNum() + ". " + menuItem.getItemNum() + " |  W " + menuItem.getPrice() + " | " + menuItem.getIntroduce());
            }
            // 숫자를 입력 받기
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

            String output;

            // 입력된 숫자에 따른 처리
            switch (choice) {
                // 프로그램을 종료
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                // 선택한 메뉴 : 이름, 가격, 설명
                case 1:
                    output = getOutput(item0);
                    System.out.println(output);
                    break;
                case 2:
                    output = getOutput(item1);
                    System.out.println(output);
                    break;
                case 3:
                    output = getOutput(item2);
                    System.out.println(output);
                    break;
                case 4:
                    output = getOutput(item3);
                    System.out.println(output);
                    break;

                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
            System.out.println();
        }
    }

    // 입력된 숫자에 따른 처리
    public static String getOutput(MenuItem menuItem) {
        return ("선택한 메뉴: " + menuItem.getMenuName() + ", " + menuItem.getPrice() + ", " + menuItem.getIntroduce());
    }
}
