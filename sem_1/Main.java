package sem_1;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Product product1 = new Product("Alpen Gold", 80);
        Product product2 = new Product("Milko", 50);
        Product product3 = new Bottle("Fanta", 70, 2);
        vendingMachine.addProduct(product1);
        vendingMachine.addProduct(product2);
        vendingMachine.addProduct(product3);

        System.out.print(vendingMachine.getProductByCost(100));
    }
}
