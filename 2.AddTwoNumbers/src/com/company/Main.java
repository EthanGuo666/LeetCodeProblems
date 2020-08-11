package com.company;

import java.math.BigInteger;
import com.company.Package.*;

public class Main {
    public static void show(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static ListNode create(int arr[]) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i = 0; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        current = null;
        return head.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        BigInteger times = new BigInteger("1");
        BigInteger _10 = new BigInteger("10");
        BigInteger num1 = new BigInteger("0");
        BigInteger num2 = new BigInteger("0");
        while (p != null) {
            //读进来
            String Digit = Integer.toString(p.val);
            BigInteger crtDigit = new BigInteger(Digit);
            //乘倍数
            crtDigit = crtDigit.multiply(times);
            //加
            num1 = num1.add(crtDigit);
            //倍数*10
            times = times.multiply(_10);
            //移动p
            p = p.next;
        }
        p = l2;
        times = new BigInteger("1");
        while (p != null) {
            //读进来
            String Digit = Integer.toString(p.val);
            BigInteger crtDigit = new BigInteger(Digit);
            //乘倍数
            crtDigit = crtDigit.multiply(times);
            //加
            num2 = num2.add(crtDigit);
            //倍数*10
            times = times.multiply(_10);
            //移动p
            p = p.next;
        }
        BigInteger sum = num1.add(num2);
        String s = sum.toString();
        //System.out.println(sum);

        ListNode head = new ListNode(0);
        p = head;
        for (int i = s.length() - 1; i >= 0; i--) {
            //把结果s倒序输入链表
            p.next = new ListNode(s.charAt(i)-'0');
            p=p.next;
        }
        p = null;

        //展示结果
        //show(head.next);
        return head.next;
    }

    public static void main(String[] args) throws Exception{
        int arr1[] = {1, 3, 2};
        ListNode head1 = create(arr1);
        //show(head1);

        int arr2[] = {2, 2, 2};
        ListNode head2 = create(arr2);
        //show(head2);

        ListNode sum = new ListNode(0);
        sum = addTwoNumbers(head1, head2);
    }
}