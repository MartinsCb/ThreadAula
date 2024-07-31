package AulaThread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementFileThread extends Thread{
	
	private static ConcurrentLinkedQueue<ObjectFileThread> pilha_fila = 
			new ConcurrentLinkedQueue<ObjectFileThread>();
	
	public static void add(ObjectFileThread objFT) {
		pilha_fila.add(objFT);
	}
	
	
	public void Run() {
		Iterator iteracao = pilha_fila.iterator();
		
		synchronized (iteracao) { //bloqueia o acesso a lista por outros processos 
		
		while(iteracao.hasNext()) { // enquanto houver dados na lista ira processar
			
			ObjectFileThread processar = (ObjectFileThread) iteracao.next(); // pega o obejto atual
			
// processa todos os dados 
			
			iteracao.remove();
//parte,processa e remove
			
			try {
				Thread.sleep(100); // dar tempo para desgarga de memoria 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
			try {
				Thread.sleep(1000);//processa toda a lista e da um tempo para limpeza de memoria
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
	}

}
}