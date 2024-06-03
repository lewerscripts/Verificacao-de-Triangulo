// Programa para calcular a hipotenusa usando o Teorema de Pitágoras
package pitagorasinterfacegrafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PitagorasInterfaceGrafica extends JFrame {

    // Componentes da interface gráfica
    private JLabel labelA, labelB, labelResult;
    private JTextField textA, textB, textResult;
    private JButton buttonCalcular;

    // Construtor da classe
    public PitagorasInterfaceGrafica() {
        super("Teorema de Pitágoras");

        // Inicialização dos componentes
        inicializarComponentes();
        
        // Configuração do layout
        configurarLayout();
        
        // Adição dos componentes à interface
        adicionarComponentes();
        
        // Adição de eventos aos botões
        adicionarEventos();

        // Configuração do tamanho e visibilidade da janela
        setSize(280, 180); // Tamanho ajustado para acomodar melhor os componentes
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Método para inicializar os componentes da interface
    private void inicializarComponentes() {
        labelA = new JLabel("Cateto A:");
        labelB = new JLabel("Cateto B:");
        labelResult = new JLabel("Hipotenusa:");

        textA = new JTextField(5);
        textB = new JTextField(5);
        textResult = new JTextField(5);
        textResult.setEditable(false); // A hipotenusa será calculada automaticamente, então não deve ser editável

        buttonCalcular = new JButton("Calcular");
    }

    // Método para configurar o layout da interface
    private void configurarLayout() {
        Container tela = getContentPane();
        tela.setLayout(new GridLayout(4, 2, 5, 5)); // Layout alterado para GridLayout

        tela.add(labelA);
        tela.add(textA);
        tela.add(labelB);
        tela.add(textB);
        tela.add(labelResult);
        tela.add(textResult);
        tela.add(new JLabel()); // Espaçador vazio para alinhar o botão ao centro
        tela.add(buttonCalcular);
    }

    // Método para adicionar os componentes à interface
    private void adicionarComponentes() {
        // Nenhuma alteração aqui, pois os componentes já foram adicionados no método configurarLayout
    }

    // Método para adicionar eventos aos botões
    private void adicionarEventos() {
        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularHipotenusa();
            }
        });
    }

    // Método para calcular a hipotenusa e exibir o resultado
    private void calcularHipotenusa() {
        try {
            // Obtenção dos valores dos catetos A e B
            double catetoA = Double.parseDouble(textA.getText());
            double catetoB = Double.parseDouble(textB.getText());

            // Cálculo da hipotenusa utilizando o Teorema de Pitágoras
            double hipotenusa = Math.sqrt(Math.pow(catetoA, 2) + Math.pow(catetoB, 2));
            
            // Exibição do resultado formatado na caixa de texto
            textResult.setText(String.format("%.2f", hipotenusa));
        } catch (NumberFormatException ex) {
            // Exibição de mensagem de erro caso valores inválidos sejam inseridos
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.", "Erro de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método principal
    public static void main(String[] args) {
        new PitagorasInterfaceGrafica();
    }
}
