public class P5_2 {
    static void bubbleSort(int arr[]) {
        for (int turn = 0; turn < arr.length - 1; turn++) {
            for (int j = 0; j <= arr.length - 2 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]); 
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 8, 9, 7, 5, 6 };

        P5_2 sort = new P5_2();
        sort.bubbleSort(arr);

        bubbleSort(arr);
        
    }

}
