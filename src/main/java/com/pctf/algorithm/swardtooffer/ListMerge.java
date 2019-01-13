package com.pctf.algorithm.swardtooffer;

public class ListMerge {

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1 == null && list2 == null) {
            return null;
        }
        ListNode res = list1.val > list2.val ? list2 : list1;
        ListNode cur = res;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                ListNode temp = list2.next;
                cur.next = list2;
                list2 = temp;
            } else {
                ListNode temp = list1.next;
                cur.next = list1;
                list1 = temp;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return res;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        ListNode list6 = new ListNode(6);
        ListNode list7 = new ListNode(7);
        list1.next = list3;
        list3.next = list5;
        list5.next = list7;
        list2.next = list4;
        list4.next = list6;
        ListNode re = Merge(list1, list2);
        System.out.println(re);
    }
}


