package Step;


public class StepTracker {

//1.данные о ш-кажд дн.12 меc по 30 дн.
//указать №мес, №дн и кол-во ш(>=0),если невведен кол-во ш/дн,то 0.
//2.подсчет,вывод ш/мес. goal-10К ш/дн.Кол-во ш/дн:1 день: 3000, 2 день: 2000, ..., 30 день: 10000
//Общее кол-во ш/мес;Max кол-во ш/мес;Ср.кол-во ш;дистанция (в км);Кол-во сож.КИЛОккал;
//Лучшая серия: Max кол-во подряд дн,где кол-во ш/дн >= цели
// можно изменить цель (>=0)

    int goalSteps = 10000;

    int[][] monthToData = new int[12][30];
//    public StepTracker() {
//        MonthData[]  monthToData = new MonthData[12];
//            for (int i = 0; i < monthToData.length; i++) {

//                    System.out.println(monthToData[i]);
//                }
//            }

    //сохраняем шаги за день
    public void saveSteps(int month, int day, int steps) {
        if (steps < 0) {
            System.out.println("Введите положительное число.");
        } else {
            monthToData[month - 1][day - 1] = monthToData[month - 1][day - 1] + steps;
//            monthToData[month - 1][day -1] - потому что месяц и день передают в метод начиная с 1,
//            а в массиве индексация с 0, поэтому, чтобы достать первый элемент нужно
//            сделать month значением 0, то есть month-1 и day-1.
            System.out.println(steps + " шагов сохранено в " + day + "й день " + month + "го месяца");
        }
    }

    public int amountSteps(int month) {
        //Общее количество шагов за месяц
        int amountSteps = 0;
        for (int i = 0; i < monthToData[month - 1].length; i++) {
            amountSteps = amountSteps + monthToData[month - 1][i];
        }
        return amountSteps;
    }
    public void goalSteps(int newGoalSteps) {
        //Изменить цель
        if (newGoalSteps < 0) {
            System.out.println("Введите положительное число.");
        } else {
            int goalSteps = newGoalSteps;
            System.out.println("Новая цель по количеству шагов в день: " + goalSteps + " шагов");
        }
    }
    //
    public int bestPeriodSteps(int month) {
        //Лучшая серия
        int period=1;
        int maxPeriod = 0;
        for (int i = 1; i < monthToData[month - 1].length; i++) {
            if (monthToData[month - 1][i] >= goalSteps)  {
                period = period + 1;
                if (period > maxPeriod) {
                    maxPeriod = period;
                }
            } else {
                period = 1;
            }
        }
        return maxPeriod;
    }
    public double midSteps(int month) {
        //Среднее количество шагов
        double sumSteps = amountSteps(month);
        double monthToDataHalf = monthToData[month - 1].length;
        return sumSteps / monthToDataHalf;
    }

    public int maxSteps(int month) {
        //максимальное пройденное количество шагов в месяце
        int maxSteps = 0;
        for (int i = 0; i < monthToData[month - 1].length; i++) {
            if (monthToData[month - 1][i] > maxSteps) {
                maxSteps = monthToData[month - 1][i];
            }
        }
        return maxSteps;
    }
    public void totalSteps(int month) {
        //Количество пройденных шагов по дням в следующем формате:
        //1 день: 3000, 2 день: 2000, ..., 30 день: 10000
        for (int i = 0; i < monthToData[month - 1].length - 1; i++) {
//            length - 1 по тем же причинам. lentgh выдаст значение 12,
//            однако счет начинается с 0, а не с 1, поэтому будем считать до 11, а не до 12.
            System.out.print((i + 1) + " день: " + monthToData[month - 1][i] + ", ");
        }
        System.out.print(monthToData[month - 1].length + " день: " + monthToData[month - 1][monthToData[month - 1].length - 1] + "\n\n");
    }
    //    тк двумерный массив, то в первых скобках месяц, а во вторых день.  месяц с переменной month - месяца в реальной жизни
//    начинаются с 1, а массивы в программировании с 0, поэтому делаем month - 1, чтобы первый месяц был с индексом 0.  i - это день в месяце month,
//    мы проходим по всем дням в конкретном месяце и выбираем максимальное число
    public  class Convert {

        //Внутренний класс класса StepTracker
        public double distanceSteps(int month) {

            //Метод для подсчета пройденной дистанции (в км)
            double sumSteps = amountSteps(month);
            return sumSteps * 75 / 100000;//в 1 км=100 тыс см
        }

        public double caloriesSteps(int month) {
            //Метод для подсчета количества сожжённых килокалорий
            double sumStepsDouble = amountSteps(month);
            return sumStepsDouble * 50 / 1000;
        }
    }
//        class MonthData {
////        Заполните класс самостоятельно
//        }
}

