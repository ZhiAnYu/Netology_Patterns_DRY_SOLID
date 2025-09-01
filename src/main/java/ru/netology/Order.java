package ru.netology;

import java.util.ArrayList;
import java.util.List;

public interface Order {

    void sendOrder(User user, List<String> userBasket);

    void repeatOrder(List <String> userBasket);

    void cancelOrder(List <String> userBasket);
}
