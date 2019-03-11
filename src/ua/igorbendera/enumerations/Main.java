package ua.igorbendera.enumerations;

import java.util.Scanner;

/**
 * The {@code Main} main class make something operations with months, days, seasons
 * @author Igor Bendera
 * @since JDK 1.0
 * @version 1.1 11-th March 2019
 */
public class Main {
    public static void main(String[] args) throws WrongInputConsoleParametersException{
        Months[] months = Months.values();
        Seasons[] seasons = Seasons.values();

        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int action;
        int count;
        boolean flag = false;

        /*Loop for work with menu*/
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

            /*Get number of action*/
            action = scanner.nextInt();

            switch (action) {
                /*Check is month*/
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
                        throw new WrongInputConsoleParametersException("Місяця " + month.toUpperCase() + " не існує");
                    }
                    break;
                }
                /*Month from the same season*/
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
                            throw new WrongInputConsoleParametersException("Введеної пори року не існує!");
                        }
                    }
                    break;
                }
                /*Month with the same days*/
                case 3: {
                    System.out.print("Місяці, що мають стільки ж днів - ");
                    daysInMonth(months, 3, sc);
                    break;
                }
                /*Month with days less then entered*/
                case 4: {
                    System.out.print("Місяці, що мають менше днів ніж - ");
                    daysInMonth(months, 4, sc);
                    break;
                }
                /*Month with days rather then entered*/
                case 5: {
                    System.out.print("Місяці, що мають більше днів ніж - ");
                    daysInMonth(months, 5, sc);
                    break;
                }
                /*Next season after entered*/
                case 6: {
                    String season = isSeason(seasons);
                    if(season != "") {
                        System.out.print("Пора року після " + season.toUpperCase() + " - ");
                        checkPrevNextSeason(season, seasons, seasons.length - 1, 0, 1);
                    }
                    break;
                }
                /*Previous season before entered*/
                case 7: {
                    String season = isSeason(seasons);
                    if(season != "") {
                        System.out.print("Пора року до " + season.toUpperCase() + " - ");
                        checkPrevNextSeason(season, seasons, 0, seasons.length - 1, -1);
                    }
                    break;
                }
                /*Month with even numbers of days*/
                case 8: {
                    oddEvenNubmersOfDays(months, "парну");
                    break;
                }
                /*Month with odd numbers of days*/
                case 9: {
                    oddEvenNubmersOfDays(months, "непарну");
                    break;
                }
                /*Whether the month entered has an even numbers of days*/
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
                            throw new WrongInputConsoleParametersException("Введеного місяця не існує!");
                        }
                    }
                    break;
                }
                /*Exit with program*/
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

    /**
     * Check is Season, return Season name
     * @param seasons
     * @return Season name if exists
     */
    public static String isSeason(Seasons[] seasons) throws WrongInputConsoleParametersException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter season");
        String season = sc.nextLine();

        for (Seasons s : seasons) {
            if(season.equalsIgnoreCase(s.name())) {
                return s.name();
            } else if(s.ordinal() == 3) {
                throw new WrongInputConsoleParametersException("Введеної пори року не існує!");
            }
        }
        return "";
    }

    /**
     * Select next or previous Season
     * @param season, seasons, numberForIf, numberForOutput, numberForElse
     */
    public static void checkPrevNextSeason(String season, Seasons[] seasons, int numberForIf, int numberForOutput, int numberForElse) {
        if(Seasons.valueOf(season).ordinal() == numberForIf) {
            System.out.println(seasons[numberForOutput]);
        } else {
            System.out.println(seasons[Seasons.valueOf(season).ordinal() + numberForElse]);
        }
    }

    /**
     * Check days in month. Is entered number equals or rather or lass than days in months
     * @param months, numberOfAction, scanner
     */
    public static void daysInMonth(Months[] months, int numberOfAction, Scanner scanner) {
        int days = scanner.nextInt();
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

    /**
     * Check is month has even or odd numbers of days
     * @param months, str
     */
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
