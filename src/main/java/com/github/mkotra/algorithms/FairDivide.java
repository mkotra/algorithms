import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FairDivide {

    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(
                94, 12, 17, 14, 55, 91, 20, 39, 100, 34, 14, 100, 57, 81, 59, 70,
                71, 93, 14, 82, 19, 85, 30, 97, 36, 21, 24, 14, 28, 42, 88, 29, 79,
                19, 32, 50, 85, 22, 74, 73, 70, 49, 15, 33, 11, 37, 16, 56, 59,
                3, 51, 71, 67, 17, 44, 85, 29, 87, 94, 68, 55, 22, 51,
                2, 5, 52, 86, 88, 95, 39, 76, 94, 23, 7, 84, 40, 36,
                44, 91, 79, 42, 35, 62, 31, 76, 85, 87, 11, 29, 8, 7, 84, 60, 87, 24, 50,
                38, 33, 44, 27
        );
        divide(items);
    }

    static void divide(List<Integer> items) {
        items.sort(Comparator.reverseOrder());

        int leftSum = 0, rightSum = 0;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int item : items) {
            if (leftSum <= rightSum) {
                leftSum += item;
                left.add(item);
            } else {
                rightSum += item;
                right.add(item);
            }
        }

        System.out.printf(" LEFT SUM: %d ITEMS: %s%n", leftSum, left);
        System.out.printf("RIGHT SUM: %d ITEMS: %s%n", rightSum, right);
    }
}
