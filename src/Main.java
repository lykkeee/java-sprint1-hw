import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        while (true) {
            console();
            int command = scanner.nextInt();
            if (command == 1) {
                while (true) {
                    System.out.println("Введите порядковый номер месяца(0 - Январь, 1 - Февраль и т.д.):");
                    int month = scanner.nextInt();
                    if (month >= 0 & month <= 11) {
                        while (true) {
                            System.out.println("Введите день месяца(От 1 до 30):");
                            int day = scanner.nextInt();
                            if (day >= 1 & day <= 30) {
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
                                break;
                            } else {
                                System.out.println("Необходимо значение от 1 до 30");
                            }
                        }
                        break;
                    } else {
                        System.out.println("Необходимо значение от 0 до 11");
                    }
                }
            } else if (command == 2) {
                while (true) {
                    System.out.println("Введите порядковый номер месяца(0 - Январь, 1 - Февраль и т.д.):");
                    int month = scanner.nextInt();
                    if (month >= 0 & month <= 11) {
                        System.out.println("Статистика за месяц:");
                        stepTracker.statistics(month);
                        break;
                    } else {
                        System.out.println("Необходимо значение от 0 до 11");
                    }
                }
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