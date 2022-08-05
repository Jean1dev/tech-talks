import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class ConsumerMockStart {

    public static void main(String[] args) {
        File file = new File("messages.txt");

        while (true) {
            try {
                Thread.sleep(2000);
                if (file.exists()) {
                    System.out.println("Event readable ");
                    Scanner scanner = new Scanner(file);

                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }

                    scanner.close();
                    Files.delete(file.toPath());
                }
                System.out.println("Wainting other events ");
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
