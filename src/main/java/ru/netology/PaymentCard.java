package ru.netology;

public class PaymentCard implements Payment{
    static boolean isPay;
    @Override
    public void pay(){
        System.out.println("Оплата прошла");
        isPay = true;
    }
}
