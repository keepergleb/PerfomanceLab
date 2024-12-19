public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Main.java <n> <m>\n" +
                    "n - int means 123...n\n" +
                    "m - step length");
            return;
        }

        int n;
        int m;

        try {
            n = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);
            if (n < 1 || m < 1) {
                System.out.println("n and m must be int > 0");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("n and m must be int");
            return;
        }

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        StringBuilder path = new StringBuilder();
        int count = 0;

        do {
            path.append(array[count]);
            count = (count + m - 1) % n;
        }
        while (array[count] != 1);

        System.out.println(path);
    }
}
