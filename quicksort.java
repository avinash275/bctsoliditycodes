import java.util.Random;

public class quicksort {
    // Helper function to swap two elements in an array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

   
    private static void deterministicQuicksort(int[] arr, int low, int high) {
        if(low>=high) return;
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr,i, high);
        deterministicQuicksort(arr, low, i-1);
        deterministicQuicksort(arr, i+1, high);
    }

    // Helper function to partition the array for randomized quicksort
    private static void randomizedQuicksort(int[] arr, int low, int high) {
        int randomIndex = new Random().nextInt(high - low + 1) + low;
        swap(arr, randomIndex, high);
        deterministicQuicksort(arr, low, high);
    }


    public static void main(String[] args) {
        int[] arr = {400,20,3,80,64,100}; 
        int[] arrCopy = arr.clone(); // Create a copy for randomized quicksort

    
        deterministicQuicksort(arr, 0, arr.length-1);

        randomizedQuicksort(arrCopy, 0, arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for(int i=0;i<arrCopy.length;i++){
            System.out.print(arrCopy[i]+" ");
        }
        System.out.println();
    }

}
