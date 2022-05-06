import model.ListNode;


class ListUtil {

    /**
     * 反转单链表
     * @param head 头节点
     * @return 反转后的链表的头节点
     */
    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}