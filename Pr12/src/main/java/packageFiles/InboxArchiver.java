package packageFiles;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class InboxArchiver {

    public static void archiveTmpFiles(Path inbox, Path archive) {
        try {
            if (Files.notExists(archive)) {
                Files.createDirectories(archive);
            }
        } catch (IOException e) {
            System.err.println("Не вдалося створити папку архіву: " + e.getMessage());
            return;
        }

        try (Stream<Path> paths = Files.walk(inbox)) {
            paths
                    .filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".tmp"))
                    .forEach(file -> {
                        try {

                            Path target = archive.resolve(file.getFileName());

                            Files.move(file, target, StandardCopyOption.REPLACE_EXISTING);

                            System.out.println("Архівовано: " + file.getFileName());
                        } catch (IOException e) {
                            System.err.println("Помилка при переміщенні " + file + ": " + e.getMessage());
                        }
                    });
        } catch (IOException e) {
            System.err.println("Помилка обходу директорії: " + e.getMessage());
        }
    }
}
