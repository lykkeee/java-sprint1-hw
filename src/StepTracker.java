public class StepTracker {
    int stepsGoal = 10000;
    Converter converter = new Converter();
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        int[] days = new int[30];
        public int dayData(int day) {
            return days[day];
        }
    }
    void saveStepsQuantity(int month, int day, int stepsQuantity) {
        monthToData[month].days[day - 1] = stepsQuantity;
    }


    void statistics(int month) {
        System.out.print("• Количество пройденных шагов по дням: ");
        for (int i = 0; i < 30; i++) {
            System.out.print((i + 1) + " день: " + monthToData[month].days[i] + "; ");
        }
        System.out.println();

        int stepsQuantity = 0;
        for (int i = 0; i < 30; i++) {
            stepsQuantity += monthToData[month].days[i];
        }
        System.out.println("• Общее количество шагов за месяц: " + stepsQuantity);

        int maxSteps = 0;
        for (int i = 0; i < 30; i++) {
            if (monthToData[month].days[i] > maxSteps) {
                maxSteps = monthToData[month].days[i];
            }
        }
        System.out.println("• Максимальное количество шагов за день в этом месяце: " + maxSteps);

        System.out.println("• Среднее количество шагов за месяц: " + stepsQuantity / 30);  //Здесь не понял замечания. Количество шагов делистя на количество дней и получается среднее значение в месяц.

        System.out.println("• Пройденная дистанция за месяц (в км): " + converter.convertDistance(stepsQuantity));

        System.out.println("• Количество сожженых килокалорий за месяц: " + converter.convertKkal(stepsQuantity));

        int bestSeries = 0;
        int counter = 0;
        for (int i = 0; i < 30; i++) {
            if (monthToData[month].days[i] >= stepsGoal) {
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
