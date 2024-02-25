import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       int arr[]={3,5,4,6,9,8};
        System.out.print("Oldingi qiymat: ");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]) {
                    int sum=arr[i];
                    arr[i]=arr[j];
                    arr[j]=sum;
                }
            }
        }
        System.out.print("Sortlangan qiymat:");
        System.out.println(Arrays.toString(arr));
    }
}