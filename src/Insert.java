import java.util.Arrays;

/**
 * 插入排序
 */
public class Insert {

  public static void main(String[] args) {
    int[] data = {3, 1};
    System.out.println(Arrays.toString(sortByInsert(data)));
  }

  private static int[] sortByInsert(int[] data) {
    int i, j, key;
    for (j = 1; j < data.length; j++) {
      // 定义插值数据
      key = data[j];
      for (i = j - 1; i >= 0; i--) {
        if (data[i] > key) {
          data[i + 1] = data[i];
        } else {
          break;
        }
      }
      // 插值操作
      data[i + 1] = key;
    }
    return data;
  }
}
