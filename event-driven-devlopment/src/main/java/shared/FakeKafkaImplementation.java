package shared;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FakeKafkaImplementation implements FakeKafkaAdapter {
    private static final String FILE_NAME = "messages.txt";

    @Override
    public void dispatch(Object message) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(message.toString());
            writer.close();
            System.out.println("Event dispached " + message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
