package packageFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    static void main() throws IOException {
        //run1();
        //run2();
        //run3();
        //run4();
        run5();
    }

private static void run1(){
    Path in = Path.of("src", "main", "resources", "practical-data", "payments.csv");
    LoadResult result = PaymentLoader.loadWithStats(in);

    System.out.printf("Успішно завантажено: %d%n", result.payments().size());
    System.out.printf("Пропущено некоректних рядків: %d%n", result.invalidLines());
}

private static void run2() {
    Path in = Path.of("src", "main", "resources", "practical-data", "payments.csv");
    Path out0 = Path.of("src", "main", "resources", "report.txt");
    Path out = Path.of("src", "main", "resources", "practical-data", "report.txt");

    System.out.println("Завантаження даних");

    LoadResult result = PaymentLoader.loadWithStats(in);

    System.out.println("Успішно завантажено валідних платежів: " + result.payments().size());
    System.out.println("Пропущено некоректних рядків у CSV: " + result.invalidLines());

    System.out.println("\nГенерація звіту");
    PaymentReportWriter.writeReport(out0, out, result.payments(), result.invalidLines());

    System.out.println("Програма завершила роботу.");
}
private static void run3() throws IOException {

    Path baseDir = Path.of("src", "main", "resources", "practical-data");
    Path inbox = baseDir.resolve("inbox");
    Path archive = baseDir.resolve("archive");

    Files.createDirectories(inbox);
    Files.writeString(inbox.resolve("data1.txt"), "Дані");
    Files.writeString(inbox.resolve("temp1.tmp"), "Тимчасовий файл 1");
    Files.writeString(inbox.resolve("temp2.tmp"), "Тимчасовий файл 2");
    Files.writeString(inbox.resolve("notes.txt"), "Текст");

    System.out.println("Файли створено в " + inbox.toAbsolutePath());

    InboxArchiver.archiveTmpFiles(inbox, archive);

    System.out.println("Архівація завершена ");

    //System.out.println(archive.toAbsolutePath());
    }
    private static void run4() {
        Path base = Path.of("src", "main", "resources", "data").toAbsolutePath();
        try {
            Path p1 = PathSafety.safeResolve(base, "reports/2025.txt");
            System.out.println("Дозволено: " + p1);
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }

        try {
            Path p2 = PathSafety.safeResolve(base, "../secret.txt");
            System.out.println("✅ Дозволено: " + p2);
        } catch (IllegalArgumentException e) {
            System.err.println("Безпека спрацювала: " + e.getMessage());
        }
    }
    private static void run5() throws IOException {
        Path binFile = Path.of("src", "main", "resources", "status.bin");
        int fileSize = 10;
        int targetIndex = 4;
        byte newStatus = 1;

        java.nio.file.Files.write(binFile, new byte[fileSize]);
        System.out.println("Файл створено, заповнено нулями");
        StatusFile.printAllBytes(binFile);

        StatusFile.updateStatus(binFile, targetIndex, newStatus);

        byte result = StatusFile.readStatus(binFile, targetIndex);
        System.out.println("Результат читання за індексом " + targetIndex + ": " + result);

        if (result == newStatus) {
            System.out.println("Байт змінено");
        }
        StatusFile.printAllBytes(binFile);
    }
}


