package challenge.level2;

import java.util.List;

public class Order {
    private List<CartItem> orderItems;

    public Order(List<CartItem> cartItems) {
        this.orderItems = cartItems;
    }

    // 영수증 출력
    public void printReceipt() {
        double totalPrice = 0;
        System.out.println("===== 주문 영수증 =====");
        System.out.println("       주문 내역       ");
        System.out.println("||  상품번호  |    메뉴명    |  가격  |  수량  |  소계  ||");
        for (CartItem item : orderItems) {
            int itemNum = item.getMenuItem().getItemNum();
            String menuName = item.getMenuItem().getMenuName();
            double singlePrice = item.getMenuItem().getPrice();
            int quantity = item.getQuantity();
            double subtotalPrice = item.getSubtotalPrice();

            // 메뉴별 내역 출력
            System.out.println(itemNum + "  |  " + menuName + "  |  "
                    + singlePrice + "  |  " + quantity + "  |  " + subtotalPrice);
        }

        System.out.println("======================");
        System.out.println("총 결제 금액: " + getTotalPrice());
    }

    // 총 금액
    public double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem item : orderItems) {
            totalPrice += item.getSubtotalPrice();
        }
        return totalPrice;
    }
}
