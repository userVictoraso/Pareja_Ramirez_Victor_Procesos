/*Tarea online 1 - PSP - Víctor Pareja Ramírez*/

import java.io.File;
import java.util.Scanner;

public class Main {

    public ProcessBuilder pb = null;

    public static void main(String[] args) {
        Main main = new Main();
        String fileName = args[0];
        main.consoleMenu(fileName);
        System.out.println("Ok");
    }

    public void launchSuministrator(String fileName) {
        String className = "Suministrador";
        try {
            pb = new ProcessBuilder("java", className, fileName);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

            Process proc = pb.start();
            System.out.println( "Job running" );
            proc.waitFor(); 
            System.out.println( "Job finished" );
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchOddClient(String fileName) {
        String className = "ClienteImpar";
        try {
            pb = new ProcessBuilder("java", className, fileName);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

            Process proc = pb.start();
            System.out.println( "Job running" );
            proc.waitFor();
            System.out.println( "Job finished" );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchEvenClient(String fileName) {
        String className = "ClientePar";
        try {
            pb = new ProcessBuilder("java", className, fileName);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

            Process proc = pb.start();
            System.out.println( "Job running" );
            proc.waitFor();
            System.out.println( "Job finished" );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consoleMenu(String fileName) {
        Scanner s = new Scanner(System.in);
        System.out.println("1.- Lanzar suministrador (15 veces)");
        System.out.println("2.- Lanzar cliente par (15 veces)");
        System.out.println("3.- Lanzar cliente impar (15 veces)");
        System.out.println("4.- Salir");

        int option = s.nextInt();
        boolean end = true;

        while(end){
            switch (option) {
                case 1:
                    launchSuministrator(fileName);
                    break;
                case 2:
                    launchEvenClient(fileName);
                    break;
                case 3:
                    launchOddClient(fileName);
                    break;
                case 4:
                    end = false;
                    break;
                default:
                    System.out.println("Selecciona una opción.");
                    break;
            }
        }


    }

}
