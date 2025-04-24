package essential.level1;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    //속성
    public int menuNum;

    // 생성자
    public Menu() {

    }

    //기능
    public void selectMenu(int menuNum) {

        switch (menuNum) {
            case 1:
                System.out.println("버거 메뉴를 선택하셨습니다.");

                break;
            case 2:
                System.out.println("음료 메뉴를 선택하셨습니다.");

                break;
            case 3:
                System.out.println("사이드 메뉴를 선택하셨습니다.");

                break;
            default:
                System.out.println("잘못된 입력입니다. 처음으로 돌아갑니다.");
                break;
        }
    }


    // 게터


    // 세터


}
