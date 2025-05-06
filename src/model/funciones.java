package model;

import java.io.*;

public class funciones {

    // Crea una carpeta si no existe
    public static void createFolder(String folderName) {
        File folder = new File(folderName);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    // Crea un archivo o agrega contenido si ya existe
    public static void createFile(String path, String fileName, String content) {
        try {
            File file = new File(path, fileName);
            FileWriter writer = new FileWriter(file, true);
            writer.write(content + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Lista archivos en una carpeta
    public static String[] showListFiles(String path) {
        File folder = new File(path);
        String[] files = folder.list();
        return (files != null) ? files : new String[0];
    }

    // Devuelve el contenido de un archivo
    public static String showFile(String path, String fileName) {
        File file = new File(path, fileName);
        if (!file.exists()) return null;
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    // Sobrescribe el contenido de un archivo
    public static boolean overWriteFile(String path, String fileName, String newContent) {
        File file = new File(path, fileName);
        if (!file.exists()) return false;
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(newContent);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Elimina un archivo
    public static void deleteFile(String path, String fileName) {
        File file = new File(path, fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    // Cuenta los caracteres de un archivo
    public static int countChars(String path, String fileName) {
        String content = showFile(path, fileName);
        return (content != null) ? content.length() : 0;
    }

    // Cuenta las palabras de un archivo
    public static int countWords(String path, String fileName) {
        String content = showFile(path, fileName);
        return (content != null) ? content.trim().split("\\s+").length : 0;
    }

    // Reemplaza palabras en un archivo
    public static String swapWords(String path, String fileName, String oldWord, String newWord) {
        String content = showFile(path, fileName);
        if (content == null) return null;
        String updated = content.replaceAll(oldWord, newWord);
        overWriteFile(path, fileName, updated);
        return updated;
    }

    // Funcion placeholder para crear PDF
    public static void printPDF(String path, String fileName) {
        // Requiere libreria externa como iText o Apache PDFBox
    }
}
