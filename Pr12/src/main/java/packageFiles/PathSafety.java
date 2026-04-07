package packageFiles;

import java.nio.file.Path;

public class PathSafety {

    public static Path safeResolve(Path base, String userInput) {
        Path resolvedPath = base.resolve(userInput).normalize();
        if (!resolvedPath.startsWith(base.normalize())) {
            throw new IllegalArgumentException("Спроба вийти за межі: " + userInput);
        }
        return resolvedPath;
    }
}
