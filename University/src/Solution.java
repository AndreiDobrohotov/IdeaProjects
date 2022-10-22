import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        System.out.println(encrypt("abcdefgh"));
    }

    public static ByteArrayOutputStream encrypt(String message) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] bytes = new byte[message.length()];
        byte[] mes = message.getBytes(StandardCharsets.UTF_8);
        for (int i = 0, j = 0; i < mes.length; i+=2, j++) {
            bytes[i] = mes[j];
            System.out.println(Arrays.toString(bytes));
        }
        for (int i = 1, j = mes.length - 1; i < mes.length ; i+=2, j--) {
            bytes[i] = mes[j];
            System.out.println(Arrays.toString(bytes));
        }
        out.write(bytes, 0, bytes.length);
        return out;
    }
}