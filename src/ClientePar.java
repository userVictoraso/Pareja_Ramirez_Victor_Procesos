/*Tarea online 1 - PSP - Víctor Pareja Ramírez*/

import java.io.*;
import java.nio.channels.FileLock;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.OverlappingFileLockException;

public class ClientePar extends Cliente {

    public static void main(String[] args) throws IOException, InterruptedException {
        String fileName = args[0];
        readFileData(fileName);
    }

    public static void readFileData(String fileName) throws IOException, InterruptedException {
        int iterationTimes = 1;
        while (iterationTimes <= 15) {
            try {
                int[] arrayIntNumbers = Cliente.readFile(fileName);
                boolean isEven = kindOfNumber(arrayIntNumbers);

                if (isEven) {
                    System.out.println("***************");
                    System.out.println("Numero par.");
                    Cliente.showResult(arrayIntNumbers);
                    System.out.println();
                    Cliente.showAverage(arrayIntNumbers);
                    System.out.println("***************");
                    Cliente.emptyFile(fileName);
                }
                LogFile.writeLogFile("Cliente par.");
                Thread.sleep(1000);
            } catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            } catch (NonWritableChannelException e) {
                e.printStackTrace();
            } catch (OverlappingFileLockException e){
                e.printStackTrace();
            }
            iterationTimes++;
        }

        /*
         * int iterationTimes = 0; while (iterationTimes <= 10) { iterationTimes++; }
         */
    }

    private static boolean kindOfNumber(int[] arrayIntNumbers) {
        try {
            if (arrayIntNumbers[0] % 2 == 0) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Esperando");
        }
        return false;
    }

}
