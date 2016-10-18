package imkn.exercise;


import java.util.*;

/**
 * 1. добавить "reversed mode"
 * 2. реализовать действия через листенеры
 * 3. избавиться от if'ов
 * 4. вынести логику обработки консоли в отдельный класс
 */
public class Exercise {

    private static List<String> strings = new ArrayList<>();

    private static final String SIMPLE_MODE = "simple";
    private static final String STORE_MODE = "store";

    private static final String MODE_ADD = "mode add:";
    private static final String MODE_RM = "mode rm:";

    private static Set<String> activeModes = new HashSet<>();
    static {
        activeModes.add(SIMPLE_MODE);
        activeModes.add(STORE_MODE);
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        String str = "";
        while (!str.equals("exit")) {
            str = scanner.nextLine();

            if (str.startsWith(MODE_ADD)) {
                activeModes.add(str.substring(MODE_ADD.length()));
            } else if (str.startsWith(MODE_RM)) {
                activeModes.remove(str.substring(MODE_RM.length()));
            } else {

                if (activeModes.contains(SIMPLE_MODE)) {
                    System.out.println(str);
                }

                if (activeModes.contains(STORE_MODE)) {
                    strings.add(str);
                    System.out.println("Введено строк: " + strings.size());
                }
            }
        }

    }

}
