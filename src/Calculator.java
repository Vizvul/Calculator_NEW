import java.sql.SQLOutput;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws ScannerExcpection {

        Scanner calc1 = new Scanner(System.in);
        String calc2 = calc1.nextLine();
        String final1 = calc(calc2);
        System.out.println(final1);
    }

    public static String calc (String input) throws ScannerExcpection {
        String resultFinel = "";
        int pervoeArab = 11;
        boolean pervoeArabBln = false;
        int pervoeRim = 11;
        boolean pervoeRimBln = false;

        int vtoroeArab = 11;
        boolean vtoroeArabBln = false;
        int vtoroeRim = 11;
        boolean vtoroeRimBln = false;

        int mathSinght = 11;
        boolean mathSinghtBln = false;

        int result;
        String resultString;

        String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "IIX", "IX", "X"};
        String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] mathMatic = {"+", "-", "*", "/"};

        String[] calculate = input.split(" ", 3);

        // проверям первое число арабское
        for (int j = 0; j < 10; j++) {
            if (calculate[0].equals(arab[j])) {
                pervoeArab = ++j;
                pervoeArabBln = true;
                }
            }

            // проверяем первое число римское
            for (int j = 0; j < 10; j++) {
                if (calculate[0].equals(rim[j])) {
                    pervoeRim = ++j;
                    pervoeRimBln = true;
                }

            }

            // проверям второе число арабское и римское
            for (int j = 0; j < 10; j++) {
                if (calculate[2].equals(arab[j])) {
                    vtoroeArab = ++j;
                    vtoroeArabBln = true;
                }
            }

            // проверяем второе число римское
            for (int j = 0; j < 10; j++) {
                if (calculate[2].equals(rim[j])) {
                    vtoroeRim = ++j;
                    vtoroeRimBln = true;
                }
            }

            // проверяем математические выражения
            for (int j = 0; j < 4; j++) {
                if (calculate[1].equals(mathMatic[j])) {
                    mathSinght = ++j;
                    mathSinghtBln = true;
                }
            }

            // Блок проверки значений
            if ((pervoeArabBln != vtoroeArabBln) && (pervoeRimBln != vtoroeRimBln)) {
                throw new ScannerExcpection("Неверно введены параметры - оба числа должны быть или арабскими или римскими");
            }
            if ((pervoeArabBln == pervoeRimBln) && (vtoroeArabBln == vtoroeRimBln)) {
                throw new ScannerExcpection("Вы ввели что то не понятное, программа принимает арифмитическое выражение из арабских или римских цифр");
            }
            if (pervoeArabBln == pervoeRimBln){
                throw new ScannerExcpection("Неверные первое значения - арабские или риские цифры только от 1-10");
            }
            if (vtoroeArabBln == vtoroeRimBln){
            throw new ScannerExcpection("Неверные второе значения - арабские или риские цифры только от 1-10");
            }
            if (mathSinghtBln == false) {
                throw new ScannerExcpection("Неверный математический знак");
            }

            // ищем ответ для арабских цифр
            if (pervoeArabBln && vtoroeArabBln && mathSinghtBln) {
                if (mathSinght == 1) {
                    result = pervoeArab + vtoroeArab;
                } else if (mathSinght == 2) {
                    result = pervoeArab - vtoroeArab;
                } else if (mathSinght == 3) {
                    result = pervoeArab * vtoroeArab;
                } else {
                    result = pervoeArab / vtoroeArab;
                }
                resultFinel = "" + result;
            }

            // ищем ответ для римских цифр
            if (pervoeRimBln && vtoroeRimBln && mathSinghtBln) {
                if (mathSinght == 1) {
                    result = pervoeRim + vtoroeRim;
                } else if (mathSinght == 2) {
                    result = pervoeRim - vtoroeRim;
                } else if (mathSinght == 3) {
                    result = pervoeRim * vtoroeRim;
                } else {
                    result = pervoeRim / vtoroeRim;
                }

                if (result <= 0) {
                    throw new ScannerExcpection("Отрицательное значение для римских цифр или значение меньше единицы");
                }

                // Ищем десятки в числе и приводим их к виду римских цифр
                if (result > 0) {
                    int desyatki = result / 10;
                    String resultRim1 = "";
                    String[] obratnoDesyatki = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
                    for (int i = 1; i < 11; i++) {
                        if (desyatki == i) {
                            resultRim1 = obratnoDesyatki[i - 1];
                        }
                    }
                    String resultRim2 = "";
                    int edinitsi = result - (desyatki * 10);
                    for (int i = 1; i < 11; i++) {
                        if (edinitsi == i) {
                            resultRim2 = rim[i - 1];
                        }
                    }
                    resultFinel = resultRim1 + resultRim2;
                }
            }
            return resultFinel;
        }
}


