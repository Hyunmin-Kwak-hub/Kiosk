package essential.level5;


import java.util.ArrayList;
import java.util.List;

public class Menu {
    //속성
    private List<MenuItem> menuList = new ArrayList<>();

    // 생성자
    public Menu() {

    }

    //기능
    public void addMenu(MenuItem item) {
        menuList.add(item);
    }

    public void printMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        for (MenuItem item : menuList) {
            System.out.println(item.getItemNum() + ". " + item.getMenuName() + " | " + "W " + item.getPrice() + " | " + item.getIntroduce());
        }
        System.out.println(0 + ". 돌아가기      | 돌아가기");
    }

    public MenuItem findMenu(int menuNum) {
        for (MenuItem item : menuList) {
            if (item.getItemNum() == menuNum) {
                return item;
            }
        }
        return null; // 수정
    }

    // 게터

    public List<MenuItem> getMenuList() {
        return menuList;
    }


    // 세터
}
