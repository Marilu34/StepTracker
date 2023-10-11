package StepTracker;


import java.util.Scanner;

public class StepTracker {

    Convert convert = new Convert();

//1.данные о ш-кажд дн.12 меc по 30 дн.
//указать №мес, №дн и кол-во ш(>=0),если невведен кол-во ш/дн,то 0.
//2.подсчет,вывод ш/мес. goal-10К ш/дн.Кол-во ш/дн:1 день: 3000, 2 день: 2000, ..., 30 день: 10000
//Общее кол-во ш/мес;Max кол-во ш/мес;Ср.кол-во ш;дистанция (в км);Кол-во сож.КИЛОккал;
//Лучшая серия: Max кол-во подряд дн,где кол-во ш/дн >= цели
// можно изменить цель (>=0)

    int goalSteps = 10000;

    MonthData[] monthToData;


    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    //сохраняем шаги за день
    public void saveSteps() {
        System.out.println("Введите название месяца: ");
        System.out.println(" 1-ЯНВ, 2-ФЕВ, 3-МАР, 4-АПР, 5-МАЙ, 6-ИЮН, 7-ИЮЛ, 8-АВГ, 9-СЕН, 10-ОКТ, 11-НОЯ, 12_ДЕК");
        System.out.println("нажмите \"Enter\" ");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Введен не правильный номер месяца");
        } else {
            System.out.println("Введите день: от 1 до 30 и нажмите \"Enter\"");
            int day = scanner.nextInt();
            if (day < 1 || day > 30) {
                System.out.println("Введен не правильный день месяца");
            }
            System.out.println("Введите кол-во шагов и нажмите \"Enter\"");
            int steps = scanner.nextInt();
            if (steps < 0) {
                System.out.println("Введите положительное число");
            } else {
//сохраняем шаги за день
                if (steps < 0) {
                    System.out.println("Введите положительное число.");
                } else {
                    monthToData[month - 1].days[day - 1] = steps;
//            monthToData[month - 1][day -1] - потому что месяц и день передают в метод начиная с 1,
//            а в массиве индексация с 0, поэтому, чтобы достать первый элемент нужно
//            сделать month значением 0, то есть month-1 и day-1.
                    System.out.println(steps + " шагов сохранено в " + day + "й день " + month + "го месяца");
                }
            }
        }
    }


    public int amountSteps(int month) {
        //Общее количество шагов за месяц
        int amountSteps = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            amountSteps = amountSteps + monthToData[month - 1].days[i];
        }
        return amountSteps;
    }

    public void goalSteps() {
        System.out.println("Введите новую цель:");
        Scanner scanner = new Scanner(System.in);
        int newGoalSteps = scanner.nextInt();
        //Изменить цель
        if (newGoalSteps < 0) {
            System.out.println("Введите положительное число.");
        } else {
            goalSteps = newGoalSteps;
            System.out.println("Новая цель по количеству шагов в день: " + goalSteps + " шагов");
        }
    }

    //
    public int bestPeriodSteps(int month) {
        //Лучшая серия
        int period = 0;
        int maxPeriod = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            if (monthToData[month - 1].days[i] >= goalSteps) {
                period = period + 1;
                if (period > maxPeriod) {
                    maxPeriod = period;
                }
            } else {
                period = 0;
            }
        }
        return maxPeriod;

    }

    public double midSteps(int month) {
        //Среднее количество шагов
        double sumSteps = amountSteps(month);
        double monthToDataHalf = monthToData[month - 1].days.length;
        return sumSteps / monthToDataHalf;
    }

    public int maxSteps(int month) {
        //максимальное пройденное количество шагов в месяце
        int maxSteps = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            if (monthToData[month - 1].days[i] > maxSteps) {
                maxSteps = monthToData[month - 1].days[i];
            }
        }
        return maxSteps;
    }

    public void totalSteps(int month) {
        //Количество пройденных шагов по дням в следующем формате:
        //1 день: 3000, 2 день: 2000, ..., 30 день: 10000
        int totalAmountSteps = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            totalAmountSteps = totalAmountSteps + monthToData[month].days[i];
            System.out.print((i + 1) + " день: " + monthToData[month - 1].days[i] + ", ");
        }
        System.out.print(monthToData[month - 1].days.length + " день: " +
                monthToData[month - 1].days[monthToData[month - 1].days.length - 1] + "\n\n");
    }

    public void printStatistic() {
        System.out.println("Введите название месяца: ");
        System.out.println(" 1-ЯНВ, 2-ФЕВ, 3-МАР, 4-АПР, 5-МАЙ, 6-ИЮН");
        System.out.println("7-ИЮЛ, 8-АВГ, 9-СЕН, 10-ОКТ, 11-НОЯ, 12_ДЕК");
        System.out.println("нажмите \"Enter\" ");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Введен не правильный номер месяца");
        } else {
            System.out.println("Количество пройденных шагов по дням за месяц " + month);
//количество пройденных шагов по дням за месяц
            totalSteps(month);
//общее количество шагов за месяц
            System.out.println("За месяц " + month + " вы прошли " + amountSteps(month) + " шагов.");
//максимальное количество шагов в месяце
            System.out.println("За месяц " + month + " вы прошли максимальное количество шагов " + maxSteps(month));

//среднее количество шагов
            System.out.println("За месяц " + month + " вы прошли среднее количество шагов " + midSteps(month));
//дистанция (в км)
            System.out.println("За месяц " + month + " вы прошли " + convert.distanceSteps(amountSteps(month))+ " км");
//сожжённые ккал
            System.out.println("За месяц " + month + " вы сожгли " + convert.caloriesSteps(amountSteps(month)) + " ккал");
//лучшая серия: макс кол-во подряд идущих дней, где кол-во шагов за день >= цели
            System.out.println("Лучшая серия: максимальное количество подряд идущих дней," +
                    "\nв течение которых количество шагов за день было равно или выше целевого: " +
                    bestPeriodSteps(month) +
                    " подряд");
        }
    }

    class MonthData {
        int[] days = new int[30];
    }
}

