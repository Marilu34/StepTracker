package Step;

import Step.StepTracker;

import java.util.Scanner;

//программа должна позволять пользователю ввести следующее действие(цикл)
//несущ действие-выводится ошибка и предложение снова ввести дейтствие(цикл)
//Ввести количество шагов за определённый день;
//Напечатать статистику за определённый месяц;
//Изменить цель по количеству шагов в день;
//Выйти из приложения.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        StepTracker.Convert convert = stepTracker.new Convert();
        System.out.println("Программа запущена");
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
//            int month = 0;
            if (userInput == 1) {
                System.out.println("Введите название месяца: ");
                System.out.println(" 1-ЯНВ, 2-ФЕВ, 3-МАР, 4-АПР, 5-МАЙ, 6-ИЮН");
                System.out.println("7-ИЮЛ, 8-АВГ, 9-СЕН, 10-ОКТ, 11-НОЯ, 12_ДЕК");
                System.out.println("нажмите \"Enter\" ");
                int month = scanner.nextInt();
                if (month < 1 || month > 12) {
                    System.out.println("Введен не правильный номер месяца");
                } else {
                    System.out.println("Введите день: от 1 до 30 и нажмите \"Enter\"");
                    int day = scanner.nextInt();
                    if (day < 1 || day > 30) {
                        System.out.println("Введен не правильный день месяца");
                    } else {
                        System.out.println("Введите кол-во шагов и нажмите \"Enter\"");
                        int steps = scanner.nextInt();
                        if (steps <= 0) {
                            System.out.println("Введите положительное число");
                        } else {
//сохраняем шаги за день
                            stepTracker.saveSteps(month, day, steps);
                        }
                    }
                }

            } else if (userInput == 2) {
                System.out.println("Введите название месяца: ");
                System.out.println(" 1-ЯНВ, 2-ФЕВ, 3-МАР, 4-АПР, 5-МАЙ, 6-ИЮН");
                System.out.println("7-ИЮЛ, 8-АВГ, 9-СЕН, 10-ОКТ, 11-НОЯ, 12_ДЕК");
                System.out.println("нажмите \"Enter\" ");
                int month = scanner.nextInt();
                if (month < 1 || month > 12) {
                    System.out.println("Введен не правильный номер месяца");
                } else {
                    System.out.println("Количество пройденных шагов по дням за месяц " + month);
//количество пройденных шагов по дням за месяц
                    stepTracker.totalSteps(month);
//общее количество шагов за месяц
                    System.out.println("За месяц " + month + " вы прошли " + stepTracker.amountSteps(month) + " шагов.");
//максимальное количество шагов в месяце
                    System.out.println("За месяц " + month + " вы прошли максимальное количество шагов " + stepTracker.maxSteps(month));

//среднее количество шагов
                    System.out.println("За месяц " + month + " вы прошли среднее количество шагов " + stepTracker.midSteps(month));
//дистанция (в км)
                    System.out.println("За месяц " + month + " вы прошли " + convert.distanceSteps(month) + " км");
//сожжённые ккал
                    System.out.println("За месяц " + month + "вы сожгли " + convert.caloriesSteps(month) + " ккал");
//лучшая серия: макс кол-во подряд идущих дней, где кол-во шагов за день >= цели
                    System.out.println("Лучшая серия: максимальное количество подряд идущих дней," +
                            "\nв течение которых количество шагов за день было равно или выше целевого: " +
                            stepTracker.bestPeriodSteps(month) +
                            " подряд");
                }
            } else if (userInput == 3) {
                System.out.println("Введите новую цель:");
                int newGoalSteps = scanner.nextInt();
                stepTracker.goalSteps(newGoalSteps); //Метод для изменения целевого количества шагов

            } else if (userInput == 0) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Вы ввели неправильное число. Повторите попытку ");
            }


            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }


    }


    //* Ввод пройденного количества шагов за день;
    public static void printMenu() {
        System.out.println("Выберите из меню: ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}
