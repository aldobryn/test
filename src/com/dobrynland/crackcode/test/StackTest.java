package com.dobrynland.crackcode.test;

import com.dobrynland.crackcode.MyStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by Alexandra on 28.01.2017.
 */

public class StackTest
{
    @Test
    public void TestMin()
    {
        MyStack stack = new MyStack();
        stack.push(5);
        stack.push(2);
        stack.push(8);
        Integer min = 2;
        assertEquals(min, stack.getMin());

    }


}
