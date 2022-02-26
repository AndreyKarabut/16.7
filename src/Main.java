import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static class CyclicCollection {
        private final List<byte[]> list = new ArrayList<>(10);

        CyclicCollection() {
            for (int i = 0; i < 10; i++) {
                list.add(new byte[1024 * 1024]);
            }
        }

        @Override
        public void finalize() {
            System.out.println(this.toString() + "I am death");
        }
    }
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            CyclicCollection collection = new CyclicCollection();
        }
    }
}
