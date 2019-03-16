package ua.igorbendera.myarraylist;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();

        myArrayList.add(5);
        myArrayList.add(15);
        myArrayList.add(25);
        myArrayList.add(35);
        myArrayList.add(45);
        myArrayList.add(55);
        myArrayList.add(65);
        myArrayList.add(75);
        myArrayList.add(85);
        myArrayList.add(95);

        myArrayList.show();

        myArrayList.remove(0);
        myArrayList.remove(1);
        myArrayList.remove(2);
        myArrayList.remove(3);
        myArrayList.remove(4);

        myArrayList.show();
    }
}
