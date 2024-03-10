/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanas
 */
import java.util.List;

public class Canteen {
    private Menu menu;
    private OrderProcessor orderProcessor;

    public Canteen() {
        // Initialize menu and order processor
        this.menu = new Menu();
        this.orderProcessor = new OrderProcessor();
    }

    public List<MenuItem> getMenuItems() {
        return menu.getMenuItems();
    }

    public void placeOrder(Order order) {
        orderProcessor.processOrder(order);
    }

    void placeOrder(int itemNumber, int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Menu getMenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
