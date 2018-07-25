package misc;


import java.nio.ByteOrder;

public class HostByteOrder {


    /*
     * Write a program to determine the host byte order of any system.
      *
      * Runtime Complexity:
      * Constant, O(1).
      *
      * Memory Complexity:
      * Constant, O(1)
      *
      * Here is how to determine the endianness of the system.
      *
      * Step 1: Put a value (where each byte is unique) in an integer.
      * Step 2: Reference the integer using a char pointer (P).
      * Step 3: If the value of char pointer (*P) equals the least significant byte in value,
      * the host is little endian. Otherwise, it's big endian.
      *
     * */

    public static ByteOrder findHostByteOrder() {
        return ByteOrder.nativeOrder();
    }


    public static void main(String[] args) {
        System.out.println(findHostByteOrder());
        assert (findHostByteOrder().equals(ByteOrder.LITTLE_ENDIAN));
    }
}
