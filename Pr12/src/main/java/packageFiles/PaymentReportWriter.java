package packageFiles;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class PaymentReportWriter {

    public static void writeReport(Path tempPath, Path finalPath, List<Payment> payments, int invalidLines) {
        try (OutputStream os = Files.newOutputStream(tempPath);
             Writer osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(osw)) {

            long paidTotalCents = 0;
            int n = 0, p = 0, f = 0;

            for (Payment payment : payments) {
                if (payment.status() == PaymentStatus.PAID) paidTotalCents += payment.amountCents();
                if (payment.status() == PaymentStatus.NEW) n++;
                else if (payment.status() == PaymentStatus.PAID) p++;
                else if (payment.status() == PaymentStatus.FAILED) f++;
            }

            writer.write("invalidLines=" + invalidLines);
            writer.newLine();
            writer.write("paidTotalCents=" + paidTotalCents);
            writer.newLine();
            writer.write(String.format("NEW=%d, PAID=%d, FAILED=%d", n, p, f));
            writer.newLine();

        } catch (IOException e) {
            System.err.println("Помилка запису чернетки: " + e.getMessage());
            return;
        }
        try {
            if (Files.notExists(finalPath.getParent())) {
                Files.createDirectories(finalPath.getParent());
            }

            Files.move(tempPath, finalPath,
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.ATOMIC_MOVE);

            System.out.println("Файл успішно переміщено в data/report.txt");
        } catch (IOException e) {
            System.err.println("Помилка при переміщенні: " + e.getMessage());
        }
    }
}
