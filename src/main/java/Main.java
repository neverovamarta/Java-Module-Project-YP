import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        ArrayList<String> schets = new ArrayList<>();
        ArrayList<Float> sum = new ArrayList<>();
        System.out.println("Добро пожаловать в наше заведение! На скольких человек необходимо разделить ваш счёт?");
        Scanner scanner = new Scanner(System.in);
        int otw = scanner.nextInt();
        while (otw < 2) {
            System.out.println("Для использования нашего приложения необходимо не менее двух посетителей, пожалуйста, повторите попытку.");
            otw = scanner.nextInt();
        }

        for (int i = 1; i <= otw; ++i) {
            String naz;
            float sch = 0;
            ArrayList<String> eda = new ArrayList<>();
            System.out.printf("Пользователь номер %d, укажите название товара, которое вы хотите заказать, и его стоимость на следующей строке.", i);
            naz = scanner.next();
            while (!(naz.equalsIgnoreCase("Завершить"))) {
                float summ = scanner.nextFloat();
                sch = summ + sch;
                eda.add(naz);
                System.out.printf("Товар '%s' успешно добавлен в счёт!", naz);
                System.out.printf("Пользователь номер %d, укажите название товара, которое вы хотите заказать, и его стоимость на следующей строке. Если вы больше не хотите ничего заказывать, напишите 'Завершить'.", i);
                naz = scanner.next();
            }
            schets.add(String.valueOf(eda));
            sum.add(sch);
            eda.clear();
        }

        for (int i = 0; i < otw; i++) {
            System.out.printf("Пользователь номер %d, ваши добавленные товары:", i + 1);
            ArrayList<String> s = new ArrayList<>();
            s.add(schets.get(i));

            for (String ed : s) {
                System.out.println(ed);
            }

            int okr = (int)Math.floor(sum.get(i));
            int ost = okr % 10;
            int ostt = okr % 100;
            String str = String.format("%d", okr);

            if (((4 < ost) && (okr <= 20)) || (okr == 11) || ((okr > 110) && (ost == 1))) {
                System.out.printf("Ваша сумма: %.2f рублей\n", sum.get(i));
            } else if (ost == 0) {
                System.out.printf("Ваша сумма: %.2f рублей\n", sum.get(i));
            } else if (str.contains("1") && okr <= 101 || ostt == 1){
                System.out.printf("Ваша сумма: %.2f рубль\n", sum.get(i));
            } else {
                System.out.printf("Ваша сумма: %.2f рубля\n", sum.get(i));
            }
            s.clear();
        }
    }
}
