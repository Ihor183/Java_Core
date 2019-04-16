package ua.igorbendera.commodity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Commodity> commodities = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int action;

        while(true) {
            menu();

            action = scanner.nextInt();

            switch(action) {
                case 1: {
                    Commodity commodity = new Commodity();
                    commodity.add();

                    if(!commodities.contains(commodity)) {
                        commodities.add(commodity);
                    } else {
                        System.out.println("Товар з таким кодом вже існує\n");
                    }

                    showCommodity(commodities);

                    break;
                }
                case 2: {
                    System.out.print("Enter commodity code which you wanna remove: ");

                    Commodity commodity = getReferencesOnCommodity(commodities);

                    if(commodity != null) {
                        commodities.remove(commodity);
                        showCommodity(commodities);
                    } else {
                        System.out.println("Такого продукту немає!");
                    }

                    break;
                }
                case 3: {
                    System.out.print("Enter commodity code which you wanna replace: ");

                    Commodity commodity = getReferencesOnCommodity(commodities);
                    Commodity newCommodity = new Commodity();

                    if(commodity != null) {
                        newCommodity.add();
                        if(!commodities.contains(newCommodity)) {
                            commodities.set(commodities.indexOf(commodity), newCommodity);
                        } else {
                            System.out.println("Продукт з таким кодом вже існує");
                        }
                    } else {
                        System.out.println("Такого продукту немає!");
                    }
                    break;
                }
                case 4: {
                    commodities = commodities.stream().sorted(Comparator.comparing(Commodity::getName)).collect(Collectors.toList());
                    showCommodity(commodities);
                    break;
                }
                case 5: {
                    commodities = commodities.stream().sorted(Comparator.comparing(Commodity::getHeight)).collect(Collectors.toList());
                    showCommodity(commodities);
                    break;
                }
                case 6: {
                    commodities = commodities.stream().sorted(Comparator.comparing(Commodity::getWidth)).collect(Collectors.toList());
                    showCommodity(commodities);
                    break;
                }
                case 7: {
                    commodities = commodities.stream().sorted(Comparator.comparing(Commodity::getWeight)).collect(Collectors.toList());
                    showCommodity(commodities);
                    break;
                }
                case 8: {
                    System.out.println("Введіть і-тий номер елементу: ");
                    Scanner sc = new Scanner(System.in);

                    int index = sc.nextInt();
                    if(commodities.size() > index) {
                        System.out.println(commodities.get(index));
                    } else {
                        System.out.println("Елемента з таким індексом немає\n");
                    }

                    break;
                }
                case 9: {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Некоректний ввід!");
                    return;
            }
        }
    }

    static void menu() {
        System.out.println("Виберіть пункт\n" +
                "1 - Додати товар\n" +
                "2 - Видалити товар\n" +
                "3 - Замінити товар\n" +
                "4 - Сортувати за назвоню\n" +
                "5 - Сортувати за висотою\n" +
                "6 - Сортувати за шириною\n" +
                "7 - Сортувати за вагою\n" +
                "8 - Виводимо і-тий елемент колекції\n" +
                "9 - Вийти з програми\n");
    }

    static Commodity getReferencesOnCommodity(List<Commodity> commodity) {
        String code = new Scanner(System.in).nextLine();
        Commodity com = new Commodity(code);

        if(commodity.contains(com)) {
            return commodity.get(commodity.indexOf(com));
        } else {
            return null;
        }
    }

    static void showCommodity(List<Commodity> commodities) {
        commodities.forEach(System.out::println);
    }
}
