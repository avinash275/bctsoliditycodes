import java.util.*;

class Item {
    int profit;
    int weight;

    public Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }
}

public class fractionalKnapsack {
    public static double FractionalKnapsack(int w, ArrayList<Item> arr) {
        arr.sort(Comparator.comparingDouble((Item item) -> (double) item.profit / item.weight).reversed());
        double finalValue = 0.0;
        
        for (Item item : arr) {
            if (w >= item.weight) {
                finalValue += item.profit;
                w -= item.weight;
            } else {
                finalValue += item.profit * ((double) w / item.weight);
                break;
            }
        }
        return finalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = scanner.nextInt();
        ArrayList<Item> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter profit of item " + (i + 1) + ": ");
            int profit = scanner.nextInt();
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            int weight = scanner.nextInt();
            arr.add(new Item(profit, weight));
        }

        System.out.print("Enter capacity of knapsack: ");
        int w = scanner.nextInt();

        double result = FractionalKnapsack(w, arr);
        System.out.println("Maximum value in knapsack: " + result);
    }
}