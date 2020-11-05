/*Tarea online 1 - PSP - Víctor Pareja Ramírez*/

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogFile {
    
    public static void writeLogFile(String user) throws InterruptedException {
        Logger logger = Logger.getLogger("Suministrador-Cliente Log");
        FileHandler fh;
        String fileName = "registro_entradas.log";

        try {
            // This block configure the logger with handler and formatter
            fh = new FileHandler(fileName, true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.info(user);
            Thread.sleep(1000);
            fh.close();
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
