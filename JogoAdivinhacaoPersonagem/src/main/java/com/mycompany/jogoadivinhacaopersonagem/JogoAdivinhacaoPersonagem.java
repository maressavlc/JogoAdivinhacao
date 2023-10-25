/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jogoadivinhacaopersonagem;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class JogoAdivinhacaoPersonagem {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JogoInterface::new);
    }

    public static class JogoInterface extends JFrame {

        private boolean encontrouPersonagem = false;

        public JogoInterface() {
            try {
                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                
            }

            setTitle("Jogo Akinator de Personagens de Shrek");
            setSize(600, 400);  
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            iniciarJogo();
        }

        

        private void iniciarJogo() {
            JOptionPane.showMessageDialog(this,
                    "Bem-vindo ao Jogo de Advinhação de Personagens de Shrek!\n"
                            + "             Pense em um personagem e clique em OK.");

            while (!encontrouPersonagem) {
                boolean isVilao = perguntaGeral("O personagem é um Vilão? (Sim/Não)");

                if (isVilao) {
                    boolean fadaMadrinha = perguntaFadaMadrinha();
                    if (fadaMadrinha) {
                        JOptionPane.showMessageDialog(this, "Seu personagem é a Fada Madrinha!");
                        encontrouPersonagem = true;
                    } else {
                        boolean encantado = perguntaEncantado();
                        if (encantado) {
                            JOptionPane.showMessageDialog(this, "Seu personagem é o Príncipe Encantado!");
                            encontrouPersonagem = true;
                        } else {
                            boolean lordFarquaad = perguntaLordFarquaad();
                            if (lordFarquaad) {
                                JOptionPane.showMessageDialog(this, "Seu personagem é o Lord Farquaad!");
                                encontrouPersonagem = true;
                            } else {
                                boolean rumpelstiltskin = perguntaRumpelstiltskin();
                                if (rumpelstiltskin) {
                                    JOptionPane.showMessageDialog(this, "Seu personagem é o Rumpelstiltskin!");
                                    encontrouPersonagem = true;
                                } else {
                                    naoEncontrado();
                                }
                            }
                        }
                    }
                } else {
                    boolean shrek = perguntaShrek();
                    if (shrek) {
                        JOptionPane.showMessageDialog(this, "Seu personagem é o Shrek!");
                        encontrouPersonagem = true;
                    } else {
                        boolean fiona = perguntaFiona();
                        if (fiona) {
                            JOptionPane.showMessageDialog(this, "Seu personagem é a Princesa Fiona!");
                            encontrouPersonagem = true;
                        } else {
                            boolean burro = perguntaBurro();
                            if (burro) {
                                JOptionPane.showMessageDialog(this, "Seu personagem é o Burro!");
                                encontrouPersonagem = true;
                            } else {
                                boolean gatoDeBotas = perguntaGatoDeBotas();
                                if (gatoDeBotas) {
                                    JOptionPane.showMessageDialog(this, "Seu personagem é o Gato de Botas!");
                                    encontrouPersonagem = true;
                                } else {
                                    naoEncontrado();
                                }
                            }
                        }
                    }
                }
            }

            dispose();
        }

        private boolean perguntaGeral(String pergunta) {
            int resposta = JOptionPane.showOptionDialog(this, pergunta, "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Sim", "Não"}, null);
            return resposta == JOptionPane.YES_OPTION;
        }

        private boolean perguntaShrek() {
            return perguntaGeral("O personagem é um ogro?")
                    && perguntaGeral("O personagem vive em um pântano?")
                    && perguntaGeral("O personagem se apaixona por uma princesa?")
                    && perguntaGeral("O personagem é o protagonista principal da série?");
        }

        private boolean perguntaFiona() {
            return perguntaGeral("O personagem é uma princesa?")
                    && perguntaGeral("O personagem é humano ou ogro?")
                    && perguntaGeral("O personagem se transforma em um ogro à noite?")
                    && perguntaGeral("O personagem é casado com Shrek?");
        }

        private boolean perguntaBurro() {
            return perguntaGeral("O personagem é um burro falante?")
                    && perguntaGeral("O personagem é o melhor amigo de Shrek?")
                    && perguntaGeral("O personagem gosta de cantar?")
                    && perguntaGeral("O personagem é corajoso e leal?");
        }

        private boolean perguntaGatoDeBotas() {
            return perguntaGeral("O personagem é um gato com botas?")
                    && perguntaGeral("O personagem é habilidoso em esgrima?")
                    && perguntaGeral("O personagem é charmoso e astuto?")
                    && perguntaGeral("O personagem tem uma ligação com o personagem Shrek?");
        }

        private boolean perguntaFadaMadrinha() {
            return perguntaGeral("O personagem é uma fada?")
                    && perguntaGeral("O personagem é conhecido por usar magia?")
                    && perguntaGeral("O personagem é uma antagonista principal em algum filme?")
                    && perguntaGeral("O personagem tem um papel significativo na trama de 'Shrek 2'?");
        }

        private boolean perguntaEncantado() {
            return perguntaGeral("O personagem é um príncipe?")
                    && perguntaGeral("O personagem é conhecido por sua beleza e vaidade?")
                    && perguntaGeral("O personagem é um antagonista em algum filme da série?")
                    && perguntaGeral("O personagem tem um interesse romântico em Princesa Fiona?");
        }

        private boolean perguntaLordFarquaad() {
            return perguntaGeral("O personagem é um líder autoritário?")
                    && perguntaGeral("O personagem tem uma postura orgulhosa e arrogante?")
                    && perguntaGeral("O personagem é o principal antagonista do primeiro filme?")
                    && perguntaGeral("O personagem quer se casar com Princesa Fiona?");
        }

        private boolean perguntaRumpelstiltskin() {
            return perguntaGeral("O personagem é conhecido por fazer acordos mágicos?")
                    && perguntaGeral("O personagem é um antagonista em 'Shrek para Sempre'?")
                    && perguntaGeral("O personagem tem uma história associada à magia e ao encanto?")
                    && perguntaGeral("O personagem tem um papel importante na trama da quarta parte da série?");
        }

        private void naoEncontrado() {
            JOptionPane.showMessageDialog(this, "Não foi possível adivinhar o personagem. Por favor, tente novamente.");
        }
    }
}