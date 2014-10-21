
public class Subset {
    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        RandomizedQueue<String> file = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String a = StdIn.readString();
            file.enqueue(a);
        }
        for (int j = 0; j < n; j++) {
            System.out.println(file.dequeue()); //avoid repetitions
         }
    }

}
