import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] L = {6, 1, 78, 21};

        heapSort(L);

        System.out.println(Arrays.toString(L));
    }

    public static void heapSort(int[] L) {
        int i, n = L.length;

        for (i = n / 2 -1; i >= 0; i--) {
            downHeap(L, i, n-1);
        }

        for (i = n -2; i >= 0;  i--) {
            final int temp = L[0];
            L[0] = L[i+1];
            L[i+1] = temp;
            downHeap(L, 0, i);
        }

    }

    private static void downHeap(int[] L, int i, int max) {
        int j = 2 * i + 1;
        boolean isHeap = false;
        do {
            if ((j < max) && (L[j] < L[j + 1]))
                j++;
            if (j > max)
                isHeap = true;
            else if (L[i] >= L[j])
                isHeap = true;
            else {
                final int temp = L[i];
                L[i] = L[j];
                L[j] = temp;
                i = j;
                j = 2 * i + 1;
            }
        } while (!isHeap);

    }

}
