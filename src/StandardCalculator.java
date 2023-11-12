import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

class StandardCalculator extends JFrame implements ActionListener{

    private JButton addBtn, subtractBtn, multiplyBtn, divideBtn, calculateBtn, posNegBtn, memoryClearBtn,
    memoryRecallBtn, memoryMinusBtn, memoryPlusBtn, clearEntryBtn, squareRootBtn, percentageBtn, dotBtn,
    memorySaveBtn, clearBtn, backspaceBtn, reciprocalBtn, squaredBtn,
    num1, num2, num3, num4, num5, num6, num7, num8, num9, num0;
    private JTextField result;
    private JPanel resultPanel;
    private JPanel buttonPanel;
    private JPanel memoryPanel;
    private double prevNum = 0;
    private double currNum = 0;
    private char prevOperator = ' ';
    private char currOperator = ' ';
    private double memoryValue;
    private DecimalFormat formatter;

    StandardCalculator() {

        formatter = new DecimalFormat("#,###.################");
        this.setTitle("Standard Calculator");
        this.setLayout(null);
        Font buttonFont = new Font("Dialog", Font.PLAIN, 18);
        resultPanel = new JPanel(new GridLayout(1,12));
        result = new JTextField("0");
        result.setFont(buttonFont);
        result.setHorizontalAlignment(JTextField.RIGHT);
        result.setEditable(false);
        result.setCaretPosition(result.getText().length());
        resultPanel.setSize(300, 50);
        resultPanel.add(result);
        resultPanel.setBounds(10,10,315,50);

        memoryPanel = new JPanel(new GridLayout(1,5,5,5));
        memoryClearBtn = new JButton("mc");
        memoryRecallBtn = new JButton("mr");
        memoryPlusBtn = new JButton("m+");
        memoryMinusBtn = new JButton("m-");
        memorySaveBtn = new JButton("ms");
        JButton[] memoryButtons = { memoryClearBtn, memoryRecallBtn, memoryMinusBtn, memoryPlusBtn, memorySaveBtn };
        for(JButton button : memoryButtons) {
            button.setFont(buttonFont);
            button.addActionListener(this);
            memoryPanel.add(button);
        }
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
        backspaceBtn.setBackground(new Color(166,165,161));
        buttonPanel.setBounds(10,125,315,350);
        buttonPanel.setLayout(new GridLayout(6, 4, 5,5));

        JButton[] buttons = {
            percentageBtn, clearEntryBtn, clearBtn, backspaceBtn, reciprocalBtn, 
            squaredBtn, squareRootBtn, divideBtn, num7, num8, num9, multiplyBtn, 
            num4, num5, num6, subtractBtn, num1, num2, num3, addBtn, posNegBtn, 
            num0, dotBtn, dotBtn, calculateBtn
        };
        for (JButton button : buttons) {
            button.setFont(buttonFont);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

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
            case "mc": //memory clear
                memoryValue = 0;
                result.setText("0");
                break;
            case "CE": //clear entry
                currNum = 0;
                result.setText("0");
                break;
            case "C": //clear
                prevOperator = ' ';
                currOperator = ' ';
                currNum = 0;
                prevNum = 0;
                result.setText("0");
                break;
            case "%": //percentage?
                System.out.println(c.percentage(currNum, prevNum));
                currNum = c.percentage(currNum, prevNum);
                result.setText(formatter.format(Double.parseDouble(formatNumber(currNum))));
                break;
            case "mr": //memory recall
                result.setText(formatter.format(Double.parseDouble(formatNumber(memoryValue))));
                break;
            case "m-": //memory minus
                memoryValue = c.subtract(memoryValue, Double.parseDouble(getResultNum()));
                break;
            case "m+": //memory plus
                memoryValue = c.add(Double.parseDouble(getResultNum()), memoryValue);
                break;
            case "ms": //memory save
                memoryValue = Double.parseDouble(getResultNum());
                break;
            case "<-": //backspace
                result.setText(formatter.format(Double.parseDouble(c.backspace(getResultNum()))));
                break;
            case "1/x": //this shit is called reciprocal
                result.setText(formatter.format(Double.parseDouble(String.valueOf(c.reciprocal(Double.parseDouble(getResultNum()))))));
                break;
            case "x2": //squared
                result.setText(formatter.format(Double.parseDouble(formatNumber(c.square(Double.parseDouble(getResultNum()))))));
                break;
            case "2√x": //square root!
                result.setText(formatter.format(Double.parseDouble(String.valueOf(c.squareRoot(Double.parseDouble(getResultNum()))))));
                break;
            case "-":
                //i think kung naay prevOperator kay e execute nalang? 
                //ye, lets try dat
                currOperator = '-';
                if(prevOperator != ' ') {
                    performOperation(prevOperator);
                }
                prevNum = Double.parseDouble(getResultNum());
                
                System.out.println(prevOperator);
                break;
            case "x":
                currOperator = 'x';
                if(prevOperator != ' ') {
                    performOperation(prevOperator);
                }
                prevNum = Double.parseDouble(getResultNum());
                break;
            case "+":
                //set the currOperator
                currOperator = '+';
                if(prevOperator != ' ') {
                    performOperation(prevOperator);
                }
                //set the prevNum
                prevNum = Double.parseDouble(getResultNum());
                break;
            case "÷":
                currOperator = '÷';
                if(prevOperator != ' ') {
                    performOperation(prevOperator);
                }
                prevNum = Double.parseDouble(getResultNum());
                break;
            case "+/-":
                result.setText(c.negate(result.getText()));
                break;
            case ".": //dot dot
                if(!result.getText().contains(".")) {
                    result.setText(result.getText() + ".");
                }
                System.out.println("Bawal bai");
                break;
            case "=":
                System.out.println(prevOperator);
                performOperation(prevOperator);
                prevOperator = ' ';
                break;
        }
        System.out.println("FROM ACTION PERFORMED: ");
        System.out.println("Previous number: " + String.valueOf(prevNum));
        System.out.println("Current number: " + String.valueOf(currNum));
        // System.out.println("Previous operator: " + prevOperator);
        // System.out.println("Current operator: " + currOperator);
        // System.out.println(formatter.format(prevNum));
        System.out.println("Formatted Number: " + formatter.format(currNum));
        System.out.println(" ");

    }

    private void setNumber(String num) {

        //if zero ang ga una remove dat shit 
        //if 0 ang ga una unya naay dot pwede ra :)
        //oke
        if(result.getText().startsWith("0") && !result.getText().contains(".")) {
            //if result textfield starts with 0 but has no dot, reset the textfield
            result.setText("");
            // System.out.println("aowkoakwoak");
        }

        if (currOperator != ' ') {
            // System.out.println("e reset ang textifeld");
            prevOperator = currOperator;
            currOperator = ' ';
            result.setText("");
        }
        //so if naay dot dili siya butngan ug comma
        // System.out.println("Without formatter: " + Double.parseDouble(getResultNum() + num));
        // System.out.println("With a formatter: " + formatter.format(x));
        if(result.getText().contains(".")) {
            System.out.println("GOGOGO");
            String str = getResultNum() + num;
            System.out.println("Not parsed: " + str);
            //no other choice i have to use bigdecimal
            BigDecimal bigDecimalValue = new BigDecimal(str);
            System.out.println("but if parsed: " + bigDecimalValue);
            result.setText(bigDecimalValue.toPlainString());
        }
        else {
            result.setText(formatter.format(Double.parseDouble(getResultNum() + num)));
        }
        currNum = Double.parseDouble(getResultNum());
    }

    private String formatNumber(double x) {
        if(x == (int) x) {
           return String.valueOf((int) x);
        }
        else {
            return String.valueOf(x);
        }
    }

    private void performOperation(char operator) {
        Calculate c = new Calculate();
        //nganong mawala ang zero sa decimal places kung ibutang sa Double.parsedouble oi boang
        // System.out.println("FROM EQUALS ");
        // System.out.println("Previous number: " + String.valueOf(prevNum));
        // System.out.println("Current number: " + String.valueOf(currNum));
        // System.out.println(" ");
        switch(operator) {
            case '+':
                prevNum = c.add(prevNum, currNum);
                // String prevNum2 = formatNumber(prevNum);
                // double prevNum3 = Double.parseDouble(prevNum2);
                // String prevNum4 = formatter.format(prevNum3);
                // System.out.println("prev num 2: " + prevNum2);
                // System.out.println("prev num 3: " + prevNum3);
                // System.out.println("prev num 4: " + prevNum4);
                result.setText(formatter.format(Double.parseDouble(formatNumber(prevNum))));
                break;
            case '-':
                prevNum = c.subtract(prevNum, currNum);
                result.setText(formatter.format(Double.parseDouble(formatNumber(prevNum))));
                break;
            case 'x':
                prevNum = c.multiply(prevNum, currNum);
                result.setText(formatter.format(Double.parseDouble(formatNumber(prevNum))));
                break;
            case '÷':
                prevNum = c.divide(prevNum, currNum);
                result.setText(formatter.format(Double.parseDouble(formatNumber(prevNum))));
                break;
        } 
    }

    private String getResultNum() {
        return result.getText().replaceAll(",", "");
    }

}

