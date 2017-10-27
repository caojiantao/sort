import java.util.Arrays;

/**
 * 基数排序
 */
public class Radix {

  public static void main(String[] args) {
    int[] data = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
    System.out.println(Arrays.toString(sortByRadix(data)));
  }

  private static int[] sortByRadix(int[] data) {
    // 定义一个零时桶数组
    int[][] buckets = new int[10][data.length];
    // 每一个桶的实际长度
    int[] bucketLengths = new int[10];
    // 得到数组元素的最高位
    int high = Util.getHigh(data);
    for (int digit = 0; digit < high; digit++) {
      // 按基数存储到对应的桶中
      for (int d : data) {
        int remainder = (int) (d / Math.pow(10, digit) % 10);
        // 注意增加对应桶的实际长度
        buckets[remainder][bucketLengths[remainder]++] = d;
      }
      // 将桶的数据回倒入原始数组中
      int index = 0;
      for (int i = 0; i < buckets.length; i++) {
        for (int j = 0; j < bucketLengths[i]; j++) {
          data[index] = buckets[i][j];
          index++;
        }
        // 重置每一个桶的实际长度
        bucketLengths[i] = 0;
      }
    }
    return data;
  }
}
