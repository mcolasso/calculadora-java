package br.edu.etec.CalculadoraSwing.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Admin
 */
public class JCalculadora extends javax.swing.JFrame {

    private double res; // Guarda o resultado anterior
    private double ent; // Guarda o valor digitado

    /**
     * Creates new form JCalculadora
     */
    public JCalculadora() {
        initComponents();
        res = 0;
        ent = 0;
        Resultado.setText(Double.toString(res)); // Exibe "0.0" no resultado
        Entrada.setText(""); // Garante que a entrada esteja vazia
        // Centraliza a janela
        this.setLocationRelativeTo(null);
    }

    /**
     * MÉTODOS DE DESIGN (Recriado para ser Azul Claro e Simples)
     * Apenas visualização, a lógica chama os métodos originais abaixo.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        // --- Paleta de Cores Azul Claro Simplão ---
        Color corFundoJanela = new Color(230, 240, 255); // Azul bem clarinho pro fundo
        Color corFundoDisplay = Color.WHITE;
        Color corBotaoNum = Color.WHITE;
        Color corBotaoOp = new Color(200, 225, 255); // Azul céu suave para operações
        Color corBotaoIgual = new Color(150, 190, 255); // Azul um pouco mais forte para o igual
        Color corTextoEscuro = new Color(50, 50, 50); // Cinza escuro para números
        Color corBorda = new Color(210, 220, 240);

        Font fonteDisplayGrande = new Font("Segoe UI", Font.BOLD, 32);
        Font fonteDisplayPequena = new Font("Segoe UI", Font.PLAIN, 16);
        Font fonteBotoes = new Font("Segoe UI", Font.PLAIN, 24);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora Simples");
        setResizable(false);
        setBackground(corFundoJanela);

        // Painel Principal
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setLayout(new BorderLayout(10, 10));
        jPanel1.setBackground(corFundoJanela);
        jPanel1.setBorder(new EmptyBorder(15, 15, 15, 15));

        // --- PAINEL DE CIMA (DISPLAYS) ---
        JPanel panelTelas = new JPanel(new GridLayout(2, 1, 0, 5));
        panelTelas.setBackground(corFundoJanela);
        panelTelas.setBorder(new LineBorder(corBorda, 1));

        Resultado = new javax.swing.JTextField();
        Resultado.setEditable(false);
        Resultado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Resultado.setBackground(corFundoDisplay);
        Resultado.setForeground(Color.GRAY);
        Resultado.setBorder(new EmptyBorder(5, 10, 0, 10));
        Resultado.setFont(fonteDisplayPequena);

        Entrada = new javax.swing.JTextField();
        Entrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Entrada.setBackground(corFundoDisplay);
        Entrada.setForeground(corTextoEscuro);
        Entrada.setBorder(new EmptyBorder(0, 10, 5, 10));
        Entrada.setFont(fonteDisplayGrande);

        panelTelas.add(Resultado);
        panelTelas.add(Entrada);
        jPanel1.add(panelTelas, BorderLayout.NORTH);

        // --- PAINEL DE BOTÕES (GRID 4x4) ---
        JPanel panelBotoes = new JPanel(new GridLayout(4, 4, 8, 8));
        panelBotoes.setBackground(corFundoJanela);

        // Inicializa os botões
        but0 = new JButton("0");
        but1 = new JButton("1");
        but2 = new JButton("2");
        but3 = new JButton("3");
        but4 = new JButton("4");
        but5 = new JButton("5");
        but6 = new JButton("6");
        but7 = new JButton("7");
        but8 = new JButton("8");
        but9 = new JButton("9");
        butPonto = new JButton(".");
        butSomar = new JButton("+");
        butSubtrair = new JButton("-");
        butMultiplicar = new JButton("×"); // Usando símbolo de multiplicação mais bonito
        butDividir = new JButton("÷"); // Usando símbolo de divisão mais bonito
        butIgual = new JButton("=");

        // Configuração Geral dos Botões
        JButton[] todosBotoes = { but0, but1, but2, but3, but4, but5, but6, but7, but8, but9, butPonto, butSomar,
                butSubtrair, butMultiplicar, butDividir, butIgual };
        for (JButton btn : todosBotoes) {
            btn.setFont(fonteBotoes);
            btn.setFocusPainted(false);
            btn.setForeground(corTextoEscuro);
            btn.setBorder(new LineBorder(corBorda, 1));
        }

        // Cores específicas
        JButton[] nums = { but0, but1, but2, but3, but4, but5, but6, but7, but8, but9, butPonto };
        for (JButton btn : nums)
            btn.setBackground(corBotaoNum);

        JButton[] ops = { butSomar, butSubtrair, butMultiplicar, butDividir };
        for (JButton btn : ops)
            btn.setBackground(corBotaoOp);

        butIgual.setBackground(corBotaoIgual);

        // Adiciona na ordem padrão de calculadora (igual a foto original)
        // Linha 1
        panelBotoes.add(but7);
        panelBotoes.add(but8);
        panelBotoes.add(but9);
        panelBotoes.add(butDividir);
        // Linha 2
        panelBotoes.add(but4);
        panelBotoes.add(but5);
        panelBotoes.add(but6);
        panelBotoes.add(butMultiplicar);
        // Linha 3
        panelBotoes.add(but1);
        panelBotoes.add(but2);
        panelBotoes.add(but3);
        panelBotoes.add(butSubtrair);
        // Linha 4
        panelBotoes.add(but0);
        panelBotoes.add(butPonto);
        panelBotoes.add(butIgual);
        panelBotoes.add(butSomar);

        jPanel1.add(panelBotoes, BorderLayout.CENTER);

        // --- RECONECTANDO A SUA LÓGICA ORIGINAL ---
        // Usando lambdas para chamar os seus métodos exatos
        but1.addActionListener(evt -> but1ActionPerformed(evt));
        but2.addActionListener(evt -> but2ActionPerformed(evt));
        but3.addActionListener(evt -> but3ActionPerformed(evt));
        but4.addActionListener(evt -> but4ActionPerformed(evt));
        but5.addActionListener(evt -> but5ActionPerformed(evt));
        but6.addActionListener(evt -> but6ActionPerformed(evt));
        but7.addActionListener(evt -> but7ActionPerformed(evt));
        but8.addActionListener(evt -> but8ActionPerformed(evt));
        but9.addActionListener(evt -> but9ActionPerformed(evt));
        but0.addActionListener(evt -> but0ActionPerformed(evt));
        butPonto.addActionListener(evt -> butPontoActionPerformed(evt));
        butSomar.addActionListener(evt -> butSomarActionPerformed(evt));
        butSubtrair.addActionListener(evt -> butSubtrairActionPerformed(evt));
        butMultiplicar.addActionListener(evt -> butMultiplicarActionPerformed(evt));
        butDividir.addActionListener(evt -> butDividirActionPerformed(evt));
        butIgual.addActionListener(evt -> butIgualActionPerformed(evt));

        // Finaliza configuração do Frame
        getContentPane().add(jPanel1);
        pack();
        setSize(340, 500); // Tamanho fixo agradável
    }

    // =========================================================================
    // CÓDIGO ORIGINAL MANTIDO ABAIXO (NÃO ALTERADO)
    // =========================================================================

    private void but8ActionPerformed(java.awt.event.ActionEvent evt) {
        String temp = Entrada.getText();
        Entrada.setText(temp + "8"); // Concatena o dígito
    }

    private void but1ActionPerformed(java.awt.event.ActionEvent evt) {
        String temp = Entrada.getText();
        Entrada.setText(temp + "1"); // Concatena o dígito
    }

    private void but2ActionPerformed(java.awt.event.ActionEvent evt) {
        String temp = Entrada.getText();
        Entrada.setText(temp + "2"); // Concatena o dígito
    }

    private void but3ActionPerformed(java.awt.event.ActionEvent evt) {
        String temp = Entrada.getText();
        Entrada.setText(temp + "3"); // Concatena o dígito
    }

    private void but4ActionPerformed(java.awt.event.ActionEvent evt) {
        String temp = Entrada.getText();
        Entrada.setText(temp + "4"); // Concatena o dígito
    }

    private void but5ActionPerformed(java.awt.event.ActionEvent evt) {
        String temp = Entrada.getText();
        Entrada.setText(temp + "5"); // Concatena o dígito
    }

    private void but6ActionPerformed(java.awt.event.ActionEvent evt) {
        String temp = Entrada.getText();
        Entrada.setText(temp + "6"); // Concatena o dígito
    }

    private void but7ActionPerformed(java.awt.event.ActionEvent evt) {
        String temp = Entrada.getText();
        Entrada.setText(temp + "7"); // Concatena o dígito
    }

    private void but9ActionPerformed(java.awt.event.ActionEvent evt) {
        String temp = Entrada.getText();
        Entrada.setText(temp + "9"); // Concatena o dígito
    }

    private void but0ActionPerformed(java.awt.event.ActionEvent evt) {
        String temp = Entrada.getText();
        if (!temp.isEmpty()) {
            Entrada.setText(temp + "0");
        }
    }

    private void butPontoActionPerformed(java.awt.event.ActionEvent evt) {
        String temp = Entrada.getText();
        if (temp.isEmpty()) {
            Entrada.setText("0."); // Se vazio, começa com "0."
        } else if (!temp.contains(".")) {
            Entrada.setText(temp + "."); // Adiciona o ponto
        }
    }

    private void butSomarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            ent = Double.parseDouble(Entrada.getText());
            res = res + ent;
            Entrada.setText("");
            Resultado.setText(Double.toString(res));
        } catch (NumberFormatException e) {
        }
    }

    private void butSubtrairActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            ent = Double.parseDouble(Entrada.getText());
            res = res - ent;
            Entrada.setText("");
            Resultado.setText(Double.toString(res));
        } catch (NumberFormatException e) {
        }
    }

    private void butMultiplicarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            ent = Double.parseDouble(Entrada.getText());
            res = res * ent;
            Entrada.setText("");
            Resultado.setText(Double.toString(res));
        } catch (NumberFormatException e) {
        }
    }

    private void butDividirActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            ent = Double.parseDouble(Entrada.getText());
            if (ent != 0) {
                res = res / ent;
            } else {
                Resultado.setText("Erro!");
                res = 0;
            }
            Entrada.setText("");
            Resultado.setText(Double.toString(res));
        } catch (NumberFormatException e) {
        }
    }

    private void butIgualActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            ent = Double.parseDouble(Entrada.getText());
            res = ent;
            Entrada.setText("");
            Resultado.setText(Double.toString(res));
        } catch (NumberFormatException e) {
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Tenta usar o estilo do sistema operacional se possível para ficar mais
         * "nativo"
         */
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            // Se falhar, usa o padrão do Java
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCalculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField Entrada;
    private javax.swing.JTextField Resultado;
    private javax.swing.JButton but0;
    private javax.swing.JButton but1;
    private javax.swing.JButton but2;
    private javax.swing.JButton but3;
    private javax.swing.JButton but4;
    private javax.swing.JButton but5;
    private javax.swing.JButton but6;
    private javax.swing.JButton but7;
    private javax.swing.JButton but8;
    private javax.swing.JButton but9;
    private javax.swing.JButton butDividir;
    private javax.swing.JButton butIgual;
    private javax.swing.JButton butMultiplicar;
    private javax.swing.JButton butPonto;
    private javax.swing.JButton butSomar;
    private javax.swing.JButton butSubtrair;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}