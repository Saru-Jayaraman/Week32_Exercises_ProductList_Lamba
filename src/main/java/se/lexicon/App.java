package se.lexicon;

import java.util.Arrays;
import java.util.List;
/**
 * Hello world!
 *
 */

public class App
{
    public static void doOperation(List<Product> productList, Action action, Conditional filter) {
        for(Product product : productList) {
            if(filter.test(product)) {
                action.execute(product);
            }
        }
    }
    public static void main( String[] args )
    {
        Product p1 = new Product("Willy's", 90, 2);
        Product p2 = new Product("Maxi", 160, 4);
        Product p3 = new Product("Coop", 140, 0);
        Product p4 = new Product("Lidl", 100, 12);
        Product p5 = new Product("Best", 120, 8);
        Product p6 = new Product("IKEA", 200, 0);
        Product[] productArray = new Product[]{p1, p2, p3, p4, p5, p6};
        List<Product> productList;
        productList = Arrays.asList(productArray);

//        1. Print out all Products that have stock value of 0.
        Conditional filter1 = p -> p.getStock() == 0;
        Action action1 = p -> System.out.println(p);
        System.out.println("Stock value of 0:");
        System.out.println("==================");
        doOperation(productList, action1, filter1);
        System.out.println();

//        2. Print out the productName of all the Products that starts with B.
        Conditional filter2 = (p) -> p.getProductName().startsWith("B");
        System.out.println("Products that starts with B:");
        System.out.println("=============================");
        doOperation(productList, action1, filter2);
        System.out.println();

//        3. Print out all Products that have price above 100 AND lower than 150
        Conditional filter3 = (p) -> p.getPrice() > 100 && p.getPrice() < 150;
        System.out.println("Products that have price above 100 and lower than 150:");
        System.out.println("=======================================================");
        doOperation(productList, action1, filter3);
        System.out.println();

//        4. Increase the price of all Products that have a stock value of less than 10 AND above 0 by 50%
        Conditional filter4 = p -> p.getStock() > 0 && p.getStock() < 10;
        Action action2 = p -> {
            p.setPrice(p.getPrice() + p.getPrice() * 0.5);
            System.out.println(p);
        };
        System.out.println("Increase the price of all Products by 50%:");
        System.out.println("==========================================");
        doOperation(productList, action2, filter4);
    }
}
