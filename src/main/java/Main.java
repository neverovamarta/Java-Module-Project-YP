import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в наше заведение! На скольких человек необходимо разделить ваш счёт?");
        Scanner scanner = new Scanner(System.in);
        int people = 0;
        float money = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                people = scanner.nextInt();
                if (people >= 2) {
                    break;
                } else {
                    System.out.println("Для использования нашего приложения необходимо не менее двух посетителей, пожалуйста, повторите попытку.");
                }
            } else {
                System.out.println("Ошибка! Введите целочисленное значение");
                scanner.next();
            } }
        Menu menu = new Menu();
        String name;
        System.out.print("Укажите название товара, которое вы хотите заказать\n");
        name = scanner.next();
        while (!(name.equalsIgnoreCase("Завершить"))) {
            System.out.println("Укажите стоимость товара в формате: рубли,копейки.");
            menu.add(name);
            float cost;
            while (true) {
                if (scanner.hasNextFloat()) {
                    cost = scanner.nextFloat();
                    if (cost > 0) {
                        money = money + cost;
                        break;
                    } else {
                        System.out.println("Стоимость не может быть отрицательна, введите другое число.");
                    }
                } else {
                    System.out.println("Ошибка! Введите числовое значение");
                    scanner.next();
                }
            }
            System.out.printf("Товар '%s' успешно добавлен в счёт!\n", name);
            System.out.print("Укажите название товара, которое вы хотите заказать, и его стоимость на следующей строке. Если вы больше не хотите ничего заказывать, напишите 'Завершить'.\n");
            name = scanner.next();
        }
        menu.result(money, people);
} }

class Menu {
    ArrayList<String> names = new ArrayList<>();
    public void add(String menu) {
        names.add(menu);
    }

    public void result(float peoplesMoney, int peoples) {
        System.out.print("Ваши добавленные товары:\n");
        for (String food : names) {
            System.out.println(food);
        }

        int okr = (int)Math.floor(peoplesMoney / peoples);
        int ost = okr % 10;
        int ostt = okr % 100;
        String str = String.format("%d", okr);

        if (((4 < ost) && (okr <= 20)) || (okr == 11) || ((okr > 110) && (ost == 1))) {
            System.out.printf("Каждый должен заплатить: %.2f рублей\n", peoplesMoney / peoples);
        } else if (ost == 0) {
            System.out.printf("Каждый должен заплатить: %.2f рублей\n", peoplesMoney / peoples);
        } else if (str.contains("1") && okr <= 101 || ostt == 1){
            System.out.printf("Каждый должен заплатить: %.2f рубль\n", peoplesMoney / peoples);
        } else {
            System.out.printf("Каждый должен заплатить: %.2f рубля\n", peoplesMoney / peoples);
        }
    }
    }
