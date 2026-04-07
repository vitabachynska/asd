package packageFiles;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PaymentLoader {

    public static LoadResult loadWithStats(Path csvPath) {
        List<Payment> payments = new ArrayList<>();
        int invalidLines = 0;
        try (InputStream in = Files.newInputStream(csvPath);
             Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(reader)) {

            String line = br.readLine();

             while ((line = br.readLine()) != null) {
                 if (line.isBlank()) continue;
                 try {
                    payments.add(parseLine(line));
                 } catch (Exception e) {
                    invalidLines++;
                 }
             }
        } catch (IOException e) {
            System.err.println("Помилка доступу до файлу: " + e.getMessage());
        }
        return new LoadResult(payments, invalidLines);
    }

    private static Payment parseLine(String line) {
        String[] parts = line.split(",");
        if (parts.length != 4) throw new IllegalArgumentException();

        return new Payment(
                Long.parseLong(parts[0].trim()),
                parts[1].trim(),
                PaymentStatus.valueOf(parts[2].trim().toUpperCase()),
                Long.parseLong(parts[3].trim())
        );
    }
}
