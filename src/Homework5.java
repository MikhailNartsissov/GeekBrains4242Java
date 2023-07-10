//Задание
//
//        Реализуйте структуру телефонной книги с помощью HashMap.
//        Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
//        их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию
//        числа телефонов.


import java.util.*;

public class Homework5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayList<String>> phonebook = new HashMap<>();
        ArrayList<String> phones = new ArrayList<>();

        boolean readnext = true;
        boolean addnew;

        while (readnext) {
            System.out.println("\nВвод данных контакта\n************************");
            System.out.print("Имя: ");
            String firstname = scanner.nextLine().strip().toUpperCase();
            System.out.print("Отчество: ");
            String middlename = scanner.nextLine().strip().toUpperCase();
            System.out.print("Фамилия: ");
            String lastname = scanner.nextLine().strip().toUpperCase();
            String name = lastname + " " + firstname + " " + middlename;
            addnew = true;
            while (addnew) {
                System.out.print("Номер телефона: ");
                phones.add(scanner.nextLine().strip());
                System.out.print("Ввести ещё один номер телефона (д/н) или (y/n)? ");
                String choice = scanner.nextLine().strip().toUpperCase();
                if (!Objects.equals(choice, "Y") &&
                        !Objects.equals(choice, "Д")) addnew = false;
            }
            phonebook.put(name, phones);
            System.out.println("\nВнесены следующие данные: ");
            System.out.println(
                    "**************\n" +
                            "Ф.И.О: " + name + "\n"
                            + "Список телефонов: "
                            + phonebook.get(name)
                            + "\n**************");
            phones = new ArrayList<>();
            System.out.print("\nВвести данные следующего контакта (д/н) или (y/n)? ");
            String choice = scanner.nextLine().strip().toUpperCase();
            if (!Objects.equals(choice, "Y") &&
                    !Objects.equals(choice, "Д")) readnext = false;
        }
        System.out.println(
                """

                        Текущий телефонный справочник (отсортирован по убыванию числа телефонов у контакта):
                        ******************************""");
        phonebook.
                entrySet().
                stream().
                sorted(Map.Entry.comparingByValue((o1, o2) -> o2.size() - o1.size())).
                forEach(System.out::println);
    }
}
