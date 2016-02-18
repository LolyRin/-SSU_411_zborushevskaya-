import java.util.Scanner;

/**
 * Created by Жанна on 29.01.2016.
 */
public class Main {

    public static void main(String[] args) {
        Basket basket = new MyBasket();
        Scanner in = new Scanner(System.in);
        int command;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - add product");
            System.out.println("2 - delete product");
            System.out.println("3 - update product quantity");
            System.out.println("4 - delete all");
            System.out.println("5 - get product quantity");
            System.out.println("6 - get product");
            System.out.println("7 - Exit");
            System.out.println("Enter command:");
            command = Integer.parseInt(scanner.nextLine());

            if (command == 1) {
                System.out.println("Enter product:");
                String product = scanner.nextLine();
                System.out.println("Enter quantity:");
                int quantity = Integer.parseInt(scanner.nextLine());
                basket.addProduct(product, quantity);
            } else if (command == 2) {
                System.out.println("Enter product:");
                String product = scanner.nextLine();
                basket.removeProduct(product);
                System.out.println(product + " " + "removed");
            } else if (command == 3) {
                System.out.println("Enter product:");
                String product = scanner.nextLine();
                System.out.println("Enter quantity:");
                int quantity = Integer.parseInt(scanner.nextLine());
                basket.updateProductQuantity(product, quantity);
            } else if (command == 4) {
                basket.clear();
                System.out.println("The list is empty!");
            } else if (command == 5) {
                System.out.println("Enter product:");
               String product = scanner.nextLine();
               // basket.getProductQuantity(product);
                //product=in.nextLine();
                try {System.out.println(basket.getProductQuantity(product));}
                catch(Exception e){System.out.println("Not done. Invalid input!");}
            }else if(command == 6) {
                for(String p:basket.getProducts())
                    System.out.println(p);
            }else if(command == 7) {
                System.out.println("Exit!");
                break;
            } else System.out.println("Error command. Enter the command from 1 to 5.");
            System.out.println();
            System.out.println();
        }
    }
}


