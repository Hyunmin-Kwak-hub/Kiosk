package challenge.level2;

public class Main {
    public static void main(String[] args) {

        // Menu 객체 생성을 통해 이름 설정
        Menu menu = new Menu();

        // Cart 객체 생성
        Cart cart = new Cart();

        // Order 객체 생성
        Order order = new Order(cart.getCartList());

        // Menu 클래스 내 있는 List<MenuItem>에 MenuItem 객체 생성하면서 삽입
        MenuItem item0 = new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem item1 = new MenuItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem item2 = new MenuItem(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem item3 = new MenuItem(4, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");
        menu.addMenu(item0);
        menu.addMenu(item1);
        menu.addMenu(item2);
        menu.addMenu(item3);

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menu, cart, order);

        // Kiosk 내 시작하는 함수 호출
        kiosk.start();
    }
}
