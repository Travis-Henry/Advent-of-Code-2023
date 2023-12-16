import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {
    private File file;
    private BufferedReader input;

    public FileLoader(String path) {
        file = new File("src\\" + path);
        if (!file.exists()) {
            System.out.println("File with the path: " + path + " does not exist");
        } else {
            try {
                input = new BufferedReader(new FileReader(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getNextLine() {
        try {
            return input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void close() {
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
