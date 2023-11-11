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
    JTextField result;
    JPanel resultPanel;
    JPanel buttonPanel;
    JPanel memoryPanel;
    double output;
    double prevNum = 0;
    double currNum = 0;
    char prevOperator = ' ';
    char currOperator = ' ';
    double memoryValue;

    StandardCalculator() {

        this.setTitle("Standard Calculator");
        Font buttonFont = new Font("Dialog", Font.PLAIN, 18);
        this.setLayout(null);
        resultPanel = new JPanel(new GridLayout(1,12));
        result = new JTextField();
        result.setFont(buttonFont);
        result.setHorizontalAlignment(JTextField.RIGHT);
        result.setEditable(false);
        result.setCaretPosition(result.getText().length());
        // result.posi
        resultPanel.setSize(300, 50);
        resultPanel.add(result);
        resultPanel.setBounds(10,10,315,50);

        memoryPanel = new JPanel(new GridLayout(1,5,5,5));
        memoryClearBtn = new JButton("mc");
        memoryRecallBtn = new JButton("mr");
        memoryPlusBtn = new JButton("m+");
        memoryMinusBtn = new JButton("m-");
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
        squaredBtn = new JButton("x2");
        clearEntryBtn = new JButton("CE");
        clearBtn = new JButton("C");
        backspaceBtn = new JButton("<-");
        reciprocalBtn = new JButton("1/x");
        squareRootBtn = new JButton("2√x");
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
            addBtn, subtractBtn, multiplyBtn, divideBtn, calculateBtn, posNegBtn, reciprocalBtn,
            memoryClearBtn, memoryRecallBtn, memoryPlusBtn, memoryMinusBtn, memorySaveBtn,
            clearEntryBtn, squareRootBtn, percentageBtn, dotBtn, clearBtn, backspaceBtn, squaredBtn,
            num1, num2, num3, num4, num5, num6, num7, num8, num9, num0
        };
        for (JButton jButton : buttons) {
            jButton.setFont(buttonFont);
            jButton.addActionListener(this);
        }

        buttonPanel.add(percentageBtn);
        buttonPanel.add(clearEntryBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(backspaceBtn);
        buttonPanel.add(reciprocalBtn);
        buttonPanel.add(squaredBtn);
        buttonPanel.add(squareRootBtn);
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

        Calculate c = new Calculate();
        switch(e.getActionCommand()) {
            case "mc":
                memoryValue = 0;
                result.setText("0");
                break;
            case "mr": //memory recall
                result.setText(formatNumber(memoryValue));
                break;
            case "m-":
                memoryValue = c.subtract(Double.parseDouble(result.getText()), memoryValue);
                break;
            case "m+":
                memoryValue = c.add(Double.parseDouble(result.getText()), memoryValue);
                break;
            case "ms":
                memoryValue = Double.parseDouble(result.getText());
                break;
            case "%":
                break;
            case "CE": //clear entry
                currNum = 0;
                result.setText("0");
                break;
            case "C": //clear
                currNum = 0;
                prevNum = 0;
                result.setText("0");
                break;
            case "<-":
                result.setText(c.backspace(result.getText()));
                break;
            case "1/x": //this shit is called reciprocal
                result.setText(String.valueOf(c.reciprocal(Double.parseDouble(result.getText()))));
                break;
            case "x2": //squared
                result.setText(String.valueOf(c.square(Double.parseDouble(result.getText()))));
                break;
            case "2√x": //square root!
                result.setText(String.valueOf(c.squareRoot(Double.parseDouble(result.getText()))));
                break;
            case "0":
                setNumber("0");
                break;
            case "1":
                setNumber("1");
                break;
            case "2":
                setNumber("2");
                break;
            case "3":
                setNumber("3");
                break;
            case "4":
                setNumber("4");
                break;
            case "5":
                setNumber("5");
                break;
            case "6":
                setNumber("6");
                break;
            case "7":
                setNumber("7");
                break;
            case "8":
                setNumber("8");
                break;
            case "9":
                setNumber("9");
                break;
            case "-":
                currOperator = '-';
                prevNum = Double.parseDouble(result.getText());
                break;
            case "x":
                currOperator = 'x';
                prevNum = Double.parseDouble(result.getText());
                break;
            case "+":
                //set the currOperator
                currOperator = '+';
                System.out.println(currOperator);
                //set the prevNum
                prevNum = Double.parseDouble(result.getText());
                break;
            case "÷":
                currOperator = '÷';
                prevNum = Double.parseDouble(result.getText());
                break;
            case "+/-":
                result.setText(c.negate(result.getText()));
                break;
            case ".":
                if(!result.getText().contains(".")) {
                    result.setText(result.getText() + ".");
                }
                System.out.println("Bawal bai");
                break;
            case "=":
                System.out.println(prevOperator);
                switch(prevOperator) {
                    case '+':
                        prevNum = c.add(prevNum, currNum);
                        result.setText(String.valueOf(prevNum));
                        result.setText(formatNumber(prevNum));
                        break;
                    case '-':
                        prevNum = c.subtract(prevNum, currNum);
                        result.setText(formatNumber(prevNum));
                        break;
                    case 'x':
                        prevNum = c.multiply(prevNum, currNum);
                        result.setText(formatNumber(prevNum));
                        break;
                    case '÷':
                        prevNum = c.divide(prevNum, currNum);
                        result.setText(formatNumber(prevNum));
                        break;
                }
                break;
        }
        System.out.println("Previous number: " + String.valueOf(prevNum));
        System.out.println("Current number: " + String.valueOf(currNum));

    }

    private void setNumber(String num) {
        if (currOperator != ' ') {
            System.out.println("reset the fucking textifeld");
            prevOperator = currOperator;
            currOperator = ' ';
            result.setText("");
        }
        System.out.println("Just append");
        result.setText(result.getText() + num);
        currNum = Double.parseDouble(result.getText());
    }

    private String formatNumber(double x) {
        if(x == (int) x) {
           return String.valueOf((int) x);
        }
        else {
            return String.valueOf(x);
        }
    }

}

