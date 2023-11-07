import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

class StandardCalculator extends JFrame implements ActionListener{

    JButton addBtn, subtractBtn, multiplyBtn, divideBtn, calculateBtn, posNegBtn, memoryClearBtn,
    memoryRecallBtn, memoryMinusBtn, memoryPlusBtn, clearEntryBtn, squareRootBtn, percentageBtn, dotBtn,
    memorySaveBtn, clearBtn, backspaceBtn, reciprocalBtn, squaredBtn,
    num1, num2, num3, num4, num5, num6, num7, num8, num9, num0;
    JTextArea result;
    JPanel resultPanel;
    JPanel buttonPanel;
    JPanel memoryPanel;

    StandardCalculator() {

        this.setLayout(null);
        resultPanel = new JPanel(new GridLayout(1,12));
        result = new JTextArea(3,26);
        resultPanel.setSize(300, 50);
        resultPanel.add(result);
        resultPanel.setBounds(10,10,315,50);

        memoryPanel = new JPanel(new GridLayout(1,5,5,5));
        memoryClearBtn = new JButton("mc");
        memoryRecallBtn = new JButton("mr");
        memoryMinusBtn = new JButton("m-");
        memoryPlusBtn = new JButton("m+");
        memorySaveBtn = new JButton("ms");
        memoryPanel.add(memoryClearBtn);
        memoryPanel.add(memoryRecallBtn);
        memoryPanel.add(memoryMinusBtn);
        memoryPanel.add(memoryPlusBtn);
        memoryPanel.add(memorySaveBtn);
        memoryPanel.setBounds(10,70,315,50);

        buttonPanel = new JPanel();
        addBtn = new JButton("+");
        subtractBtn = new JButton("-");
        multiplyBtn = new JButton("x");
        divideBtn = new JButton("÷");
        calculateBtn = new JButton("=");
        squareRootBtn = new JButton("x2");
        clearEntryBtn = new JButton("CE");
        clearBtn = new JButton("C");
        backspaceBtn = new JButton("<-");
        reciprocalBtn = new JButton("1/x");
        squaredBtn = new JButton("2√x");
        percentageBtn = new JButton("%");
        posNegBtn = new JButton("+/-");
        dotBtn = new JButton(".");
        num1 = new JButton("1");
        num2 = new JButton("2");
        num3 = new JButton("3");
        num4 = new JButton("4");
        num5 = new JButton("5");
        num6 = new JButton("6");
        num7 = new JButton("7");
        num8 = new JButton("8");
        num9 = new JButton("9");
        num0 = new JButton("0");
        backspaceBtn.setBackground(new Color(244,20,124));
        buttonPanel.setBounds(10,125,315,350);
        buttonPanel.setLayout(new GridLayout(6, 4, 5,5));

        JButton[] buttons = {
            addBtn, subtractBtn, multiplyBtn, divideBtn, calculateBtn, posNegBtn, 
             clearEntryBtn, squareRootBtn, percentageBtn, dotBtn,
            num1, num2, num3, num4, num5, num6, num7, num8, num9, num0
        };
        Font buttonFont = new Font("Dialog", Font.PLAIN, 20);
        for (JButton jButton : buttons) {
            jButton.setFont(buttonFont);
        }

        buttonPanel.add(percentageBtn);
        buttonPanel.add(clearEntryBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(backspaceBtn);
        buttonPanel.add(reciprocalBtn);
        buttonPanel.add(squareRootBtn);
        buttonPanel.add(squaredBtn);
        buttonPanel.add(divideBtn);
        buttonPanel.add(num7);
        buttonPanel.add(num8);
        buttonPanel.add(num9);
        buttonPanel.add(multiplyBtn);
        buttonPanel.add(num4);
        buttonPanel.add(num5);
        buttonPanel.add(num6);
        buttonPanel.add(subtractBtn);
        buttonPanel.add(num1);
        buttonPanel.add(num2);
        buttonPanel.add(num3);
        buttonPanel.add(addBtn);
        buttonPanel.add(posNegBtn);
        buttonPanel.add(num0);
        buttonPanel.add(dotBtn);
        buttonPanel.add(calculateBtn);

        this.add(resultPanel);
        this.add(memoryPanel);
        this.add(buttonPanel);
        this.setSize(350, 525);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

    }

}