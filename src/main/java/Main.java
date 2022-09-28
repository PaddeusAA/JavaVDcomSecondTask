import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        int number;
        int tempData;
        String data;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выведите число больше 0 и четное 2");
        number = scanner.nextInt();
        ExceptionInputValidation(number);

        data = "0";
        FileOutputStream out = new FileOutputStream("out.txt");
        out.write(data.getBytes());
        out.close();

    }
    //region Проверки на ошибки
    private static void ExceptionInputValidation(int value ){
        if(value <= 0){
            try {
                throw new Main.NumberException();
            } catch (NumberException e) {
                System.out.println("\t Error 1: Число равно или меньше нуля");
                throw new RuntimeException(e);
            }
        }
        if(value %2 != 0){
            try {
                throw new Main.NumberException();
            } catch (NumberException e) {
                System.out.println("\t Error 2: Число не кратно двум");
                throw new RuntimeException(e);
            }
        }
    }

    static class NumberException extends Exception{
        public NumberException() {}
    }
    //endregion
}
