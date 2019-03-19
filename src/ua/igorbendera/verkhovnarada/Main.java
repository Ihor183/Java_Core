package ua.igorbendera.verkhovnarada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VerkhovnaRada verkhovnaRada = new VerkhovnaRada();

        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        int action;

        while (!flag) {
            menu();
            action = scanner.nextInt();

            switch(action) {
                case 1: {
                    verkhovnaRada.addFaction();
                    break;
                }
                case 2: {
                    verkhovnaRada.removeFaction();
                    break;
                }
                case 3: {
                    verkhovnaRada.showAllFactions();
                    break;
                }
                case 4: {
                    Faction faction = verkhovnaRada.getFaction();
                    if(checkFaction(faction)) {
                        faction.clearFaction();
                    }
                    break;
                }
                case 5: {
                    verkhovnaRada.showFaction();
                    break;
                }
                case 6: {
                    Faction faction = verkhovnaRada.getFaction();
                    if(checkFaction(faction)) {
                        faction.addDeputy();
                    }
                    break;
                }
                case 7: {
                    Faction faction = verkhovnaRada.getFaction();
                    if(checkFaction(faction)) {
                        faction.removeDeputy();
                    }
                    break;
                }
                case 8: {
                    Faction faction = verkhovnaRada.getFaction();
                    if(checkFaction(faction)) {
                        faction.showBribeTakers();
                    }
                    break;
                }
                case 9: {
                    Faction faction = verkhovnaRada.getFaction();
                    if(checkFaction(faction)) {
                        faction.mostBribeTakerIs();
                    }
                    break;
                }
                case 10: {
                    Faction faction = verkhovnaRada.getFaction();
                    if(checkFaction(faction)) {
                        Deputy deputy = faction.getDeputy();
                        if(checkDeputy(deputy)) {
                            deputy.giveBribe();
                        }
                    }
                    break;
                }
                case 11: {
                    flag = true;
                    break;
                }
                default:
                    System.out.println("Неправильне число");
                    break;
            }
        }
    }

    private static boolean checkFaction(Faction faction) {
        if(!faction.getFactionName().equals("")){
            return true;
        } else {
            System.out.println("Такої фракції не існує");
        }
        return false;
    }

    private static boolean checkDeputy(Deputy deputy) {
        if(!(deputy.getName() == null)){
            return true;
        } else {
            System.out.println("Такого депутата немає у введеній фракції");
        }
        return false;
    }

    public static void menu() {
        System.out.println("Виберіть пункт\n" +
                "1 -  додати фракцію\n" +
                "2 -  видалити конкретну фракцію\n" +
                "3 -  вивести усі фракції\n" +
                "4 -  очистити конкретну фракцію\n" +
                "5 -  вивести конкретну фракцію\n" +
                "6 -  додати депутата в фракцію\n" +
                "7 -  видалити депутата з фракції\n" +
                "8 -  вивести список хабарників\n" +
                "9 -  вивести найбільшого хабарника\n" +
                "10 -  дати хабара\n" +
                "11 -  вихід\n");
    }
}
