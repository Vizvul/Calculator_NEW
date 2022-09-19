import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws ScannerExcpection {
        int pervoeArab = 11;
        boolean pervorArabBln = false;
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

        String[] rim = {"I","II","III","IV","V","VI","VII","IIX","IX","X"};
        String[] arab = {"1","2","3","4","5","6","7","8","9","10"};
        String[] mathMatic = {"+","-","*","/"};
        //for (int i = 0; i<10; i++) {
        //    System.out.println(i + " arab " + arab[i] + ", rim " + rim[i]);
        //}

        Scanner calc1 = new Scanner(System.in);
        String calc = calc1.nextLine();
        //System.out.println(calc);


        String[] calculate = calc.split(" ", 3);
        for (int j = 0; j < 3 ; j++) {
            //System.out.println(calculate[j]);
        }
        // проверям первое число арабское
        for ( int j = 0; j<10 ; j++) {
            if (calculate[0].equals(arab[j])) {
                pervoeArab = ++j;
                pervorArabBln = true;
                //System.out.println("Персовое арабское число " + pervoeArab + " а в этом время " + pervorArabBln);
            }

        }
        //System.out.println(pervorArabBln);

        // проверяем первое число римское
        for ( int j = 0; j<10 ; j++) {
            if (calculate[0].equals(rim[j])) {
                pervoeRim = ++j;
                pervoeRimBln = true;
                //System.out.println("Первое римское число " + pervoeRim + " а в этом время " + pervoeRimBln);
            }

        }
        if (pervoeRimBln == pervorArabBln) {
            throw new ScannerExcpection("Первое число введено неверно");
        }
        //System.out.println(pervoeRimBln);


// проверям второе число арабское и римское
        for ( int j = 0; j<10 ; j++) {
            if (calculate[2].equals(arab[j])) {
                vtoroeArab = ++j;
                vtoroeArabBln = true;
                //System.out.println("Второе арабское число " + vtoroeArab + " а в этом время " + vtoroeArabBln);
            }

        }
        //System.out.println(pervorArabBln);

        // проверяем второе число римское
        for ( int j = 0; j<10 ; j++) {
            if (calculate[2].equals(rim[j])) {
                vtoroeRim = ++j;
                vtoroeRimBln = true;
                //System.out.println("Второе римское число " + vtoroeRim + " а в этом время " + vtoroeRimBln);
            }

        }
        //System.out.println(vtoroeRimBln);
        if (vtoroeRimBln == vtoroeArabBln) {
            throw new ScannerExcpection("Неверное второй число");
        }

        // проверяем математические выражения
        for ( int j = 0; j<4 ; j++) {
            if (calculate[1].equals(mathMatic[j])) {
                mathSinght = ++j;
                mathSinghtBln = true;
                //System.out.println("Математический знак в " + mathSinght + " а в этом время " + mathSinghtBln);
            }

        }
        //System.out.println(mathSinghtBln);
        if (mathSinghtBln == false){
            throw new ScannerExcpection("Неверный математический знак");
        }

        // ищем ответ для арабских цифр

        if (pervorArabBln && vtoroeArabBln && mathSinghtBln) {
            if (mathSinght == 1){
                result = pervoeArab + vtoroeArab;
            } else if (mathSinght == 2) {
                result = pervoeArab - vtoroeArab;
            } else if (mathSinght == 3) {
                result = pervoeArab * vtoroeArab;
            } else {
                result = pervoeArab / vtoroeArab;
            }
            System.out.println("Ответ: " + calc + " = " + result);


        }
        // ищем ответ для римских цифр

        if (pervoeRimBln && vtoroeRimBln && mathSinghtBln) {
            if (mathSinght == 1){
                result = pervoeRim + vtoroeRim;
            } else if (mathSinght == 2) {
                result = pervoeRim - vtoroeRim;
            } else if (mathSinght == 3) {
                result = pervoeRim * vtoroeRim;
            } else {
                result = pervoeRim / vtoroeRim;
            }
            //System.out.println("финальный ответ в задаче " + result);
            if (result <= 0){
                throw new ScannerExcpection("Отрицательное значение для римских цифр");
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
                System.out.println("Ответ: " + calc + " = " + resultRim1 + resultRim2);
            }
        }
    }
}


