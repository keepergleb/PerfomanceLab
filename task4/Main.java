import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Main.java <input_file>");
            return;
        }

        List<Integer> nums = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                nums.add(Integer.parseInt(line));
            }
        }

        System.out.println(minMoves(nums));
    }

    public static int minMoves(List<Integer> nums) {
        Collections.sort(nums);
        int median = nums.get(nums.size() / 2);
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        return moves;
    }
}