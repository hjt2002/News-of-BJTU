package com.example.newsofbjtu.util;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class ImageUtil {
    public static String getImageAsBase64String(String imagePath) throws IOException {
        Path path = Path.of(imagePath);
        byte[] imageBytes = Files.readAllBytes(path);
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}