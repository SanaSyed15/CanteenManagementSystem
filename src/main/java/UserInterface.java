/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanas
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Canteen canteen;
    private Scanner scanner;

    public UserInterface(Canteen canteen) {
        this.canteen = canteen;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        // Display menu
        displayMenu();

        // Take user order
        List<MenuItem> selectedItems = takeUserOrder();

        // Create order and place it
        Order order = new Order();
        order.setItems(selectedItems);
        canteen.placeOrder(order);

        // Display token or order confirmation
        displayOrderConfirmation(order);
    }

    private void displayMenu() {
        System.out.println("Menu:");
        List<MenuItem> menuItems = canteen.getMenuItems();
        for (MenuItem item : menuItems) {
            System.out.println(item.getId() + ". " + item.getName() + " - $" + item.getPrice());
        }
    }

    private List<MenuItem> takeUserOrder() {
        List<MenuItem> selectedItems = new ArrayList<>();
        System.out.println("Enter item numbers to order (separated by commas):");
        String input = scanner.nextLine();
        String[] itemNumbers = input.split(",");
        for (String itemNumber : itemNumbers) {
            int itemId = Integer.parseInt(itemNumber.trim());
            MenuItem menuItem = findMenuItem(itemId);
            if (menuItem != null) {
                selectedItems.add(menuItem);
            }
        }
        return selectedItems;
    }

    private MenuItem findMenuItem(int itemId) {
        List<MenuItem> menuItems = canteen.getMenuItems();
        for (MenuItem item : menuItems) {
            if (item.getId() == itemId) {
                return item;
            }
        }
        System.out.println("Invalid item number: " + itemId);
        return null;
    }

    private void displayOrderConfirmation(Order order) {
        System.out.println("Order placed successfully!");
        System.out.println("Order Number: " + order.getOrderNumber());
        System.out.println("Items:");
        List<MenuItem> items = order.getItems();
        for (MenuItem item : items) {
            System.out.println("- " + item.getName() + " - $" + item.getPrice());
        }
        // You can display more details or generate a token as needed
    }
}
