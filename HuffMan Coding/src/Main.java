
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

class HuffmanNode {

    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode node1, HuffmanNode node2)
    {

        return node1.data - node2.data;
    }
}

public class Main {

    public static void printCode(HuffmanNode root, String s)
    {

        if (root.left == null
                && root.right == null
                && Character.isLetter(root.c)) {
        	
            System.out.println(root.c + ":" + s);
            
            return;
        }


        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }


    public static void main(String[] args)
    {

        Scanner s = new Scanner(System.in);

        int n = 6;
        char[] charArray = { 'f', 'g', 'h', 'i', 'j', 'k' };
        int[] charfreq = { 80, 2, 15, 13, 40, 45};

        PriorityQueue<HuffmanNode> pq
                = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode node = new HuffmanNode();

            node.c = charArray[i];
            node.data = charfreq[i];

            node.left = null;
            node.right = null;

            pq.add(node);
        }

        HuffmanNode root = null;

        while (pq.size() > 1) {

            HuffmanNode x = pq.peek();
            pq.poll();

            HuffmanNode y = pq.peek();
            pq.poll();

            HuffmanNode tempParent = new HuffmanNode();

            tempParent.data = x.data + y.data;
            tempParent.c = '-';

            tempParent.left = x;

            tempParent.right = y;

            root = tempParent;

            pq.add(tempParent);
        }
        s.close();

        printCode(root, "");
    }
}

