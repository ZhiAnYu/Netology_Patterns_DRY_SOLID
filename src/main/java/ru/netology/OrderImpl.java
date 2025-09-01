package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderImpl implements Order{
    private static String trackNumber;
    private static String orderNumber;

    @Override
    public void sendOrder(User user, List<String> userBasket) {
        trackNumber = UUID.randomUUID().toString();
        orderNumber = UUID.randomUUID().toString();
        System.out.println("Покупателю " + user.getId() + " отправлен заказ # " + orderNumber);
        System.out.println("Номер для отслеживания: " + trackNumber);
        System.out.println("Ваш заказ: " + userBasket.toString());
    }

    @Override
    public void repeatOrder(List<String> userBasket) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void cancelOrder(List<String> userBasket) {
        throw new RuntimeException("Not implemented");
    }
}
