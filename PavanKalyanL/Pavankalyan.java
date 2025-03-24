import java.util.Scanner;

public class LongestMountain {
    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        
        int maxMountainLength = 0;
        
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                int left = i - 1;
                while (left >= 0 && A[left] < A[left + 1]) {
                    left--;
                }
                
                int right = i + 1;
                while (right < A.length && A[right] < A[right - 1]) {
                    right++;
                }
                
                int mountainLength = right - left - 1;
                
                maxMountainLength = Math.max(maxMountainLength, mountainLength);
            }
        }
        
        return maxMountainLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        LongestMountain lm = new LongestMountain();
        
        int result = lm.longestMountain(arr);
        System.out.println("Longest Mountain Length: " + result);
        
        scanner.close();
    }
}
