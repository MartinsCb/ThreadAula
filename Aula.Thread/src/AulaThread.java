import javax.swing.JOptionPane;

public class AulaThread {

    public static void main(String[] args) throws InterruptedException {
        
        // Criar e iniciar a primeira thread para enviar emails
        Thread threadEmail = new Thread(thread1);
        threadEmail.start();
       
        // Criar e iniciar a segunda thread para enviar notas fiscais
        Thread threadNotaFiscal = new Thread(thread2);
        threadNotaFiscal.start();
        
        // Mensagem principal do programa
        JOptionPane.showConfirmDialog(null, "Sistema continua executando para o usuário");
        System.out.println("Chegou ao fim o teste de Thread");
    }    
    
    // Definição da primeira thread
    private static Runnable thread1 = new Runnable() {
        @Override 
        public void run() {
            for (int pos = 0; pos < 10; pos++) {
                try {
                    // Programa uma pausa de 1 segundo
                    Thread.sleep(1000);
                    System.out.println("Rodagem do código paralelo 1");   
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Executando alguma rotina, por exemplo o envio de um email");
            }
        }
    };
    
    // Definição da segunda thread
    private static Runnable thread2 = new Runnable() {
        @Override 
        public void run() {
            for (int pos = 0; pos < 10; pos++) {
                try {
                    // Programa uma pausa de 1 segundo
                    Thread.sleep(1000);
                    System.out.println("Rodagem do código paralelo 2");   
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Executando alguma rotina, por exemplo o envio de nota fiscal");
            }
        }
    };
}












