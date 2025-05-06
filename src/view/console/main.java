package view.console;

import model.funciones;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;

        do {
            try {
                System.out.println("\n--- GESTION DE ARCHIVOS ---");
                System.out.println("1. Crear carpeta");
                System.out.println("2. Crear archivo");
                System.out.println("3. Listar archivos");
                System.out.println("4. Mostrar archivo");
                System.out.println("5. Sobrescribir archivo");
                System.out.println("6. Borrar archivo");
                System.out.println("7. Contar caracteres");
                System.out.println("8. Contar palabras");
                System.out.println("9. Reemplazar palabras");
                System.out.println("10. Crear PDF (no implementado)");
                System.out.println("0. Salir");
                System.out.print("Opcion: ");
                option = Integer.parseInt(sc.nextLine());

                String path, fileName, content, oldWord, newWord;

                switch (option) {
                    case 1:
                        System.out.print("Nombre carpeta: ");
                        path = sc.nextLine();
                        funciones.createFolder(path);
                        System.out.println("Carpeta creada");
                        break;

                    case 2:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        System.out.print("Contenido: ");
                        content = sc.nextLine();
                        funciones.createFile(path, fileName, content);
                        System.out.println("Archivo creado/modificado");
                        break;

                    case 3:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        String[] files = funciones.showListFiles(path);
                        for (String f : files)
                            System.out.println(" - " + f);
                        break;

                    case 4:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        content = funciones.showFile(path, fileName);
                        System.out.println("Contenido:\n" + content);
                        break;

                    case 5:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        System.out.print("Nuevo contenido: ");
                        content = sc.nextLine();
                        if (funciones.overWriteFile(path, fileName, content))
                            System.out.println("Archivo sobrescrito");
                        else
                            System.out.println("El archivo no existe");
                        break;

                    case 6:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        funciones.deleteFile(path, fileName);
                        System.out.println("Archivo borrado");
                        break;

                    case 7:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        int chars = funciones.countChars(path, fileName);
                        System.out.println("Caracteres: " + chars);
                        break;

                    case 8:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        int words = funciones.countWords(path, fileName);
                        System.out.println("Palabras: " + words);
                        break;

                    case 9:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        System.out.print("Palabra a reemplazar: ");
                        oldWord = sc.nextLine();
                        System.out.print("Nueva palabra: ");
                        newWord = sc.nextLine();
                        content = funciones.swapWords(path, fileName, oldWord, newWord);
                        System.out.println("Nuevo contenido:\n" + content);
                        break;

                    case 10:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        funciones.printPDF(path, fileName);
                        System.out.println("Funcion no implementada");
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (option != 0);

        sc.close();
    }
}
