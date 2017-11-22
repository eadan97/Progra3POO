package Server;

public class EmailHandler extends Thread {

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("*********Test");
                sleep(300000);


            } catch (InterruptedException e) {
                System.out.println("Hubo un problema al pausar el hilo de EmailHandler: "+e.getMessage());
            }
        }
    }
}
