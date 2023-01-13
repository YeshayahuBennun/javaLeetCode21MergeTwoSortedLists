import java.util.*;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
        //empty
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

class Solution {

    public static void main(String[] args) {
        ListNode list1 = new ListNode();

        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();

        node1.val = 1;
        node2.val = 2;
        node3.val = 4;

        list1 = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode list2 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        ListNode node6 = new ListNode();

        node4.val = 1;
        node5.val = 3;
        node6.val = 4;

        list2 = node4;
        node4.next = node5;
        node5.next = node6;

        traversalLinkedList(mergeTwoLists(list1, list2));


    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        List<Integer> simpleList = new ArrayList<>();
        while (list1 != null) {
            simpleList.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            simpleList.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(simpleList);

        ListNode mergedList = new ListNode(0);
        ListNode tempNode = new ListNode(simpleList.get(0));
        mergedList.next = tempNode;
        for (int i = 1; i < simpleList.size(); i++) {
            tempNode.next = new ListNode(simpleList.get(i));
            tempNode = tempNode.next;
        }

        return mergedList.next;
    }

    private static void traversalLinkedList(ListNode listNode) {
        while (listNode.next != null) {
            System.out.println(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }
}

