package essential.level3;

public class MenuItem {
    // 속성
    private int itemNum;
    private String menuName;
    private double price;
    private String introduce;

    // 생성자
    public MenuItem(int itemNum, String menuName, double price, String introduce) {
        this.itemNum = itemNum;
        this.menuName = menuName;
        this.price = price;
        this.introduce = introduce;
    }

    // 기능

    // 게터
    public int getItemNum() {
        return itemNum;
    }
    public String getMenuName() {
        return menuName;
    }
    public double getPrice() {
        return price;
    }
    public String getIntroduce() {
        return introduce;
    }

    // 세터
    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
