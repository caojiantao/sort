import java.util.Arrays;

/**
 * 希尔排序
 */
public class Shell {

  public static void main(String[] args) {
    int[] data = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
    System.out.println(Arrays.toString(sortByInsert(data)));
  }

  private static int[] sortByInsert(int[] data) {
    int len = data.length;
    // gap为多少，就会分为多少组
    for (int gap = len / 2; gap > 0; gap /= 2) {
      // 针对每一组采取插入排序
      for (int loop = 0; loop < gap; loop++) {
        int i, j, key;
        // 直接插入排序
        for (j = loop + gap; j < len; j += gap) {
          key = data[j];
          for (i = j - gap; i >= loop; i -= gap) {
            if (data[i] > key) {
              data[i + gap] = data[i];
            } else {
              break;
            }
          }
          data[i + gap] = key;
        }
      }
    }
    return data;
  }
}
