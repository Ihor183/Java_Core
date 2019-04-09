package ua.igorbendera.min;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add((int)'H');
        list.add((int)'e');
        list.add((int)'l');
        list.add((int)'l');
        list.add((int)'o');

        String str = "";
        for(int i = 0; i < list.size(); i++) {
            str += String.copyValueOf(Character.toChars(list.get(i)));
        }

        System.out.println(str);
        System.out.println("Можливо помістити в List<Integer> код символу,\nале помістити об'єкт типу String" +
                " в ліст цілих чисел, на мою думку, неможливо");
    }
}
