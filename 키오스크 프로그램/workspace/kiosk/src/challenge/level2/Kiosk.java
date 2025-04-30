package challenge.level2;

import java.util.Scanner;

public class Kiosk {
    // 속성
    private Scanner scanner = new Scanner(System.in);
    private Menu menu;
    private Cart cart;
    private Order order;


    // 생성자
    public Kiosk(Menu menu, Cart cart, Order order) {

        this.menu = menu;
        this.cart = cart;
        this.order = order;
    }

    // 게터
    // 세터

    // 기능
    // 키오스크 시작
    public void start() {

        // 반복문 시작
        // 첫번째 메뉴 선택
        firstLoop: while (true) {
            System.out.print("메뉴의 번호를 입력해주세요 1)버거, 2)음료, 3) 사이드메뉴 , 4) 장바구니, 0) 종료 : ");

            int firstChoice = 0;
            int secondChoice = 0;
            int thirdChoice = 0;

            // 입력값 예외처리
            firstChoice = getInput(4); // getInput(보기 갯수)

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
                    secondChoice = getInput(menu.getMenuList().size());

                    // 이전단계로 돌아가기
                    if (secondChoice == 0) {
                        System.out.println("돌아가기를 선택하셨습니다.");
                        System.out.println("처음으로 돌아갑니다.");
                        scanner.nextLine();
                        break;
                    }

                    if (secondChoice <= menu.getMenuList().size()) {
                        try {
                            MenuItem selectedItem = menu.findMenu(secondChoice);
                            System.out.println("선택한 메뉴: " + selectedItem.getMenuName() + " | " + selectedItem.getPrice() + " | "
                                    + selectedItem.getIntroduce());
                            while (true) {
                                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                                System.out.println("1) 확인,  2) 취소,  0) 돌아가기");

                                thirdChoice = getInput(2);

                                // 이전단계로 돌아가기
                                if (thirdChoice == 0) {
                                    System.out.println("돌아가기를 선택하셨습니다.");
                                    System.out.println("처음으로 돌아갑니다.");
                                    scanner.nextLine();
                                    break;
                                }

                                switch (thirdChoice) {
                                    case 1:
                                        // 카트에 추가
                                        cart.addToCart(selectedItem);
                                        System.out.println(selectedItem.getMenuName() + "이(가) 장바구니에 추가되었습니다.");
                                        break;
                                    case 2:
                                        System.out.println("취소를 선택하였습니다. 처음으로 돌아갑니다.");
                                        break;
                                    default:
                                        System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                                        continue;
                                }
                                break;
                            }
                        } catch (RuntimeException e) {
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
                case 4:
                    System.out.println("장바구니 메뉴를 선택하셨습니다.");
                    // 장바구니 출력 or 주문
                    while (true) {
                        System.out.println("원하시는 기능을 선택해주세요. 1) 장바구니 보기, 2) 주문하기, 0) 돌아가기");

                        secondChoice = getInput(2);

                        switch (secondChoice) {
                            // 이전단계로 돌아가기
                            case 0:
                                System.out.println("돌아가기를 선택하셨습니다.");
                                System.out.println("처음으로 돌아갑니다.");
                                scanner.nextLine();
                                continue firstLoop;
                                // 장바구니 출력
                            case 1:
                                cart.showCart(); // 장바구니 출력
                                break;
                                // 주문하기
                            case 2:
                                System.out.println("주문하기를 선택하셨습니다.");

                                // 결제 영수증 출력
                                order.printReceipt();

                                while (true) {
                                    System.out.println("결제를 진행하시겠습니까? 1) 예 2) 아니요 0) 돌아가기");

                                    thirdChoice = getInput(2);

                                    switch (thirdChoice) {
                                        case 1:
                                            System.out.println("결제가 완료되었습니다. 금액은 W"
                                                    + order.getTotalPrice() + " 입니다");
                                            // 장바구니 초기화
                                            cart.clearCart();
                                            System.out.println("메뉴로 돌아갑니다. 계속 주문하시려면 메뉴를 선택하세요.");
                                            continue firstLoop;
                                        case 2:
                                            System.out.println("결제가 취소되었습니다. 메뉴로 돌아갑니다.");
                                            continue firstLoop;
                                        default:
                                            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                                            break;
                                    }
                                }
                            default:
                                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                                scanner.nextLine();
                                break;
                        }
                    }
                default:
                    System.out.println("잘못된 입력입니다. 처음으로 돌아갑니다.");
                    scanner.nextLine();
                    break;
            }
        }
    }

    // 입력받는 메서드 getInput(int 보기 갯수)
    public int getInput(int count) {
        int input = 0;
        try {
            input = scanner.nextInt();

            if (input < 0 || input > count) {
                System.out.println("입력이 잘못되었습니다. 허용된 범위안에서 다시 입력해주세요.");
                scanner.nextLine();
            }
        } catch (Exception e) {
            System.out.println("*오류* 잘못된 입력입니다. 오류코드: " + e);
            scanner.nextLine();
        }
         return input;
    }
    // 입력받는 메서드를 만들어서 적용했는데, 이렇게 하니까 잘못된 예외값을 받아도 본문에서 switch문으로 들어가는 것 같음
    // 내일 수정해보기.



}
