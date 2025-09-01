package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    public static final Item[] PRODUCTS = {
            new Item("Хлеб", "Meal", "Хлебзавод № 3"),
            new Item("Яблоки", "Meal", "Кубанские сады"),
            new Item("Молоко", "Meal", "Самаралакто"),
            new Item("Cахар", "Meal", "Сахарозавод")};
    public static final int[] PRICES = {50, 150, 100, 100};
    public static int[] inputCount = new int[PRODUCTS.length];
    public static int[] currentPrices = new int[PRICES.length];
    public static int sumProducts = 0;


    public static void readUserAnswer(String input) {
        String[] answer = input.split(" ");
        int productNumber = Integer.parseInt(answer[0]) - 1;
        int productCount = Integer.parseInt(answer[1]);
        inputCount[productNumber] += productCount;
        currentPrices[productNumber] = inputCount[productNumber] * PRICES[productNumber];
        PRODUCTS[productNumber].addRatingItem();
    }

    public static List<String> inputBasket() {
        System.out.println("Ваша корзина: ");
        List<String> userBasket = new ArrayList<>();
        for (int i = 0; i < PRICES.length; i++) {
            if (inputCount[i] != 0) {
                sumProducts += currentPrices[i];
                String userItem = PRODUCTS[i].getNameItem()
                        + " количество: " + inputCount[i]
                        + "ед "
                        + " цена: " + PRICES[i] + "руб/ед "
                        + " стоимость: " + currentPrices[i] + "руб";
                userBasket.add(userItem);
                System.out.println(userItem);
            }
        }
        System.out.printf("Общая стоимость Вашей корзины: %d руб\n", sumProducts);
        return userBasket;
    }

    public static void showMenu() {
        System.out.println("В нашем магазине есть: ");
        for (int i = 0; i < Basket.PRODUCTS.length; i++) {
            System.out.println((i + 1) + " "
                    + Basket.PRODUCTS[i].getNameItem() + " "
                    + Basket.PRICES[i] + " руб/ед");
        }
    }

    public static void advertising() {
        int[] popItem = new int[PRODUCTS.length];
        int maxIndex = 0;
        for (int i = 0; i < PRODUCTS.length; i++) {
            popItem[i] = PRODUCTS[i].getRatingItem();
            if (popItem[i] > popItem[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("Наш самый популярный товар на сегодня: " + PRODUCTS[maxIndex].getNameItem());
    }
}
