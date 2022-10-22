package com.company;

import java.util.Scanner;

public class MainUnscs {

    private static final Scanner scanner = new Scanner(System.in);
    private static int costOfService = 0;
    private static boolean isFirstService = false;
    private static boolean isSecondService = false;
    private static boolean isThirdService = false;
    private static final String FIRST_SERVICE = "Укладку";
    private static final String SECOND_SERVICE = "Бритье";
    private static final String THIRD_SERVICE = "Стрижку";
    private static final String DECLINE = "Нет";

    public static void main(String[] args) {
        System.out.println("Добро пожаловать! Наши услуги: Укладка - 100, Бритье - 300, Стрижка - 400");
        System.out.println("Введите имя клиента:");
        String clientName = scanner.next();
        System.out.println("Введите возраст клиента:");
        byte clientAge = scanner.nextByte();
        System.out.println("Клиент - мужчина?");
        boolean isMale = scanner.nextBoolean();
        if (checkClient(clientAge, isMale, clientName)){
            System.out.println("Хотите Укладку, Бритье, Стрижку?");
            int numberOfService = 0;
            while (numberOfService!=-1){
                if(isFirstService && isSecondService && isThirdService) {
                    System.out.println("Вы выбрали все возможные услуги.");
                    break;
                }
                String service = scanner.next();
                numberOfService = getNumberOfService(service);
            }
            if(costOfService==0){
                System.out.println("Очень жаль, что вы ничего не выбрали. Приходите ещё.");
            }
            else{
                makeHairStyle();
                System.out.println("Мы надеемся ваша стрижка Вам понравилась!");
                System.out.println("Просим оплатить Вас " + costOfService);
                executePayment();
            }

        }

    }

    public static void makeHairStyle(){
        if(isFirstService){
            System.out.println("Делаем " +FIRST_SERVICE);
        }
        if(isSecondService){
            System.out.println("Делаем " +SECOND_SERVICE);
        }
        if(isThirdService){
            System.out.println("Делаем " +THIRD_SERVICE);
        }

    }

    //метод, который вызывает сам себя, чтобы дождаться пока клиент не олпатит все услуги
    public static void executePayment(){

        int clientPayment = scanner.nextInt();
        costOfService -= clientPayment;
        if(costOfService == 0){
            System.out.println("Спасибо! Оплата успешна! Приходите еще...");
        }else if(costOfService < 0){
            System.out.println("Это слишком много, вы что! Мы вернем Вам на карту " + (Math.abs(costOfService)));
            System.out.println("Приходите еще...");
        }else {
            System.out.println("Тут не хватает " + costOfService + ", сделаем еще одну транзакцию" );
            executePayment();
        }
    }

    public static boolean checkClient(byte clientAge, boolean isMale, String clientName){
        if (!isMale){
            System.out.println("Наши мастера не знают как вас стричь, просим прощения, " + clientName);
        }
        else if (clientAge <= 18){
            System.out.println("С удовольствием вас обслужим, " + clientName + ". Но пожалуйста приведите родителей...");
        }else {
            System.out.println("Добро пожаловать, " + clientName + "! Присаживайтесь, ваш мастер сейчас подойдет...");
            return true;
        }
        return false;
    }

    //метод обрабатывает все варианты ввода с клавиатуры и сразу считает стоймость услуг
    public static int getNumberOfService(String service){
        if(service.equalsIgnoreCase(DECLINE)){
            return -1;
        }
        if(service.equalsIgnoreCase(FIRST_SERVICE)){
            if(!isFirstService){
                costOfService += 100;
                isFirstService = true;
                System.out.println("Вы выбрали " +FIRST_SERVICE+ ".Хотите что-нибудь еще?");
            }
            else {
                System.out.println("Вы уже выбрали + " +FIRST_SERVICE+ ". Хотите что-нибудь еще?");
            }
            return 1;
        }
        if(service.equalsIgnoreCase(SECOND_SERVICE)){
            if(!isSecondService){
                costOfService += 300;
                isSecondService = true;
                System.out.println("Вы выбрали " +SECOND_SERVICE+ ". Хотите что-нибудь еще?");
            }
            else {
                System.out.println("Вы уже выбрали + " +SECOND_SERVICE+ ". Хотите что-нибудь еще?");
            }
            return 2;
        }
        if(service.equalsIgnoreCase(THIRD_SERVICE)){
            if(!isThirdService){
                costOfService += 400;
                isThirdService = true;
                System.out.println("Вы выбрали " +THIRD_SERVICE+ ". Хотите что-нибудь еще?");
            }
            else {
                System.out.println("Вы уже выбрали + " +THIRD_SERVICE+ ". Хотите что-нибудь еще?");
            }
            return 3;
        }
        System.out.println("Мы не знаем как оказать такую услугу. Хотите выбрать что-нибудь еще?");
        return 0;
    }

}