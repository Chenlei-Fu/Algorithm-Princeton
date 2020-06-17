public class shuffle {
    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }
    private static boolean chosseFirst() {
        if (Math.random() < 0.5) {
            return true;
        } else {
            return false;
        }
    }

    private static void merge(Node first, Node second) {
        Node dummy;
        if (chosseFirst()) {
            dummy = first;
            first = first.next;
        } else {
            dummy = second;
            second = second.next;
        }

        while (first != null || second != null) {
            if (first == null) {
                dummy.next = second;
                second = second.next;
            } else if (second == null) {
                dummy.next = first;
                first = first.next;
            } else if (chosseFirst()) {
                dummy.next = first;
                first = first.next;
            } else {
                dummy.next = second;
                second = second.next;
            }
            dummy = dummy.next;
        }
    }

    public static void shuffleNode(Node head, int N) {
        if (N == 1)
            return;

        int k = 1;
        Node mid = head;
        while (k < N / 2) {
            mid = mid.next;
            k++;
        }
        Node second = mid.next;
        mid.next = null;
        shuffle(head, N / 2);
        shuffle(second, N - N / 2);
        merge(head, second);
    }

}