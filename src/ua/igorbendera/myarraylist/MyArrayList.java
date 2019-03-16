package ua.igorbendera.myarraylist;

import java.util.Arrays;

public class MyArrayList {
    private int[] array;
    private int size;

    public MyArrayList() {

    }

    public MyArrayList(int size) {
        this.array = new int[size];
    }

    public boolean add(int value) {
        increaseArray();
        array[array.length - 1] = value;

        return true;
    }

    public void increaseArray() {
        if(size != 0) {
            int[] tempArray;
            tempArray = array;

            array = new int[++size];

            for(int i = 0; i < array.length - 1; i++) {
                array[i] = tempArray[i];
            }
        } else {
            array = new int[++size];
        }
    }

    public void remove(int index) {
        if(index >= 0 && index < size) {
            int[] tempArray = new int[--size];

            for(int i = 0; i < size; i++) {
                if(i < index) {
                    tempArray[i] = array[i];
                } else {
                    tempArray[i] = array[i + 1];
                }
            }

            array = new int[size];
            array = tempArray;
        }
    }

    public void show() {
        System.out.println(Arrays.toString(array));
    }
}
