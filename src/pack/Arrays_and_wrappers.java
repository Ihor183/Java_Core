package pack;

public class Arrays_and_wrappers {

    public static void main(String[] args) {

        Byte b = 1;
        Short s = 2;
        Integer i = 3;
        Long l = 4L;

        Float f = 5.5F;
        Double d = 123.123;

        Boolean bool = false;

        Character c = 'c';

        System.out.println(Byte.MIN_VALUE + " Byte " + Byte.MAX_VALUE);
        System.out.println(Short.MIN_VALUE + " Short " + Short.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE + " Integer " + Integer.MAX_VALUE);
        System.out.println(Long.MIN_VALUE + " Long " + Long.MAX_VALUE);
        System.out.println(Float.MIN_VALUE + " Float " + Float.MAX_VALUE);
        System.out.println(Double.MIN_VALUE + " Double " + Double.MAX_VALUE);
        System.out.println(Boolean.FALSE + " Boolean " + Boolean.TRUE);
        System.out.println((int)(Character.MIN_VALUE) + " Character " + (int)(Character.MAX_VALUE));

        int[] array = new int[10];

        for(int j = 0; j < array.length; j++) {
            array[j] = (int)(Math.random() * 100);
        }

        int min_value = array[0];
        int max_value = array[0];

        System.out.println("\n\n");

        for(int j = 1; j < array.length; j++) {
            if(min_value > array[j])
                min_value = array[j];

            if(max_value < array[j])
                max_value = array[j];

            System.out.print(array[j] + " ");
        }

        System.out.println("\nMin value = " + min_value);
        System.out.println("Max value = " + max_value);
    }

}
