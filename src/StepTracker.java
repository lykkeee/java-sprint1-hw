public class StepTracker {
    int[][] date = new int[12][30];
    int stepsGoal = 10000;
    Converter converter = new Converter();
    void saveStepsQuantity(int month, int day, int stepsQuantity) {
        date[month][day] = stepsQuantity;
    }

    void statistics(int month) {
        System.out.print("• Количество пройденных шагов по дням: ");
        for (int i = 0; i < 30; i++) {
            System.out.print((i + 1) + " день: " + date[month][i] + "; ");
        }
        System.out.println();

        int stepsQuantity = 0;
        for (int i = 0; i < 30; i++) {
            stepsQuantity += date[month][i];
        }
        System.out.println("• Общее количество шагов за месяц: " + stepsQuantity);

        int maxSteps = 0;
        for (int i = 0; i < 30; i++) {
            if (date[month][i] > maxSteps) {
                maxSteps = date[month][i];
            }
        }
        System.out.println("• Максимальное количество шагов за день в этом месяце: " + maxSteps);

        System.out.println("• Среднее количество шагов за месяц: " + stepsQuantity / 30);

        System.out.println("• Пройденная дистанция за месяц (в км): " + converter.setDistance(stepsQuantity));

        System.out.println("• Количество сожженых килокалорий за месяц: " + converter.setKkal(stepsQuantity));

        int bestSeries = 0;
        int counter = 0;
        for (int i = 0; i < 30; i++) {
            if (date[month][i] >= stepsGoal) {
                counter += 1;
                if (counter > bestSeries) {
                    bestSeries = counter;
                }
            } else {
                counter = 0;
            }
        }
        System.out.println("• Лучшая серия (дней): " + bestSeries);
    }
    void setStepsGoal(int goal) {
        stepsGoal = goal;
        System.out.println("Изменения сохранены. Новая цель: " + stepsGoal + " шагов");
    }
}
