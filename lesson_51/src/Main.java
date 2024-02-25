import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int arr[] = {2, 4, 1, 11, 23, 0};
//        System.out.println(Arrays.toString(arr));
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    sum = arr[i];
                    arr[i] = arr[j];
                    arr[j] = sum;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
