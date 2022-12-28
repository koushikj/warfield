package com.warfield.problems;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

 */
public class AddTwoLinkedList {
    public ListNode addTwoNumbersWithCarryToBeforeNode(ListNode l1, ListNode l2) {
        ListNode l1_pointer =l1;
        ListNode l2_pointer =l2;
        ListNode resultNode=new ListNode();
        ListNode resultNode_pointer=resultNode;
        while(l1_pointer!=null){
            //System.out.println(l1_pointer.val);
            //System.out.println(l2_pointer.val);
            int sum = (l1_pointer.val + l2_pointer.val) % 10;
            l2_pointer = l2_pointer.next;
            l1_pointer = l1_pointer.next;
            int reminder=0,division=0;
            ListNode nextNode = null;
            if(l1_pointer!=null) {
                //System.out.println("\t"+l1_pointer.val);
                //System.out.println("\t"+l2_pointer.val);
                int nextSum = l1_pointer.val + l2_pointer.val;
                if(nextSum>=10){
                    reminder = nextSum%10;
                    division = nextSum/10;
                }else{
                    reminder=nextSum;
                }
                nextNode = new ListNode(reminder);
                //System.out.println("\t"+nextSum);
            }
            ListNode newNode = new ListNode(sum+division, nextNode);
            //System.out.println(newNode.val+"\n");
            resultNode_pointer.next = newNode;
            resultNode_pointer = resultNode_pointer.next;
        }
        return resultNode.next;
    }
    public ListNode addTwoNumbersWithCarryToNextNode(ListNode l1, ListNode l2) {
        ListNode l1_pointer =l1;
        ListNode l2_pointer =l2;
        ListNode resultNode=new ListNode();
        ListNode resultNode_pointer=resultNode;
        int carry=0;
        boolean isCarry=true;
        while(l1_pointer!=null || l2_pointer!=null || isCarry){
            int sum=carry;
            if(l1_pointer!=null){
                sum=sum+l1_pointer.val;
                l1_pointer = l1_pointer.next;
            }
            if(l2_pointer!=null){
                sum=sum+l2_pointer.val;
                l2_pointer = l2_pointer.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            resultNode_pointer.next = new ListNode(sum);
            resultNode_pointer = resultNode_pointer.next;
            isCarry = carry>0;
        }
        return resultNode.next;
    }
    public static void main(String[] args) {
        AddTwoLinkedList addTwoLinkedList = new AddTwoLinkedList();
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode resultNode = addTwoLinkedList.addTwoNumbersWithCarryToBeforeNode(listNode1, listNode2);
        //printNode(resultNode);

        listNode1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9)))))));
        listNode2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        resultNode = addTwoLinkedList.addTwoNumbersWithCarryToNextNode(listNode1, listNode2);
        printNode(listNode1);
        printNode(listNode2);
        printNode(resultNode);
    }

    private static void printNode(ListNode resultNode) {
        System.out.print("\nNode:::: ");
        while (resultNode!=null){
            System.out.print(resultNode.val+" ");
            resultNode = resultNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}