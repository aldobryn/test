package com.dobrynland.crackcode;

public class MyStack
{
    Node top;
    Integer min = null;
    public MyStack()
    {
       top = null;
    }
    public void push(Integer i)
    {
         Node n = new Node(i);
         n.next = top;
         top = n;

         if(min == null)
         {
             min = i;
         }
         else
         {
             if(min > i)
                 min = i;
         }
    }
    public Integer pop()
    {
        if(top != null)
        {
           if(top.data.equals(min))
           {
               min = top.next.data;
           }
           Integer res = top.data;
           top = top.next;
           return res;
        }
        return null;
    }

    public Integer getMin()
    {
        return min;
    }
}
