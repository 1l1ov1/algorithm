import java.util.Arrays;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {

        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }

        System.out.println(map);
        // System.out.println(Arrays.toString(arr));
        }
    }


}
