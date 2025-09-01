package ru.netology;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        User user1 = new User(UUID.randomUUID().toString(), "City");

        Basket.showMenu();

        Basket.advertising();

        while(true) {
            System.out.print("Введите номер продукта и его количество: ");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                List<String> userBasket = Basket.inputBasket();
                System.out.print("Готовы оформить заказ? Yes/No: ");
                input = scanner.nextLine().toLowerCase();
                if (input.equals("yes")){
                    Payment paymentCard = new PaymentCard();
                    paymentCard.pay(); //ЗДЕСЬ: исключили проверку на оплату, после которой отправляем заказ
                    Order userOrder = new OrderImpl();
                    userOrder.sendOrder(user1,userBasket);
                    System.out.println("Хорошего дня!");
                    break;
                }else if (input.equals("no")){
                    Basket.showMenu();
                    Basket.advertising();
                    System.out.print("Введите номер продукта и его количество: ");
                    input = scanner.nextLine();
                }

            }
            Basket.readUserAnswer(input);
        }
    }
}