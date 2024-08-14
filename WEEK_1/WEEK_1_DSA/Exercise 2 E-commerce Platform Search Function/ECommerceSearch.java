public class ECommerceSearch {
    
    static class Product {
        private int productId;
        private String productName;
        private String category;
        
        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "Product [ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
        }
    }

    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == productId) {
                return products[mid];
            }
            if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Tablet", "Electronics"),
            new Product(4, "Headphones", "Accessories"),
            new Product(5, "Smartwatch", "Wearables")
        };
        
        Product result1 = linearSearch(products, 3);
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Product not found"));

        Product[] sortedProducts = products.clone();
        Product result2 = binarySearch(sortedProducts, 3);
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Product not found"));
    }
}
