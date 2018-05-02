import java.util.Arrays;

/**
 * 快速排序
 */
public class Fast {

    public static void main(String[] args) {
        int[] data = {11, 6, 2, 5, 4, 10, 9, 7, 5, 12};
        sortByFast(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 类似二分法，递归调用
     */
    private static void sortByFast(int[] data, int start, int end) {
        if (start < end) {
            int i = start, j = end;
            int key = data[i];
            while (i < j) {
                while (j > i && data[j] >= key) j--;
                Util.exchange(data, i, j);
                while (i < j && data[i] < key) i++;
                Util.exchange(data, i, j);
            }
            sortByFast(data, start, i - 1);
            sortByFast(data, j + 1, end);
        }
    }
}
