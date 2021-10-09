package FileReader;

import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class Files {
    public static void main(String[] args) {
        File dir = new File("D:\\Test");
        readFiles(dir);
    }


    public static void readFiles(File baseDirectory){
        if (baseDirectory.isDirectory()){
            for (File file : Objects.requireNonNull(baseDirectory.listFiles())) {
                if(file.isFile()){
                    System.out.println(file.getName() + " - file");
                }else {
                    System.out.println(file.getName() + " - folder");
                    readFiles(file);
                }
            }
        }
    }
}
