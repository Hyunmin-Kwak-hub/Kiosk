package challenge.level1;

public class CartItem {

    // 속성
    private MenuItem menuItem;
    private int quantity;

    // 생성자
    public CartItem(MenuItem menuItem) {
        this.menuItem = menuItem;
        this.quantity = 1; // 처음 담을때 수량
    }

    // 기능
    public MenuItem getMenuItem() {
        return menuItem;
    }
    public int getQuantity() {
        return quantity;
    }
    // 메뉴 갯수 증가
    public void increaseQuantity() {
        quantity++;
    }

    // 메뉴별 금액 소계
    public double getSubtotalPrice() {
        return menuItem.getPrice() * quantity;
    }
}
