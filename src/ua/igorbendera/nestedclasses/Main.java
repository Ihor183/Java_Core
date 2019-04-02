package ua.igorbendera.nestedclasses;

public class Main {
    public static void main(String[] args) {
        Number[] array = {1, -4, 3, 32, -12, 26, 72, -11, 45, 7, 21, -17};
        Collection collection = new Collection(array);

        System.out.println("Заміна непарних елементів на 0");
        Iterator iteratorForward = collection.createForward();
        while(iteratorForward.hasNext()) {
            Number next = (Number)iteratorForward.next();

            if(next.intValue() % 2 != 0) {
                next = 0;
            }

            System.out.print(next + " ");
        }

        System.out.println("\n\nВивести елементи масиву з кінця через один");
        Iterator iteratorBackward = collection.createBackward();
        int i = 1;
        while(iteratorBackward.hasNext()) {
            Number next = (Number)iteratorBackward.next();
            if(i % 2 != 0) {
                System.out.print(next + " ");
            }

            i++;
        }

        System.out.println("\n\nВивести з кінця кожен третій елемент якщо він непарний");
        i = 1;
        Iterator iteratorAnonymousClass = collection.AnonymousClass();
        while(iteratorAnonymousClass.hasNext()) {
            Number next = (Number)iteratorAnonymousClass.next();
            if(i % 3 == 0 && next.intValue() % 2 != 0) {
                System.out.print(next + " ");
            }

            i++;
        }

        System.out.println("\n\nЯкщо елемент, порядковий номер якого кратний 5 є парний, то відняти 100");
        i = 1;
        Iterator iteratorLocalClass = collection.LocalClass();
        while(iteratorLocalClass.hasNext()) {
            Number next = (Number)iteratorLocalClass.next();
            if(i % 5 == 0 && next.intValue() % 2 == 0) {
                System.out.print((next.intValue() - 100) + " ");
            }

            i++;
        }

        System.out.println("\n\nЗробити кожен другий елемент непарним");
        i = 1;
        Iterator iteratorStaticClass = Collection.createStaticClass();
        while(iteratorStaticClass.hasNext()) {
            Integer next = (Integer) iteratorStaticClass.next();
            if(i % 2 == 0 && next % 2 == 0) {
                next++;
            }

            i++;
            System.out.print(next + " ");
        }
    }
}
