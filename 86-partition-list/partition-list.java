class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode deserialize(String s) {
        s = s.replaceAll("\\[|\\]|\\s", "");
        if (s.isEmpty()) return null;
        String[] parts = s.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String part : parts) {
            current.next = new ListNode(Integer.parseInt(part));
            current = current.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        sb.append("[");
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) sb.append(",");
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode after = afterHead;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }
}
