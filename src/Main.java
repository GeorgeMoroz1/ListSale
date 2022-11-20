import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final static List<String> productList = new ArrayList<>();

    public static void add(Scanner scanner) {
        System.out.println("Какую покупку хотите добавить?");
        String inputProduct;
        inputProduct = scanner.nextLine();
        productList.add(inputProduct);
        System.out.println("Итого в списке покупок: " + productList.size());
    }

    public static void showList() {
        System.out.println("Список покупок:");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(((i + 1) + ". " + productList.get(i)));
        }
        if (productList.size() == 0) {
            System.out.println("Список пуст");
        }
    }

    public static void remove(Scanner scanner) {
        System.out.println("Какую покупку хотите удалить? Введите номер или название.");
        String deleteProduct = scanner.nextLine();
        try {
            int number = Integer.parseInt(deleteProduct);
            System.out.println("Покупка " + productList.get(number - 1) + " удалена, список покупок:");
            productList.remove(number - 1);
        } catch (NumberFormatException e) {
            productList.remove(deleteProduct);
            System.out.println("Покупка " + deleteProduct + " удалена, список покупок:");
        }
        showList();
    }

    public static void find(Scanner scanner) {
        System.out.println("Введите текст для поиска:");
        String findProduct = scanner.nextLine();
        System.out.println("Найдено:");
        for (int i = 0; i < productList.size(); i++) {
            String queryLower = findProduct.toLowerCase();
            String itemLower = productList.get(i).toLowerCase();
            if (itemLower.contains(queryLower)) {
                System.out.println(((i + 1) + ". " + productList.get(i)));
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Выберите операцию и введите соответствующий номер или введите end:");
            System.out.println("1. Добавить покупку.");
            System.out.println("2. Показать покупки.");
            System.out.println("3. Удалить покупку.");
            System.out.println("4. Поиск по покупкам.");
            Scanner scanner = new Scanner(System.in);
            String inputNumber = scanner.nextLine();
            if ("end".equals(inputNumber)) {
                break;
            }
            switch (inputNumber) {
                case ("1"):
                    add(scanner);
                    break;
                case ("2"):
                    showList();
                    break;
                case ("3"):
                    remove(scanner);
                    break;
                case ("4"):
                    find(scanner);
                    break;
                default:
                    System.out.println("Такой операции нет!");
            }
        }
    }
}
