import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        
        return calculateRound(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return calculateRound(amount + amount * yearRate * depositPeriod, 2);
    }

    double calculateRound(double value, int places) { // "round" - это глагол "округлять". На 17 строке есть такой метод
        double amount = Math.pow(10, places);

        return Math.round(value * amount) / amount;
    }

    void calculateDepositInterest  () { // лишние пробелы перед параметрами метода. Можно юзать горячие клавиши для: Ctrl + Alt + L
        int depositPeriod;
        int action;
        int amount;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
// лишняя пустая строка
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
// лишняя пустая строка
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double totalAmount = 0; // можно переместить выше на 25 строку, к остальным объявлениям

        if (action == 1) {
            totalAmount = calculateSimplePercent(amount, 0.06, depositPeriod); 
        } else if (action == 2) {
            totalAmount = calculateComplexPercent(amount, 0.06, depositPeriod);
        }
// лишняя пустая строка
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + totalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositInterest (); // лишний пробел перед скобками метода
    }
}
