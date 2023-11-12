public class Calculate {

    public double add(double num1, double num2) {
        double sum = num1 + num2;
        return sum;
    }

    public double subtract(double num1, double num2) {
        double difference = num1 - num2;
        return difference;
    }

    public double multiply(double num1, double num2) {
        double product = num1 * num2;
        return product;
    }

    public double divide(double num1, double num2) {
        double qoutient = num1 / num2;
        return qoutient;
    }

    public double addition(double num1, double num2) {
        double sum = num1 + num2;
        return sum;
    }
    
    public double reciprocal(double x) {
        return 1.0/x;
    }

    public double percentage(double totalValue, double percent) {
        return (percent / 100) * totalValue;
    }

    public double square(double x) {
        return x * x;
    }

    public double squareRoot(double x) {
        return Math.sqrt(x);
    }

    public String backspace(String x) {
        if(x.equals("0") || x.length() == 0 || x.length() == 1) {
            return "0";
        }
        StringBuilder s = new StringBuilder();
        s.append(x);
        return s.substring(0, x.length()-1);
    }

    public String negate(String x) {
        if(Double.parseDouble(x) == 0) {
            return "0";
        }
        StringBuilder s = new StringBuilder();
        s.append(x);
        if(x.charAt(0) == '-') {
            return s.substring(1, x.length());
        }
        else {
            s.insert(0, "-");
            return s.toString();
        }
        
    }



}
