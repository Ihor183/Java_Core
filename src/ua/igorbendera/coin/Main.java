package ua.igorbendera.coin;

public class Main {
    public static void main(String[] args) {
        Coin throwCoin = side -> side == 0;

        System.out.println(throwC(((int) (Math.random() * 2)), throwCoin) ? "Орел" : "Решка");
    }

    private static boolean throwC(int i, Coin sideOfCoin) {
        return sideOfCoin.sideOfCoin(i);
    }
}
