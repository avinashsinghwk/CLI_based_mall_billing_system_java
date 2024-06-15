// Importing all the necessary things that will be used in the code

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// Making a class Product to store all the product information including name and price

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Making a class Inventory that has methods to show inventory and get products

class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public void showProducts() {
        System.out.println("+----------------------+------------+");
        System.out.println("| Product Name         | Price (Rs) |");
        System.out.println("+----------------------+------------+");
        for (Product product : products.values()) {
            System.out.printf("| %-20s | %6.2f Rs. |\n", product.getName(), product.getPrice());
        }
        System.out.println("+----------------------+------------+");
    }

}

// Making a class Cart that has methods like add to card and calculate total price 

class Cart {
    private List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        items.add(product);
    }

    public List<Product> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

// Making a class Bill to make a bill for the products 

class Bill {
    public void generateBill(Cart cart) {
        List<Product> items = cart.getItems();
        double total = cart.calculateTotal();

        System.out.println("\n\nBill Details:");
        System.out.println(String.format("%-20s %s", "Item", "Price (Rs)"));
        System.out.println("----------------------------------");

        for (Product item : items) {
            System.out.println(String.format("%-20s %.2f Rs", item.getName(), item.getPrice()));
        }

        System.out.println("----------------------------------");
        System.out.println(String.format("%-20s %.2f Rs", "TOTAL", total));
    }
}

// Making a main class Mall that has all the logic to display information.

public class Mall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        Cart cart = new Cart();

        // Products added to inventory

        inventory.addProduct(new Product("T-SHIRT", 19.99));
        inventory.addProduct(new Product("JEANS", 39.99));
        inventory.addProduct(new Product("PAINT", 92.99));
        inventory.addProduct(new Product("DHOTI", 98.19));
        inventory.addProduct(new Product("SHIRT", 78.59));
        inventory.addProduct(new Product("TIE", 11.99));
        inventory.addProduct(new Product("BELT", 28.89));
        inventory.addProduct(new Product("SHOCKS", 68.08));
        inventory.addProduct(new Product("SHOE", 58.49));
        inventory.addProduct(new Product("GLOVES", 52.99));
        inventory.addProduct(new Product("PURFUME", 69.79));
        inventory.addProduct(new Product("UNDIES", 48.72));
        inventory.addProduct(new Product("BLANKET", 91.19));
        inventory.addProduct(new Product("BED SHEET", 74.24));

        while (true) {
            System.out.println("\n-------- MALL MANAGEMENT SYSTEM (Avinash Kumar Singh) -------\n");
            System.out.println("1. Show all products");
            System.out.println("2. Make a bill");
            System.out.println("3. Exit");
            System.out.print("Choose an option : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\n----------All Availabe Products ----------\n\n");
                    inventory.showProducts();
                    break;

                case 2:
                    while (true) {
                        System.out.print("\nAdd Product to cart / Type 'total' to make bill :  ");
                        String ch = scanner.nextLine();
                        if (ch.equalsIgnoreCase("TOTAL")) {
                            Bill bill = new Bill();
                            bill.generateBill(cart);
                            break;
                        } else {
                            Product product = inventory.getProduct(ch.toUpperCase());
                            if (product != null) {
                                cart.addProduct(product);
                                System.out.println(product.getName() + " added to cart.");
                            } else {
                                System.out.println("Product not found.");
                            }
                        }

                    }

                case 3:
                    System.out.println("\nExiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

}
