//Задание
//1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
// используя StringBuilder или String. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Objects;

public class Homework2 {
    public static HashMap<String, String> getQueryParameters(String filename) throws IOException {

//      Метод читает из входного файла строки до первой непустой,
//      затем проверяет строку на наличие "[{" в начале и выставляет флаг listOfDict, если такая комбинация есть.
//      В зависимости от флага результирующий словарь заполняется по-разному (при наличии флага добавляется значение
//       счётчика в качестве ключа

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String inputString;
        boolean empty = true;
        HashMap<String, String> map =
                new HashMap<>();
        while (empty) {
            inputString = reader.readLine();
            boolean listOfDict = false;
            int index = 0;
            if (inputString != null) {
                empty = false;

                if (inputString.startsWith("[{")) {
                    listOfDict = true;
                    inputString = inputString.replace("[{", "");
                }

                // Очищаем строку от скобок

                if (inputString.endsWith("}]")) inputString = inputString.replace("}]", "");
                if (inputString.contains("{")) inputString = inputString.replace("{", "");
                if (inputString.contains("}")) inputString = inputString.replace("}", "");

                // делим на элементы

                String[] items = inputString.strip().split(",");

                for (String item : items

                ) {
                    if (listOfDict) {

                        // Если флаг установлен

                        String value = item.strip().replace(":", " ");
                        if (value.contains("фамилия"))
                            value = value.replace("фамилия", "Студент");
                        if (value.contains("оценка"))
                            value = value.replace("оценка", " получил");
                        if (value.contains("предмет"))
                            value = value.replace("предмет", " по предмету");
                        map.put(Integer.toString(index), value);
                        index ++;
                    }
                    else {

                        // Если флаг не установлен

                        String[] elements = item.strip().split(":");
                        map.put(elements[0].replace("\"", ""), elements[1]);
                    }
                }
            }
        }
        return map;
    }

    public static void main(String[] args) throws Exception {

        // Подготовка к обработке первого входного файла (Задание №1)

        PrintWriter out = new PrintWriter("./src/result.txt");
        HashMap<String, String> resultDict;
        resultDict = getQueryParameters("./src/input.json");
        StringBuilder result = new StringBuilder();
        result.append("SELECT * FROM students WHERE ");
        String value;
        int counter = 0;
        int dictSize = resultDict.size() - 1;

        // Формирование первого выходного файла (Резальтат выполнения задания №1)

        for (String key: resultDict.keySet()) {
            value = resultDict.get(key);
            counter ++;
            if (!Objects.equals(value, "\"null\"")) {
                result.append(key);
                result.append(" = ");
                result.append(value);
                if (counter != dictSize) result.append(" AND ");
            }
        }
        out.println(result);
        out.close();

        // Подготовка к обработке второго входного файла (Задание №2)

        out = new PrintWriter("./src/result1.txt");
        resultDict = getQueryParameters("./src/input2.json");
        result = new StringBuilder();
        counter = 0;
        dictSize = resultDict.size();

        // Форимирование второго выходного файла (Результат выполнения задания №2)

        for (String key: resultDict.keySet()) {
            value = resultDict.get(key);
            counter ++;
            if (!Objects.equals(value, "\"null\"")) {
                result.append(value.replace("\"", ""));
                if (value.contains("по предмету") && (counter != dictSize)) result.append("\n");
            }
        }
        out.println(result);
        out.close();
    }
}
