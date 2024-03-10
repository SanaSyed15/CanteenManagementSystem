/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanas
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
        this.items = new ArrayList<>();
        initializeMenu();
    }

    private void initializeMenu() {
        try (BufferedReader reader = new BufferedReader(new FileReader("menu.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                int itemId = Integer.parseInt(parts[0].trim().split("\\.")[0]);
                String itemName = parts[1].trim();
                double itemPrice = Double.parseDouble(parts[2].trim());
                MenuItem item = new MenuItem(itemId, itemName, itemPrice);
                items.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Other methods in your Menu class...

    List<MenuItem> getMenuItems() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}