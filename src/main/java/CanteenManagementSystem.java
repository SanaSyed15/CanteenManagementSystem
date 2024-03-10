/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanas
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuItem {
    private final String name;
    private final double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Menu {
    private final List<MenuItem> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    // Read menu items from a file
    public void loadMenuFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0].trim();
                double price = Double.parseDouble(parts[1].trim());
                MenuItem menuItem = new MenuItem(name, price);
                addMenuItem(menuItem);
            }
        } catch (IOException | NumberFormatException e) {
        }
    }
}

class Order {
    private final List<MenuItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }
}

class DatabaseManager {
    private static final String ORDERS_FILE_PATH = "orders.txt";

    public static void writeOrderToFile(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDERS_FILE_PATH, true))) {
            writer.write("Order Details:\n");
            for (MenuItem item : order.getItems()) {
                writer.write("- " + item.getName() + " - $" + item.getPrice() + "\n");
            }
            writer.write("\n");
            System.out.println("Order written to the database.");
        } catch (IOException e) {
        }
    }
}

public class CanteenManagementSystem {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.loadMenuFromFile("menu.txt");

        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Canteen Management System!\n");

        do {
            displayMenu(menu.getMenuItems());
            System.out.print("Enter the item number to place an order (or '0' to exit): ");
            int itemNumber = scanner.nextInt();

            if (itemNumber == 0) {
                break;
            }

            MenuItem selectedItem = menu.getMenuItems().get(itemNumber - 1);
            order.addItem(selectedItem);

        } while (true);

        DatabaseManager.writeOrderToFile(order);

        System.out.println("\nThank you for using the Canteen Management System!");
    }

    private static void displayMenu(List<MenuItem> menuItems) {
        System.out.println("----- Menu -----");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - $" + item.getPrice());
        }
        System.out.println();
    }
}