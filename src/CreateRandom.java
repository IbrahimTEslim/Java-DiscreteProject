import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class CreateRandom {
    public static void CreateRandomFile(long size) throws IOException {
        FileOutputStream out = new FileOutputStream("random.txt");
        StringBuilder randChars = new StringBuilder();
        for (int i = 0; i < size; i++) {
            Random r = new Random();
            int randCh = r.nextInt();
            randChars.append(randCh);
        }
        out.write(randChars.toString().getBytes());
        out.close();
    }
}
