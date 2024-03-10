/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanas
 */

public class OrderProcessor {
    private static int orderCounter = 1;

    public void processOrder(Order order) {
        // Generate a unique order number and update the order
        order.setOrderNumber(orderCounter++);

        // Process payment, if needed

        // Update the database (write to file)
        DatabaseManager.writeOrder(order);
    }
}

