package packageFiles;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class StatusFile {

    public static void updateStatus(Path path, int index, byte status) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(path.toFile(), "rw");
             FileChannel channel = raf.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(1);
            buffer.put(status);
            buffer.flip();

            channel.write(buffer, index);
        }
    }

    public static byte readStatus(Path path, int index) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(path.toFile(), "r");
             FileChannel channel = raf.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(1);

            channel.read(buffer, index);
            buffer.flip();

            return buffer.get();
        }
    }

    public static void printAllBytes(Path path) throws IOException {
        byte[] allBytes = Files.readAllBytes(path);
        System.out.print("Вміст файлу: ");
        for (byte b : allBytes) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}
