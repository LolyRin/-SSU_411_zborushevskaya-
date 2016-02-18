import java.util.*;
import java.util.concurrent.ExecutionException;



/**
 * Created by Жанна on 22.01.2016.
 */
public class Calculate {


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> ssVr;
        String ss = "";

        while(ss.equals("Close") == false){
            try {
                System.out.println("Enter:");
                ss = scanner.nextLine();
                ssVr = pols(ss);
                Double res = calculate(ssVr);
                System.out.println("Result: " + res);
            } catch (Exception e) {
                if (ss.equals("Close")) {
                    System.out.println("Good bye!");
                }
                else{
                    System.out.println("Error!");
                }
            }
        }
    }

    public static ArrayList<String> pols(String mes1) throws Exception {
        ArrayList<String> ssEx = new ArrayList<String>();
        ArrayList<String> steak = new ArrayList<String>();
        String mes[] = mes1.split(" ");

        for (int i = 0; i < mes.length; i++) {

            if (checkString(mes[i])) {
                ssEx.add(mes[i]);
            }
            else if (oper(mes[i].charAt(0)) ){
                if (steak.size() > 0){
                    while (steak.size()>=1 && (prioritet(mes[i].charAt(0))) < prioritet(steak.get(steak.size()-1).charAt(0))){
                        ssEx.add(steak.get(steak.size()-1));
                        steak.remove(steak.size()-1);
                    }
                    steak.add(mes[i]);
                }
                else steak.add(mes[i]);

            } else if (centre(mes[i].charAt(0))) {
                steak.add(mes[i]);

            } else if (!(centre(mes[i].charAt(0)))) {
                String temp;
                temp = String.valueOf(steak.get(steak.size()-1));
                while ('(' != temp.charAt(0)) {
                    ssEx.add(temp);
                    steak.remove(steak.size()-1);
                    temp = String.valueOf(steak.get(steak.size() - 1));
                }
                steak.remove(steak.size() - 1);
            }
        }
        while (steak.size()-1 >= 0){
            ssEx.add(steak.get(steak.size()-1));
            steak.remove(steak.size()-1);
        }
        return ssEx;
    }


    public static Double calculate(ArrayList<String> mes) throws Exception {
        ArrayList<Double> steak = new ArrayList<Double>();
        double res = 0;

        for (int i=0; i< mes.size(); i++){
            if (checkString(mes.get(i))){
                steak.add((double)Double.parseDouble(mes.get(i)));
            }
            else {
                if (steak.size() < 2) {
                    throw new Exception("Error!");
                }
                res = operation(steak.get(steak.size()-2),steak.get(steak.size()-1), mes.get(i).charAt(0));
                steak.remove(steak.size()-2);
                steak.remove(steak.size()-1);
                steak.add(res);
            }
        }

        return steak.get(steak.size()-1);
    }


    public static boolean checkString(String string) {
        try {

            Double.valueOf(string) ;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    private static boolean oper(char c) throws Exception {
        switch (c) {
            case '-':
            case '+':
            case '*':
            case '/':
            case '^':
                return true;
        }
        return false;

    }
    private static int prioritet(char c){

        switch (c) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
        }
        return 1;
    }
    private static boolean centre(char c){
        switch (c){
            case '(':
                return true;
        }
        return false;
    }
    private static double operation(double a, double b, char c) throws Exception {
        double res = 0;
        switch (c){
            case('+'): res = a+b; break;
            case('-'): res = a-b; break;
            case('*'): res = a*b; break;
            case('/'): res = a/b; break;
            case('^'): res =  Math.pow(a,b); break;

        }
        return res;

    }



}







