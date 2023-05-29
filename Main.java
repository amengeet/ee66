import java.util.Scanner;
abstract class Calculation {
    double num1;
    double num2;

    Calculation(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    abstract double calculate();
}
class Addition extends Calculation {
    Addition(double num1, double num2) {
        super(num1, num2);
    }

    double calculate() {
        return num1 + num2;
    }
}
class Subtraction extends Calculation {
    Subtraction(double num1, double num2) {
        super(num1, num2);
    }

    double calculate() {
        return num1 - num2;
    }
}
class Multiplication extends Calculation {
    Multiplication(double num1, double num2) {
        super(num1, num2);
    }

    double calculate() {
        return num1 * num2;
    }
}
class Division extends Calculation {
    Division(double num1, double num2) {
        super(num1, num2);
    }

    double calculate() {
        if (num2 == 0) {
            System.out.println("错误:除数不能为0!");
            throw new IllegalArgumentException("Divisor cannot be zero!");
        }
        return num1 / num2;
    }
}
class CalculationFactory {
    static Calculation getCalculation(String operator, double num1, double num2) {
        switch (operator) {
            case "+":
                return new Addition(num1, num2);
            case "-":
                return new Subtraction(num1, num2);
            case "*":
                return new Multiplication(num1, num2);
            case "/":
                return new Division(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入第一个数字: ");
        double num1 = scanner.nextDouble();

        System.out.print("请输入第二个数字: ");
        double num2 = scanner.nextDouble();

        System.out.print("请选择运算类型（+，-，*，/）：");
        String operator = scanner.next();

        Calculation calculation = CalculationFactory.getCalculation(operator, num1, num2);

        System.out.println("结果为：" + calculation.calculate());
    }
}