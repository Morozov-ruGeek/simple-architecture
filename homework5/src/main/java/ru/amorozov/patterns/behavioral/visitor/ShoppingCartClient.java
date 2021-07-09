package ru.amorozov.patterns.behavioral.visitor;

public class ShoppingCartClient {
    public static void main(String[] args) {
        ItemElements[] items = new ItemElements[]{new Book(20, "1234"),
                new Book(100, "5678"), new Fruit(10, 2, "Banana"),
                new Fruit(5, 5, "Apple")};

        int total = calculatePrice(items);
        System.out.println("Total Cost = " + total);
    }

    private static int calculatePrice(ItemElements[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (ItemElements item : items) {
            sum = sum + item.accept(visitor);
        }
        return sum;
    }


}
