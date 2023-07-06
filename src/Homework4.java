//Урок 4. Хранение и обработка данных ч1: приоритетные коллекции
//        Организовать ввод и хранение данных пользователей. ФИО возраст, пол и выход из режима ввода информации
//        вывод в формате Фамилия И.О. возраст пол
//        добавить возможность выхода или вывода списка отсортированного по возрасту!)
//        *реализовать сортировку по возрасту с использованием индексов
//        *реализовать сортировку по возрасту и полу с использованием индексов

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Homework4 {
    public static void showPerson(String firstname, String middlename, String lastname, Integer age, Boolean sex){
        System.out.print("\n" + lastname + " " +
                firstname.charAt(0) + '.' +
                middlename.charAt(0) + ". " +
                age + " ");
        if (sex) System.out.print("М");
        else System.out.print("Ж");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList <String> firstname = new ArrayList<>();
        ArrayList <String> middlename = new ArrayList<>();
        ArrayList <String> lastname = new ArrayList<>();
        ArrayList <Integer> age = new ArrayList<>();
        ArrayList <Boolean> sex = new ArrayList<>();
        ArrayList <Integer> index = new ArrayList<>();
        int hash = 0;

        boolean readnext = true;

        while (readnext) {
            System.out.println("\nВвод персональных данных\n************************");
            System.out.println("Имя: ");
            firstname.add(scanner.nextLine().strip().toUpperCase());
            System.out.println("Отчество: ");
            middlename.add(scanner.nextLine().strip().toUpperCase());
            System.out.println("Фамилияя: ");
            lastname.add(scanner.nextLine().strip().toUpperCase());
            System.out.println("Возраст (количество полных лет): ");
            age.add(Integer.valueOf(scanner.nextLine()));
            System.out.println("Пол: ");
            sex.add(scanner.nextLine().strip().equalsIgnoreCase("М"));
            index.add(hash);
            System.out.println("Внесены следующие данные: ");
            showPerson(firstname.get(hash), middlename.get(hash), lastname.get(hash),age.get(hash), sex.get(hash));
            hash++;
            System.out.println("\n*************************\n\nВвести данные следующего человека (д/н) или (y/n)? ");
            String choice = scanner.nextLine().strip().toUpperCase();
            if (!Objects.equals(choice, "Y") &&
                        !Objects.equals(choice, "Д")) readnext = false;
        }
        System.out.println("\nСписок после ввода:\n******************************");
        for (Integer id : index
        ) {
            showPerson(firstname.get(id), middlename.get(id), lastname.get(id),age.get(id), sex.get(id));
        }
        System.out.println("\n******************************\n");
        index.sort((o1, o2) -> age.get(o1) - age.get(o2));
        System.out.println("\nРезультат сортировки по возрасту:\n******************************");
        for (Integer id : index
             ) {
            showPerson(firstname.get(id), middlename.get(id), lastname.get(id),age.get(id), sex.get(id));
        }
        System.out.println("\n******************************\n");
        index.sort((o1, o2) -> age.get(o1) - age.get(o2) + sex.get(o1).compareTo(sex.get(o2)));
        System.out.println("\nРезультат сортировки по возрасту и полу:\n******************************");
        for (Integer id : index
        ) {
            showPerson(firstname.get(id), middlename.get(id), lastname.get(id),age.get(id), sex.get(id));
        }
        System.out.println("\n******************************\n");
    }
}
