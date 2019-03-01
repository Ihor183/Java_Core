package pack_throw_coin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int action;
        int coin;
        Scanner scanner = new Scanner(System.in);

        boolean flag = false;

        while (!flag) {
            System.out.println("Make a choice\n 1 - Орел\n 2 - Решка\n 3 - Закінчити гру");
            action = scanner.nextInt();

            switch (action) {
                case 1:
                case 2:
                    coin = (int)Math.round(Math.random() + 1);
                    if (coin == 1)
                        System.out.println("Випав орел");
                    else
                        System.out.println("Випала решка");

                    if (coin == action)
                        System.out.println("You won\n");
                    else
                        System.out.println("You lost\n");

                    break;
                case 3:
                    flag = true;
                    break;

                default:
                    System.out.println("wrong number!!!");
                    break;
            }
        }
    }
}
