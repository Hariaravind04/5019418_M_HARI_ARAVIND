import java.util.HashMap;
import java.util.Map;

public class InventorySystem {
    
    static class Product {
        private int productId;
        private String productName;
        private int quantity;
        private double price;
        
        public Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product [ID=" + productId + ", Name=" + productName + ", Quantity=" + quantity + ", Price=" + price + "]";
        }
    }

    private Map<Integer, Product> inventory;

    public InventorySystem() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
        }
    }

    public void deleteProduct(int productId) {
        inventory.remove(productId);
    }

    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();
        
        system.addProduct(new Product(1, "Laptop", 50, 1500.00));
        system.addProduct(new Product(2, "Smartphone", 200, 700.00));
        
        system.updateProduct(1, 45, 1450.00);
        
        system.deleteProduct(2);
        
        system.inventory.values().forEach(System.out::println);
    }
}
