/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador2;

/**
 *
 * @author rafael
 */
import java.util.Random;

/**
 *
 * @author rafael
 */
public class Escalonador {

   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Processos p = new Processos();
        p.setNProcessos(100);
        /*p.tChegada[0] = 1;
        p.tChegada[1] = 2;
        p.tDuracao[0] = 3;
        p.tDuracao[1] = 3;
        p.tEspera [0] = 0;*/
        //p.inicializar();
        
        for(int i = 0; i < 100; i ++)
        {
            Random r = new Random();
            /*p.tChegada[i] = r.nextInt(10)+1;
            p.tDuracao[i] = r.nextInt(10)+1;*/
            
            p.setChegada(r.nextInt(10) +1, i);
            p.setDuracao(r.nextInt(10) +1, i);
        }
       
        p.FCFS();
    }
    
}
