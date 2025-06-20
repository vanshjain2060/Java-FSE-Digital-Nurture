package Week1.DSA.ECommerceSearch;

public class SearchingAlgorithm {

    // Search by Name

    public static void linearSearchByName(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                System.out.println("Found at " + p);
                return;
            }
        }
        System.out.println("Not Present");
    }

    public static void binarySearchByName(Product[] products, String name) {
        int n = products.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int curr = products[mid].productName.compareToIgnoreCase(name);
            if (curr == 0) {
                System.out.println("Found at " + products[mid]);
                return;
            } else if (curr < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Not Present");
    }

    // Search by Id

    public static void linearSearchById(Product[] products, int id) {
        for (Product p : products) {
            if (p.productId == id) {
                System.out.println("Found at " + p);
                return;
            }
        }
        System.out.println("Not Present");
    }

    public static void binarySearchById(Product[] products, int id) {
        int n = products.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productId == id) {
                System.out.println("Found at " + products[mid]);
                return;
            } else if (products[mid].productId < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Not Present");
    }

}