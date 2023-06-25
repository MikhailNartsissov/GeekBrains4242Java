//Первый семинар.
//        1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//        2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//        3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//        4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//
//        Пункты реализовать в методе main
//        *Пункты реализовать в разных методах


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int getRandom(int maxValue){
        return new Random().nextInt(maxValue);
    }

    public static int getHighestBit(int value){
        return Integer.toBinaryString(value).length() - 1;
    }

    public static Integer [] getMultiples(int startValue, int numberToFindMultiples){
        var list = new ArrayList<Integer>();
        for (int counter = startValue; counter < Short.MAX_VALUE; counter++){
            if (counter % numberToFindMultiples == 0) list.add(counter);
        }
        Integer [] result = new Integer[list.size()];
        return list.toArray(result);
    }

    public static Integer [] getUnMultiples(int endValue, int numberToFindMultiples){
        var ulist = new ArrayList<Integer>();
        for (int counter = Short.MIN_VALUE; counter < endValue; counter++){
            if (counter % numberToFindMultiples != 0) ulist.add(counter);
        }
        Integer [] result = new Integer[ulist.size()];
        return ulist.toArray(result);
    }

    public static void main(String[] args) {
        int i = getRandom(2000);
        int n = getHighestBit(i);
        Integer [] m1 = getMultiples(i, n);
        Integer [] m2 = getUnMultiples(i, n);
        System.out.println("Случайное число: " +  i  + "\nНомер старшего значащего бита числа: " +
                n + "\nМассив кратных n чисел в диапазоне от i до Short.MAX_VALUE: \n" + Arrays.toString(m1)
                );
        Scanner user_input = new Scanner(System.in);
        String choice;
        System.out.println("Хотите вывести на экран все некратные n " +
                "числа в диапазоне от Short.MIN_VALUE до i (д/н)?: ");
        choice = user_input.next();
        if (choice.strip().equalsIgnoreCase("д") || choice.strip().equalsIgnoreCase("Y"))
            System.out.println("\nМассив некратных n чисел в диапазоне от Short.MIN_VALUE до i: \n" +
                    Arrays.toString(m2));
        }
}
