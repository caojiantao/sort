import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubble {

  public static void main(String[] args) {
    int[] data = {10, 6, 1, 2, 4, 3, 7, 9, 2};
    System.out.println(Arrays.toString(sortByBubble(data)));
  }

  private static int[] sortByBubble(int[] data) {
    for (int i = 0; i < data.length - 1; i++) {
      for (int j = 0; j < data.length - 1 - i; j++) {
        if (data[j] > data[j + 1]) {
          Util.exchange(data, j, j + 1);
        }
      }
    }
    return data;
  }
}
