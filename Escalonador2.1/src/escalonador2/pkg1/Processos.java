/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador2.pkg1;

/**
 *
 * @author rafael
 */
public class Processos {

    float tEspera[];
    float tDuracao[];
    float tChegada[];
    float id[];
    float tAt[];
    float tCorrido[];

    private int nProcessos;
    float atEspera, aAt;

    Processos() {
    }

    void setNProcessos(int nProcessos) {
        this.nProcessos = nProcessos;
        inicializar();
    }

    int getNProcessos() {
        return nProcessos;
    }

    void inicializar() {
        tChegada = new float[nProcessos];
        tDuracao = new float[nProcessos];
        tEspera = new float[nProcessos];
        tAt = new float[nProcessos];
        tCorrido = new float[nProcessos];

    }

    void setDuracao(float valor, int indice) {
        tDuracao[indice] = valor;
    }

    void setChegada(float valor, int indice) {
        tChegada[indice] = valor;
    }

    void FCFS() {
        /*tChegada[0] = 1;
        tChegada[1] = 2;
        tDuracao[0] = 3;
        tDuracao[1] = 3;
        tEspera [0] = 0;*/
        tAt[0] = tDuracao[0];
        tCorrido[0] = tDuracao[0] + tChegada[0];

        for (int i = 1; i < nProcessos; i++) {
            tCorrido[i] = tCorrido[i - 1] + tDuracao[i];
            tAt[i] = tCorrido[i] - tChegada[i];
            tEspera[i] = tAt[i] - tDuracao[i];
        }

        for (int i = 0; i < nProcessos; i++) {
            atEspera = atEspera + tEspera[i];
            aAt = aAt + tAt[i];
        }
        for (int i = 0; i < nProcessos; i++) {
            System.out.println("\tTempo de Chegada: " + tChegada[i] + "\tTempo de Duracao: " + tDuracao[i] + "\tTempo Corrido: " + tCorrido[i] + "\tTurnArround: " + (tAt[i]) + "\tTempo de Espera: " + tEspera[i]);
        }

        System.out.println("Tempo médio de espera: " + atEspera / nProcessos + "Tempo médio de TurnArround: " + aAt / nProcessos);
    }

    void SJF() {

        for (int i = 0; i < nProcessos - 1; i++) {
            for (int j = i + 1; j < nProcessos; j++) {
                if (tChegada[i] > tChegada[j]) {
                    float temp = 0;
                    temp = tChegada[i];
                    tChegada[i] = tChegada[j];
                    tChegada[j] = temp;
                    temp = tDuracao[i];
                    tDuracao[i] = tDuracao[j];
                    tDuracao[j] = temp;

                }
            }
        }

        tAt[0] = tDuracao[0];
        tCorrido[0] = tDuracao[0] + tChegada[0];

        for (int i = 1; i < nProcessos; i++) {
            tCorrido[i] = tCorrido[i - 1] + tDuracao[i];
            tAt[i] = tCorrido[i] - tChegada[i];
            //tEspera[i] = tAt[i] - tDuracao[i]; 

            tEspera[i] = tCorrido[i - 1];
        }

        for (int i = 0; i < nProcessos; i++) {
            atEspera = atEspera + tEspera[i];
            aAt = aAt + tAt[i];
        }

        for (int i = 0; i < nProcessos; i++) {
            System.out.println("\tTempo de Chegada: " + tChegada[i] + "\tTempo de Duracao: " + tDuracao[i] + "\tTempo Corrido: " + tCorrido[i] + "\tTurnArround: " + (tAt[i]) + "\tTempo de Espera: " + tEspera[i]);
        }

        System.out.println("Tempo médio de espera: " + atEspera / nProcessos + "Tempo médio de TurnArround: " + aAt / nProcessos);
    }
}
