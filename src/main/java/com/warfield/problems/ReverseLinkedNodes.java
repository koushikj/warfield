package com.warfield.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseLinkedNodes {
    public static void main(String[] args) {
        ReverseLinkedNodes reverseLinkedNodes = new ReverseLinkedNodes();
        //ListNode listNode = reverseLinkedNodes.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9))))))))), 2);
        //ListNode listNode = reverseLinkedNodes.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8)))))))), 2);
        //ListNode listNode = reverseLinkedNodes.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        //ListNode listNode = reverseLinkedNodes.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3);
        //ListNode listNode = reverseLinkedNodes.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 1);
        //ListNode listNode = reverseLinkedNodes.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3))), 3);
        //ListNode listNode = reverseLinkedNodes.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))), 3);
        //ListNode listNode = reverseLinkedNodes.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3);
        ListNode listNode = reverseLinkedNodes.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), 3);
        System.out.println(listNode);
        printListNode(listNode);
    }

    private static void printListNode(ListNode listNode) {
        ListNode pointer = listNode;
        String tab = "\t";
        System.out.println("List Node : \n"+pointer.val);
        while (pointer.next!=null){
            System.out.println(tab+pointer.next.val);
            pointer = pointer.next;
            tab = tab.concat("\t");
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1,head);
        ListNode temp=head;
        ListNode start=dummy;
        int i=0;
        while(temp!=null) {
            i++;
            if(i%k==0) {
                start=reverse(start,temp.next);
                temp=start.next;
            } else {
                temp=temp.next;
            }

        }
        return dummy.next;
    }

    private ListNode reverse(ListNode start,ListNode end) {
        ListNode prev=null;
        ListNode head=start.next;
        ListNode first = head;
        while(head!=end) {
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        start.next=prev;
        first.next=head;
        return first;
    }

    public ListNode reverseKGroupMySolution(ListNode head, int k) {
        ListNode result = new ListNode();
        ListNode result_pointer = result;
        int i=0;
        int resultNode=0;
        List<ListNode> listNodeList = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        System.out.println("k="+k);
        while (head!=null){
            i++;
            listNodeList.add(head);
            stack.push(head);
            head = head.next;
            if (i%k==0){
                ListNode temp_result = new ListNode();
                ListNode temp_result_pointer = temp_result;
                for (int j=i-1;j>=i-k;j--){
                    temp_result_pointer.next = stack.pop();
                    temp_result_pointer=temp_result_pointer.next;
                }
                result_pointer.next = temp_result.next;
                result_pointer = result_pointer.next;
                resultNode--;
            }else{
                resultNode++;
            }
            if (head==null){
                ListNode temp_result = new ListNode();
                ListNode temp_result_pointer = temp_result;
                if(!stack.isEmpty()){
                    for (int j=0;j<stack.size();j++){
                        temp_result_pointer.next = stack.remove(j);
                        temp_result_pointer=temp_result_pointer.next;
                    }
                }
                ListNode prev=result_pointer;
                for (int m=0;m<resultNode;m++) {
                    if(result_pointer.next!=null && prev!=result_pointer.next) {
                        result_pointer = result_pointer.next;
                    }
                    prev=result_pointer;
                }
                result_pointer.next = temp_result.next;
            }
        }
        return result.next;
    }
}
