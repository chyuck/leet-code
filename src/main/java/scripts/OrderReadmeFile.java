package scripts;

import java.io.IOException;

public class OrderReadmeFile {

    public static void main(String[] args) {
        try {
            order();
            System.out.println("File ordered");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void order() throws IOException {
        ReadmeFileUtils.addLineAndOrderReadmeFile(0, null);
    }
}