package StepTracker;

public class Convert {

    //Внутренний класс класса StepTracker
    public double distanceSteps(int amountSteps) {

        //Метод для подсчета пройденной дистанции (в км)
        double sumSteps = amountSteps;
        double distanceSteps = sumSteps * 75 / 100000;//в 1 км=100 тыс см
        return distanceSteps;
    }

    public double caloriesSteps(int amountSteps) {
        double caloriesSteps = 0;
        //Метод для подсчета количества сожжённых килокалорий
        double sumStepsDouble = amountSteps;
        caloriesSteps= sumStepsDouble * 50 / 1000;
        return caloriesSteps;
    }
}
