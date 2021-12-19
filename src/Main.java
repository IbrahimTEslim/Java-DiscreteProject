import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) throws IOException {
        try {
            Scanner input = new Scanner(System.in);
            String key, path;
            while (true) {
                System.out.println("Select:\n1- Enter a File\n2- Random File\n3- Exit");
                int bigChoice = input.nextInt();
                switch (bigChoice) {
                    case 1:
                        System.out.println("Choose:\n1- Encrypt\n2- Decrypt\n3- Exit");
                        int choice = input.nextInt();
                        switch (choice) {
                            case 1:
                                ClearConsole();
                                System.out.print("\nEnter a Key to encrypt with: ");
                                key = input.next();
                                System.out.print("Enter a file path to encrypt: ");
                                path = input.next();
                                System.out.println("\nEncrypting...");
                                EncryptionDecryption.encrypteFile(path, EncryptionDecryption.calculateShiftFromKey(key));
                                System.out.println("Done.");
                                break;
                            case 2:
                                ClearConsole();
                                System.out.print("\nEnter a Key to decrypt with: ");
                                key = input.next();
                                System.out.print("Enter a file path to decrypt: ");
                                path = input.next();
                                System.out.println("\nDecrypting...");
                                EncryptionDecryption.decrypteFile(path, EncryptionDecryption.calculateShiftFromKey(key));
                                System.out.println("Done.");
                                break;
                            case 3:
                                System.exit(0);
                            default:
                                System.out.println("Not a Valid Choice !");

                        }
                        break;
                    case 2:
                        System.out.println("Enter the size of the random file: ");
                        long size = input.nextLong();
                        System.out.println("Generating...");
                        CreateRandom.CreateRandomFile(size);
                        System.out.println("Done.");
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Not a Valid Choice");
                }
            }
        }
        catch (IOException e){
            System.out.println("\n\nUnknown path to File || Does Not Exist");
        }
        catch (Exception e){
            System.out.println("\n\nUnknown Error !. Need to be reviewed ");
        }
    }
}
