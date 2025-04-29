package challenge.level1;

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
            try {
                firstChoice = scanner.nextInt();

            } catch (Exception e) {
                System.out.println("오류: 옳바른 입력 값이 아닙니다. 다시 입력해주세요!" + e);
                scanner.nextLine();
                continue;
            }

            // 입력값이 범위 밖일때
            if (firstChoice > 4 || firstChoice < 0) {
                System.out.println("입력이 잘못되었습니다.");
                scanner.nextLine();
                continue;
            }

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
                    try {
                        secondChoice = scanner.nextInt();

                    } catch (Exception e) {
                        System.out.println("오류: 옳바른 입력 값이 아닙니다. 다시 입력해주세요!" + e);
                        scanner.nextLine();
                        continue;
                    }

                    if (secondChoice > menu.getMenuList().size() || secondChoice < 0) {
                        System.out.println("입력이 잘못되었습니다.");
                        scanner.nextLine();
                        continue;
                    }

                    // 이전단계로 돌아가기
                    if (secondChoice == 0) {
                        System.out.println("돌아가기를 선택하셨습니다.");
                        System.out.println("처음으로 돌아갑니다.");
                        scanner.nextLine();
                        break;
                    }

                    // 입력값이 메뉴 갯수에 맞게 정상일때
                    // 장바구니에 담는 것으로 변경해야함.
                    // 내일 여기 하기.
                    // 현재 선택한 메뉴가 출력되고 처음으로 돌아가는데,
                    // 메뉴를 출력한 후 장바구니에 담으시겠습니까? 띄우고 네 하면 장바구니에 담기.
                    // 장바구니 담는 것 까지 성공
                    if (secondChoice <= menu.getMenuList().size()) {
                        try {
                            MenuItem selectedItem = menu.findMenu(secondChoice);
                            System.out.println("선택한 메뉴: " + selectedItem.getMenuName() + " | " + selectedItem.getPrice() + " | "
                                    + selectedItem.getIntroduce());
                            while (true) {
                                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                                System.out.println("1) 확인,  2) 취소,  0) 돌아가기");
                                try {
                                    thirdChoice = scanner.nextInt();
                                } catch (Exception e) {
                                    System.out.println("오류: 옳바른 입력 값이 아닙니다. 다시 입력해주세요!" + e);
                                    scanner.nextLine();
                                    continue;
                                }
                                if (thirdChoice > 2 || thirdChoice < 0) {
                                    System.out.println("입력이 잘못되었습니다.");
                                    scanner.nextLine();
                                    continue;
                                }
                                switch (thirdChoice) {
                                    case 0:
                                        System.out.println("돌아가기를 선택하셨습니다.");
                                        System.out.println("이전으로 돌아갑니다.");
                                        return;
                                    case 1:
                                        // 카트에 추가
                                        cart.addToCart(selectedItem);
                                        System.out.println(selectedItem.getMenuName() + "이(가) 장바구니에 추가되었습니다.");
                                        continue firstLoop;
                                    case 2:
                                        System.out.println("취소를 선택하였습니다. 처음으로 돌아갑니다.");
                                        continue firstLoop;
                                    default:
                                        System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                                        continue;
                                }
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

                        try {
                            secondChoice = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println("오류: 옳바른 입력 값이 아닙니다. 다시 입력해주세요!" + e);
                            scanner.nextLine();
                            continue;
                        }
                        if (secondChoice < 0 || secondChoice > 2) {
                            System.out.println("입력이 잘못되었습니다.");
                            scanner.nextLine();
                            continue;
                        }
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
                                    System.out.println("결제를 진행하시겠습니까? 1) 예 2) 아니요");
                                    try {
                                        thirdChoice = scanner.nextInt();
                                    } catch (Exception e) {
                                        System.out.println("오류: 잘못된 입력입니다." + e);
                                        scanner.nextLine();
                                        continue;
                                    }
                                    if (thirdChoice < 1 || thirdChoice > 2) {
                                        System.out.println("입력이 잘못되었습니다.");
                                        scanner.nextLine();
                                        continue;
                                    }

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
}
