package org.com.hermopolis.unsafe;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;


public class UnSafeTest {


    public static void main(String[] args) {
        Unsafe unsafe = reflectGetUnsafe();
        int size = 4;
        long addr = unsafe.allocateMemory(size);//分配新的本地空间
        long addr3 = unsafe.reallocateMemory(addr, size * 2);
        System.out.println("addr: " + addr);
        System.out.println("addr3: " + addr3);
        try {
            unsafe.setMemory(null, addr, size, (byte) 1);
            for (int i = 0; i < 2; i++) {
                unsafe.copyMemory(null, addr, null, addr3 + size * i, 4);
            }
            System.out.println(unsafe.getInt(addr));
            System.out.println(unsafe.getLong(addr3));
        } finally {
            unsafe.freeMemory(addr);
            unsafe.freeMemory(addr3);
        }
    }


    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {

            return null;
        }
    }

}
