package packageFiles;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;

public class StatusFile {

    public static void updateStatus(Path path, int index, byte status) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(path.toFile(), "rw")) {
            raf.seek(index);
            raf.writeByte(status);
            System.out.println("Байт за індексом " + index + " оновлено на " + status);
        }
    }

    public static byte readStatus(Path path, int index) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(path.toFile(), "r")) {
            raf.seek(index);
            return raf.readByte();
        }
    }
    public static void printAllBytes(Path path) throws IOException {
        byte[] allBytes = Files.readAllBytes(path);
        System.out.print("Вміст файлу в байтах: ");
        for (byte b : allBytes) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}
