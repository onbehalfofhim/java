package org.example;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File file = new File("binaryNumbers.bin");

        System.out.println("Enter your number:");
        short n = input.nextShort();
        writeFile(file, n);
        readFile(file);
    }

    public static void writeFile(File file, short number) {
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            ByteBuffer buffer = ByteBuffer.allocate(number * 2);

            for (short i = 1; i <= number; ++i) {
                buffer.putShort(i);
            }
            out.write(buffer.array());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(File file) {
        try (InputStream in = new BufferedInputStream(new FileInputStream(file))) {
            byte[] data = new byte[4 * 1024];

            int bytesRead = in.read(data);

            ByteBuffer buffer = ByteBuffer.wrap(data, 0, bytesRead);

            while (buffer.hasRemaining()) {
                System.out.print(buffer.getShort() + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
