package ua.igorbendera.commodity;

import java.util.*;

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

                    if(!checkIfSuchCommodityIsExist(commodities, commodity)) {
                        commodities.add(commodity);
                    } else {
                        System.out.println("Товар з таким кодом вже існує\n");
                    }

                    showCommodity(commodities);

                    break;
                }
                case 2: {
                    System.out.print("Enter commodity code which you wanna remove: ");
                    ListIterator<Commodity> commodityIterator = commodities.listIterator();

                    if(getReferencesOnCommodity(commodityIterator) == 1) {
                        commodityIterator.remove();
                        showCommodity(commodities);
                    } else {
                        System.out.println("Такого продукту немає!");
                    }

                    break;
                }
                case 3: {
                    System.out.print("Enter commodity code which you wanna replace: ");
                    ListIterator<Commodity> commodityIterator = commodities.listIterator();

                    if(getReferencesOnCommodity(commodityIterator) == 1) {
                        Commodity commodity = new Commodity();
                        commodity.add();
                        if(!checkIfSuchCommodityIsExist(commodities, commodity)) {
                            commodityIterator.set(commodity);
                        } else {
                            System.out.println("Товар з таким кодом вже існує\n");
                        }
                        showCommodity(commodities);
                    } else {
                        System.out.println("Такого продукту немає!");
                    }
                    break;
                }
                case 4: {
                    commodities.sort(new NameComparator());
                    showCommodity(commodities);
                    break;
                }
                case 5: {
                    commodities.sort(new HeightComparator());
                    showCommodity(commodities);
                    break;
                }
                case 6: {
                    commodities.sort(new WidthComparator());
                    showCommodity(commodities);
                    break;
                }
                case 7: {
                    commodities.sort(new WeightComparator());
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

    static int getReferencesOnCommodity(ListIterator<Commodity> commodityIterator) {
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();

        while(commodityIterator.hasNext()) {
            Commodity next = commodityIterator.next();

            if(next.getCode().equalsIgnoreCase(code)) {
               return 1;
            }
        }
        return 0;
    }

    static void showCommodity(List<Commodity> commodities) {
        System.out.println();
        for(Commodity c : commodities) {
            System.out.println(c);
        }
        System.out.println();
    }

    static boolean checkIfSuchCommodityIsExist(List<Commodity> commodities, Commodity commodity) {
        for(Commodity c : commodities) {
            if(c.equals(commodity)) {
                return true;
            }
        }
        return false;
    }
}
