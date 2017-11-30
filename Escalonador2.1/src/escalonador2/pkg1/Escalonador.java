/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador2.pkg1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Escalonador {

    private Graphics2D g2;
    int i;
    JPanel opcoes = new JPanel();
    JFrame janela = new JFrame("Escalonador");
    JButton bAutomaicoFCFS, bManualFCFS, bAutomaticoSJF, bManualSJF, bLimpa, bAjuda;
    JTextArea saida = new JTextArea();
    JScrollPane barra = new JScrollPane(saida);

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Processos p = new Processos();
            //p.setNProcessos(100);

            /*for(int i = 0; i < 100; i ++)
        {
            p.setChegada(i+1, i);
            p.setDuracao(i+1, i);
        }*/
            if (e.getSource() == bAutomaicoFCFS) {
                String aux = JOptionPane.showInputDialog("Digite a Quantidade de Processos");
                p.setNProcessos(Integer.parseInt(aux));
                System.out.println("" + p.getNProcessos());
                for (int i = 0; i < p.getNProcessos(); i++) {
                    Random r = new Random();
                    p.setChegada(r.nextInt(10) + 1, i);
                    p.setDuracao(r.nextInt(10) + 1, i);
                    System.out.println("" + p.getNProcessos() + "\t" + p.tChegada[i] + "\t" + p.tDuracao[i]);
                }
                p.FCFS();
                for (i = 0; i < p.getNProcessos(); i++) {
                    saida.append("\tProcesso:" + (i + 1) + "\tTempo de Chegada: " + p.tChegada[i] + "\tTempo de Duracao: " + p.tDuracao[i] + "\tTempo Corrido: " + p.tCorrido[i] + "\tTurnArround: " + (p.tAt[i]) + "\tTempo de Espera: " + p.tEspera[i] + "\n");
                }
                saida.append("\n\tTempo médio de espera: " + p.atEspera / p.getNProcessos() + "\n\tTempo médio de TurnArround: " + p.aAt / p.getNProcessos());

            } else if (e.getSource() == bManualFCFS) {
                String aux = JOptionPane.showInputDialog("Digite a Quantidade de Processos");
                p.setNProcessos(Integer.parseInt(aux));
                for (i = 0; i < p.getNProcessos(); i++) {
                    aux = JOptionPane.showInputDialog("Digite o tempo de duracao do processo:" + (i + 1));
                    p.setDuracao(Integer.parseInt(aux), i);
                    aux = JOptionPane.showInputDialog("Digite o tempo de duracao do processo:" + (i + 1));
                    p.setChegada(Integer.parseInt(aux), i);

                }
                p.FCFS();
                for (i = 0; i < p.getNProcessos(); i++) {
                    saida.append("\tProcesso:" + (i + 1) + "\tTempo de Chegada: " + p.tChegada[i] + "\tTempo de Duracao: " + p.tDuracao[i] + "\tTempo Corrido: " + p.tCorrido[i] + "\tTurnArround: " + (p.tAt[i]) + "\tTempo de Espera: " + p.tEspera[i] + "\n");
                }
                saida.append("\n\tTempo médio de espera: " + p.atEspera / p.getNProcessos() + "\n\tTempo médio de TurnArround: " + p.aAt / p.getNProcessos());

            } else if (e.getSource() == bAutomaticoSJF) {
                String aux = JOptionPane.showInputDialog("Digite a Quantidade de Processos");
                p.setNProcessos(Integer.parseInt(aux));
                System.out.println("" + p.getNProcessos());
                for (int i = 0; i < p.getNProcessos(); i++) {
                    Random r = new Random();
                    p.setChegada(r.nextInt(10) + 1, i);
                    p.setDuracao(r.nextInt(10) + 1, i);
                    System.out.println("" + p.getNProcessos() + "\t" + p.tChegada[i] + "\t" + p.tDuracao[i]);
                }
                p.SJF();
                for (i = 0; i < p.getNProcessos(); i++) {
                    saida.append("\tProcesso:" + (i + 1) + "\tTempo de Chegada: " + p.tChegada[i] + "\tTempo de Duracao: " + p.tDuracao[i] + "\tTempo Corrido: " + p.tCorrido[i] + "\tTurnArround: " + (p.tAt[i]) + "\tTempo de Espera: " + p.tEspera[i] + "\n");
                }
                saida.append("\n\tTempo médio de espera: " + p.atEspera / p.getNProcessos() + "\n\tTempo médio de TurnArround: " + p.aAt / p.getNProcessos());

            } else if (e.getSource() == bManualSJF) {
                String aux = JOptionPane.showInputDialog("Digite a Quantidade de Processos");
                p.setNProcessos(Integer.parseInt(aux));
                for (i = 0; i < p.getNProcessos(); i++) {
                    aux = JOptionPane.showInputDialog("Digite o tempo de duracao do processo:" + (i + 1));
                    p.setDuracao(Integer.parseInt(aux), i);
                    aux = JOptionPane.showInputDialog("Digite o tempo de duracao do processo:" + (i + 1));
                    p.setChegada(Integer.parseInt(aux), i);

                }
                p.SJF();
                for (i = 0; i < p.getNProcessos(); i++) {
                    saida.append("\tProcesso:" + (i + 1) + "\tTempo de Chegada: " + p.tChegada[i] + "\tTempo de Duracao: " + p.tDuracao[i] + "\tTempo Corrido: " + p.tCorrido[i] + "\tTurnArround: " + (p.tAt[i]) + "\tTempo de Espera: " + p.tEspera[i] + "\n");
                }
                saida.append("\n\tTempo médio de espera: " + p.atEspera / p.getNProcessos() + "\n\tTempo médio de TurnArround: " + p.aAt / p.getNProcessos());

            } else if (e.getSource() == bLimpa) {
                saida.setText("");
            } else if(e.getSource() == bAjuda)
            {
                JTextArea textArea = new JTextArea(10, 20);
             //   JScrollPane scrollPane = new JScrollPane(textArea); 
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setText("O escalonador é a parte do SO encarregada de decidir entre os processos prontos, qual será colocado em execução."
                        + " Nesta ferramenta estão disponíveis os algoritmos FCFS (First Come, First Served) em que o primeiro a chegar é o primeiro a ser executado "
                        + "e o SJF (Short Job First) em que o processo com menor duração será executado primeiro.");
                
                JFrame janela2 = new JFrame("Ajuda");
                janela2.add(textArea);
                janela2.setSize(300, 300);
                janela2.setVisible(true);
                janela2.setResizable(false);
            }
        }
    };

    void inicia() {
        Container content = janela.getContentPane();
        content.setLayout(new BorderLayout());     
        //Cria os botões e adiciona Listeners neles
        bAutomaicoFCFS = new JButton("FCFS Automático");
        bAutomaicoFCFS.addActionListener(actionListener);
        opcoes.add(bAutomaicoFCFS);
        bManualFCFS = new JButton("FCFS Manual");
        bManualFCFS.addActionListener(actionListener);
        opcoes.add(bManualFCFS);
        bAutomaticoSJF = new JButton("SJF Automático");
        bAutomaticoSJF.addActionListener(actionListener);
        opcoes.add(bAutomaticoSJF);
        bManualSJF = new JButton("SJF Manual");
        bManualSJF.addActionListener(actionListener);
        opcoes.add(bManualSJF);
        bLimpa = new JButton("Limpa");
        bLimpa.addActionListener(actionListener);
        opcoes.add(bLimpa);
        bAjuda = new JButton("Ajuda");
        bAjuda.addActionListener(actionListener);
        opcoes.add(bAjuda);
        
        opcoes.add(saida);

        //Adiciona o panel com botões ao topo da nossa janela
        content.add(opcoes, BorderLayout.NORTH);
        //content.add(saida, BorderLayout.EAST);
        saida.setVisible(true);
        saida.setEditable(false);
        saida.setSize(300, 300);
        //Seta tamanho, visibilidade e opção de sair do programa ao fechar

        //JScrollPane barra2 = new JScrollPane(saida, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        barra.setBounds(10, 60, 780, 500);
        barra.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        barra.setViewportView(saida);
        janela.getContentPane().add(barra);
        janela.setSize(600, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    public static void main(String[] args) {
        new Escalonador().inicia();
    }

}
