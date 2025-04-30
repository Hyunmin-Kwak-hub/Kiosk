package challenge.level2;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    // 속성
    private List<CartItem> cartList = new ArrayList<>();

    // 생성자
    public Cart() {

    }

    // 기능
    // 장바구니에 메뉴 추가
    public void addToCart(MenuItem menuItem) {
        // 장바구니에 같은 메뉴가 이미 있는지 체크
        for (CartItem item : cartList) {
            // 같은 메뉴가 이미 있으면 수량만 증가
            if (item.getMenuItem().getItemNum() == menuItem.getItemNum()) {
                // 수량 증가
                item.increaseQuantity();
                return;
            }
        }
        // 장바구니에 해당 메뉴가 없으면 새로 추가
        cartList.add(new CartItem(menuItem)); // 수량은 자동으로 1개로 시작
    }

    // 장바구니 출력
    public void showCart() {

        if (cartList.isEmpty()) {
            System.out.println(" 장바구니가 비어있습니다.");
            return;
        }

        System.out.println("===== 장바구니 목록 =====");
        for (CartItem item : cartList) {
            System.out.println("상품번호: " + item.getMenuItem().getItemNum()
            + " |  메뉴명: " + item.getMenuItem().getMenuName() + " |  가격: W"
                    + item.getMenuItem().getPrice() + " |  수량: "
                    + item.getQuantity() + "개");
        }
        System.out.println();
    }

    // 장바구니 초기화
    public void clearCart() {
        cartList.clear();
    }

    public boolean isEmpty() {
        return cartList.isEmpty();
    }

    // 게터

    public List<CartItem> getCartList() {
        return cartList;
    }
}
