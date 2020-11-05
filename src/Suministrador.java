/*Tarea online 1 - PSP - Víctor Pareja Ramírez*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLock;

public class Suministrador {

    public static int length = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
        String fileName = args[0];
        writeFile(fileName);
    }

    public static void writeFile(String fileName) throws IOException, InterruptedException {
        RandomAccessFile raf = null;
        FileLock fileLock = null;
        File file;
        int iterationTimes = 1;

        file = new File(fileName);
        while (iterationTimes <= 15) {
            try {
                raf = new RandomAccessFile(file, "rwd");
                fileLock = raf.getChannel().lock();
                if (raf.length() == 0 || raf.readInt() == 0) {
                    System.out.println("Suministrador: Escribe");
                    amountofNumbers();
                    int randomNumber;
                    for (int i = 0; i < length; i++) {
                        randomNumber = (int) (Math.random() * 20 + 1);
                        System.out.println("Numero " + i + ": " + randomNumber);
                        raf.writeInt(randomNumber);
                    }
                } else {
                    System.out.println("Suministrador: Esperando a ser leido.");
                }
                //Escritura finalizada
                LogFile.writeLogFile("Suministrador.");
                fileLock.release();
                raf.close();
                fileLock = null;
                Thread.sleep(3000);
            } catch (ClosedChannelException e) {
                e.printStackTrace();
            }
            iterationTimes++;
        }
        raf = new RandomAccessFile(file, "rwd");
        raf.writeInt(0);
    }

    public static void amountofNumbers() {
        length = (int) (Math.random() * 5 + 1);// Amount of number to generate
    }
}