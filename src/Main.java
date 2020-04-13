import java.io.*;
import java.util.Scanner;

public class Main {
    void copyFileUsingJava7Files(File source, File dest) throws Exception{

    }

    private static void copyFileUsingStream(File source, File dest) throws Exception{
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0){
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter source file: ");
        String sourcePath = scanner.nextLine();
        System.out.println("Enter destination file: ");
        String destPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingStream(sourceFile, destFile);
            System.out.println("copy completed");
        } catch (Exception ioe){
            System.out.println("Can't copy that file");
            System.out.println(ioe.getMessage());
        }
    }
}
