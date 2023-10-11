package StepTracker;

import java.util.Scanner;

//программа должна позволять пользователю ввести следующее действие(цикл)
//несущ действие-выводится ошибка и предложение снова ввести дейтствие(цикл)
//Ввести количество шагов за определённый день;
//Напечатать статистику за определённый месяц;
//Изменить цель по количеству шагов в день;
//Выйти из приложения.
public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        System.out.println("Программа запущена");
        printMenu();
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                stepTracker.saveSteps();
            } else if (userInput == 2) {
                stepTracker.printStatistic();
            } else if (userInput == 3) {
                stepTracker.goalSteps(); //Метод для изменения целевого количества шагов
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
