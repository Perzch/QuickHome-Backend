package com.quickhome.util;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/24 23:28
 */

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageUtil {

    public static void deleteImg(String src) {
        try {
            Path path = Paths.get(src);
            if (Files.exists(path)) {
                Files.delete(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
