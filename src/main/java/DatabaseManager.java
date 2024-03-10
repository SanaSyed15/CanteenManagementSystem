/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanas
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DatabaseManager {
    private static final String ORDERS_FILE_PATH = "orders.txt";

    // Other methods...

    public static void writeOrderToFile(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDERS_FILE_PATH, true))) {
            writer.write("Order Number: " + order.getOrderNumber() + "\n");
            List<MenuItem> items = order.getItems();
            for (MenuItem item : items) {
                writer.write("- " + item.getName() + " - $" + item.getPrice() + "\n");
            }
            writer.write("\n");
            System.out.println("Order written to the database.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Other methods...

    static List<Order> readOrders() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void writeOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


