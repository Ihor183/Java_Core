package pack_enumerations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Months[] months = Months.values();
        Seasons[] seasons = Seasons.values();

        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int action;
        int count;
        boolean flag = false;

        while (!flag) {

            System.out.print("1 - перевірити чи є такий місяць\n" +
                    "2 - вивести всі місяці з такою ж порою року\n" +
                    "3 - вивести всі місяці які мають таку саму кількість днів\n" +
                    "4 - вивести на екран всі місяці які мають меншу кількість днів\n" +
                    "5 - вивести на екран всі місяці які мають більшу кількість днів\n" +
                    "6 - вивести на екран наступну пору року\n" +
                    "7 - вивести на екран попередню пору року\n" +
                    "8 - вивести на екран всі місяці які мають парну кількість днів\n" +
                    "9 - вивести на екран всі місяці які мають непарну кількість днів\n" +
                    "10 - вивести на екран чи введений з консолі місяць має парну кількість днів\n" +
                    "11 - вихід\n" +
                    "Введіть число : \n");

            action = scanner.nextInt();

            switch (action) {
                case 1: {
                    count = 0;
                    System.out.println("Enter month");
                    String month = sc.nextLine();
                    for (Months mon : months) {
                        if(month.equalsIgnoreCase(mon.name())) {
                            System.out.println("Місяць " + month.toUpperCase() + " існує");
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Місяця " + month.toUpperCase() + " не існує");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter season");
                    String season = sc.nextLine();
                    for (Seasons s : seasons) {
                        if(season.equalsIgnoreCase(s.name())) {
                            System.out.println("В порі року - " + s.name() + " Є такі місяці: ");
                            for (Months mon : months) {
                                if(s.equals(mon.getSeasons())){
                                    System.out.println(mon.name() + " ");
                                }
                            }
                            break;
                        } else if(s.ordinal() == 3) {
                            System.out.println("Введеної пори року не існує. Попробуйте ще раз!");
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.print("Місяці, що мають стільки ж днів - ");
                    daysInMonth(months, 3, sc);
                    break;
                }
                case 4: {
                    System.out.print("Місяці, що мають менше днів ніж - ");
                    daysInMonth(months, 4, sc);
                    break;
                }
                case 5: {
                    System.out.print("Місяці, що мають більше днів ніж - ");
                    daysInMonth(months, 5, sc);
                    break;
                }
                case 6: {
                    String season = isSeason(seasons);
                    if(season != "") {
                        System.out.print("Пора року після " + season.toUpperCase() + " - ");
                        checkPrevNextSeason(season, seasons, seasons.length - 1, 0, 1);
                    }
                    break;
                }
                case 7: {
                    String season = isSeason(seasons);
                    if(season != "") {
                        System.out.print("Пора року до " + season.toUpperCase() + " - ");
                        checkPrevNextSeason(season, seasons, 0, seasons.length - 1, -1);
                    }
                    break;
                }
                case 8: {
                    oddEvenNubmersOfDays(months, "парну");
                    break;
                }
                case 9: {
                    oddEvenNubmersOfDays(months, "непарну");
                    break;
                }
                case 10: {
                    System.out.println("Enter month");
                    String month = sc.nextLine();
                    for (Months mon : months) {
                        if (month.equalsIgnoreCase(mon.name())) {
                            if (mon.getDay() % 2 == 0) {
                                System.out.println(mon.name() + " має парну кількість днів");
                            } else {
                                System.out.println(mon.name() + " має непарну кількість днів");
                            }
                            break;
                        } else if(mon.ordinal() == 11) {
                            System.out.println("Введеного місяця не існує. Попробуйте ще раз!");
                        }
                    }
                    break;
                }
                case 11: {
                    flag = true;
                    break;
                }
                default:
                    System.out.println("Wrong action\n");
                    break;
            }
        }
    }

    public static String isSeason(Seasons[] seasons) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter season");
        String season = sc.nextLine();

        for (Seasons s : seasons) {
            if(season.equalsIgnoreCase(s.name())) {
                return s.name();
            } else if(s.ordinal() == 3) {
                System.out.println("Введеної пори року не існує. Попробуйте ще раз!");
                return "";
            }
        }
        return "";
    }

    public static void checkPrevNextSeason(String season, Seasons[] seasons, int numberForIf, int numberForOutput, int numberForElse) {
        if(Seasons.valueOf(season).ordinal() == numberForIf) {
            System.out.println(seasons[numberForOutput]);
        } else {
            System.out.println(seasons[Seasons.valueOf(season).ordinal() + numberForElse]);
        }
    }

    public static void daysInMonth(Months[] months, int numberOfAction, Scanner sc) {
        int days = sc.nextInt();
        int count = 0;
        for (Months mon : months) {
            if((mon.getDay() == days & numberOfAction == 3) |
               (mon.getDay() < days & numberOfAction == 4) |
               (mon.getDay() > days & numberOfAction == 5)) {
                count++;
                System.out.println(mon.name());
            }
        }

        if (count == 0) {
            System.out.println("Таких місяців немає");
        }
    }

    public static void oddEvenNubmersOfDays(Months[] months, String str) {
        System.out.println("Місяці мають " + str + " кількість днів: ");
        for (Months mon : months) {
            if((mon.getDay() % 2 == 0 & str.equals("парну")) | (mon.getDay() % 2 != 0 & str.equals("непарну"))) {
                System.out.print(mon.name() + " ");
            }
        }
        System.out.println();
    }
}
