import java.util.Arrays;

public class Merge {

  public static void main(String[] args) {
    int[] data = {4, 1, 1, 3, 2, 5, 0};
    System.out.println("排序后：" + Arrays.toString(sortBySelect(data)));
  }

  private static int[] sortBySelect(int[] data) {
    // gap为分解的数组大小，归并后的数组自然是2 * gap
    for (int gap = 1; gap < data.length; gap *= 2) {
      // 归并后多少组
      int count = data.length / (2 * gap);
      for (int loop = 0; loop < count; loop++) {
        merge(data, gap, loop * (2 * gap), 2 * gap);
      }
      // 归并剩余的数组（存在的话）
      int remainder = data.length % (2 * gap);
      merge(data, gap, count * (2 * gap), remainder);

      System.out.println("gap为" + gap + "：" + Arrays.toString(data));
    }
    return data;
  }

  public static void merge(int[] data, int gap, int start, int size) {
    if (size == 0 || size == 1) return;
    // 临时归并数组
    int[] temp = new int[size];
    // i为左表游标，j为右表游标，k为临时表游标
    int i = start, j = i + gap, k = 0;
    while (i < start + gap && j < start + size) {
      if (data[i] < data[j]) {
        temp[k++] = data[i++];
      } else {
        temp[k++] = data[j++];
      }
    }
    // 左表未扫描完
    while (i < start + gap) {
      temp[k++] = data[i++];
    }
    // 右表未扫描完
    while (j < start + size) {
      temp[k++] = data[j++];
    }
    // 将归并后的数组回写到原始数组中
    System.arraycopy(temp, 0, data, start, temp.length);
  }
}