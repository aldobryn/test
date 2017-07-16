package com.dobrynland.crackcode;

import java.util.*;
/**
 * Created by Alexandra on 28.01.2017.
 */
public class MyQueue<T>
{
    Stack<T> stack1;
    Stack<T> stack2;

    public MyQueue(){
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }
    public void enqueue(T obj){
         stack1.push(obj);
    }
    public T dequeue(){

        if(stack2.empty()){
            while(!stack1.empty()){
                T obj = stack1.pop();
                stack2.push(obj);
            }
        }
        return stack2.pop();
    }
    public T peek(){
        if(stack2.empty()){
            while(!stack1.empty()){
                T obj = stack1.pop();
                stack2.push(obj);
            }
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
