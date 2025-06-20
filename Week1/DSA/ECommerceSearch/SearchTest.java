package Week1.DSA.ECommerceSearch;

import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Shirt", "Clothing"),
                new Product(3, "Phone", "Electronics"),
                new Product(4, "Book", "Stationery"),
                new Product(5, "Shoes", "Footwear")
        };

        int n = products.length;
        Product[] sortedById = new Product[n];

        for (int i = 0; i < n; i++)
            sortedById[i] = products[i];

        Arrays.sort(sortedById, (a, b) -> Integer.compare(a.productId, b.productId));

        System.out.println("Linear Search by ID ");
        SearchingAlgorithm.linearSearchById(products, 4);
        System.out.println();

        System.out.println("Binary Search by ID ");
        SearchingAlgorithm.binarySearchById(sortedById, 8);

        System.out.println();

        Product[] sortedByName = new Product[n];

        for (int i = 0; i < n; i++)
            sortedByName[i] = products[i];

        Arrays.sort(sortedByName, (a, b) -> a.productName.compareTo(b.productName));

        System.out.println("Linear Search by Name ");
        SearchingAlgorithm.linearSearchByName(products, "Shirt");
        System.out.println();

        System.out.println("Binary Search by Name ");
        SearchingAlgorithm.binarySearchByName(sortedByName, "book");
        System.out.println();
    }

}

/*
 * Linear Search by ID
 * Found at 4 - Book - Stationery
 * 
 * Binary Search by ID
 * Not Present
 * 
 * Linear Search by Name
 * Found at 2 - Shirt - Clothing
 * 
 * Binary Search by Name
 * Found at 4 - Book - Stationery
 */