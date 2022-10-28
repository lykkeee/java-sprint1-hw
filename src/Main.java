import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        while (true) {
            console();
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Введите порядковый номер месяца(0 - Январь, 1 - Февраль и т.д.):");
                int month = scanner.nextInt();
                System.out.println("Введите день месяца(От 0 до 29):");
                int day = scanner.nextInt();
                while (true) {
                    System.out.println("Введите количество шагов:");
                    int stepsQuantity = scanner.nextInt();
                    if (stepsQuantity >= 0) {
                        stepTracker.saveStepsQuantity(month, day, stepsQuantity);
                        System.out.println("Изменения сохранены");
                        break;
                    } else {
                        System.out.println("Необходимо положительнео значение");
                    }
                }
            } else if (command == 2) {
                System.out.println("Введите порядковый номер месяца(0 - Январь, 1 - Февраль и т.д.):");
                int month = scanner.nextInt();
                System.out.println("Статистика за месяц:");
                stepTracker.statistics(month);
            } else if (command == 3) {
                while (true) {
                    System.out.println("Введите новую цель:");
                    int goal = scanner.nextInt();
                    if (goal >= 0) {
                        stepTracker.setStepsGoal(goal);
                        break;
                    } else {
                        System.out.println("Необходимо положительное значение");
                    }
                }
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Такой команды не существует");
            }
        }
    }
    public static void console() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Ввести количество шагов");
        System.out.println("2 - Статистика за месяц");
        System.out.println("3 - Изменить цель по количеству шагов");
        System.out.println("0 - Выход");
    }
}