package AulaThread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementFileThread extends Thread {
    
    private static ConcurrentLinkedQueue<ObjectFileThread> pilha_fila = new ConcurrentLinkedQueue<ObjectFileThread>();
    
    public static void add(ObjectFileThread objFT) {
        pilha_fila.add(objFT);
    }
    
    @Override
    public void run() {
        System.out.println("Fila rodando");
        
        while (true) {
            Iterator<ObjectFileThread> iteracao = pilha_fila.iterator();
            
            while (iteracao.hasNext()) { // enquanto houver dados na lista irá processar
                ObjectFileThread processar = iteracao.next(); // pega o objeto atual
                
                // processa todos os dados
                System.out.println("Processing: " + processar.getName() + " - " + processar.getEmail());
                iteracao.remove(); // parte, processa e remove
                
                try {
                    Thread.sleep(100); // dar tempo para descarga de memória
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            try {
                Thread.sleep(1000); // processa toda a lista e dá um tempo para limpeza de memória
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addFila(ObjectFileThread filaThread) {
        add(filaThread);
    }
    
    public void stopFila() {
        System.out.println("Fila parada");
        interrupt(); // Interrompe a thread da fila
    }
    
    public void readFila() {
        System.out.println("Lendo a fila");
        for (ObjectFileThread item : pilha_fila) {
            System.out.println("Name: " + item.getName() + ", Email: " + item.getEmail());
        }
    }
}
