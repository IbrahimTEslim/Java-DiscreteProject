import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

public class EncryptionDecryption {

    public static void encrypteFile(String path, int key) throws IOException {
        String actual = readAllBytes(path);
        byte[] buffer = actual.getBytes();
        byte[] output = new byte[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            output[i] = (byte) ((buffer[i] + key)%256);
        }
        FileOutputStream resFile = new FileOutputStream(path);
        resFile.write(output);
        resFile.close();
    }
    public static int calculateShiftFromKey(String key){
        long sum = key.length();
        key = key.toLowerCase(Locale.ROOT);
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return (int) (sum%26);
    }
    public static void decrypteFile(String path, int key) throws IOException {
        String actual = readAllBytes(path);
        byte[] buffer = actual.getBytes();
        byte[] output = new byte[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            output[i] = (byte) ((buffer[i] - key)%256);
        }
        FileOutputStream resFile = new FileOutputStream(path);
        resFile.write(output);
        resFile.close();
    }
    private static String readAllBytes(String filePath) {
        String content = "";

        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return content;
    }


}
