package com.quickhome.util;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/12/14 9:04
 */
public class HandlePath {
    public static String extractRelativePath(String fullPath, String startPath) {
        int index = fullPath.indexOf(startPath);
        if (index != -1) {
            return fullPath.substring(index);
        }
        return fullPath;
    }
}
