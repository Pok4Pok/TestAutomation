import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Calc {
    BufferedReader in;

    public Calc(InputStreamReader isr) {
        in = new BufferedReader(isr);
    }
    public void run() {
        double valueOne = 0, valueTwo = 0;
        char op = ' ';
        int state = 0;
        String str;
        try {
            while((str = in.readLine()) != null && !str.equals("")) {
                switch (state) {
                    case 0:
                        valueOne = Double.parseDouble(str);
                        state = 1;
                        break;
                    case 1:
                        op = str.charAt(0);
                        state = 2;
                        break;
                    case 2:
                        valueTwo = Double.parseDouble(str);
                        switch (op) {
                            case '+':
                                System.out.println(valueOne + valueTwo);
                                break;
                            case '-':
                                System.out.println(valueOne - valueTwo);
                                break;
                            case '*':
                                System.out.println(valueOne * valueTwo);
                                break;
                            case '/':
                                System.out.println(valueOne / valueTwo);
                                break;
                        }
                        state = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { // входная точка
        new Calc(new InputStreamReader(System.in)).run();
    }
}