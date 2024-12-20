import java.util.Scanner;

public class calcukator { ;
    public static void main(String[] args){
        double num1 = getdouble();
        double num2 = getdouble();
        double result = operation(num1,num2);
        System.out.println(result);
    }


    public static double getdouble(){
        Scanner sc = new Scanner(System.in);
        System.out.println("введите число");
        double num = sc.nextDouble();
        return num;
    }
    public static double operation(double num1,double num2){
        Scanner sc = new Scanner(System.in);
        System.out.println("введите операцию");
        double res = 0;
        String operat = sc.nextLine();
        if(operat.equals("+")){
            res = num1 + num2;

        }
        else if(operat.equals("/")){
            res = num1 / num2;

        }
        else if(operat.equals("*")){
            res = num1 * num2;

        }
        else if(operat.equals("-")){
            res = num1 - num2;

        }
        else{
            System.out.println("данного оператора не существует");
        }
        return res;
    }



}
