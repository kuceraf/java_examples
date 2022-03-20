package cz.fku.designPatterns.behavioural.visitor.doubledispatch;

public class DoubleDispatchVisitor {
}

class CalculationVisitor implements  ExpressionVisitor {
    public double result;
    @Override
    public void visit(DoubleExpression expression) {
        result = expression.value;
    }

    @Override
    public void visit(AdditionExpression expression) {
        expression.left.accept(this);
        double leftResult = this.result;
        expression.right.accept(this);
        this.result = leftResult + this.result;
    }
}

class PrintingVisitor implements ExpressionVisitor {
    private StringBuilder sb = new StringBuilder();

    @Override
    public void visit(DoubleExpression expression) {
        sb.append(expression.value);
    }

    @Override
    public void visit(AdditionExpression expression) {
        sb.append("(");
        expression.left.accept(this);
        sb.append("+");
        expression.right.accept(this);
        sb.append(")");
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

interface ExpressionVisitor {
    void visit(DoubleExpression expression);
    void visit(AdditionExpression expression);
}

abstract class Expression {
    abstract void accept(ExpressionVisitor visitor);
}

class DoubleExpression extends Expression {
    public double value;

    public DoubleExpression(double value) {
        this.value = value;
    }

    @Override
    void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}

class AdditionExpression extends Expression {
    public Expression left, right;

    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}


class Demo {
    public static void main(String[] args) {
        AdditionExpression e = new AdditionExpression(
                new DoubleExpression(1),
                new AdditionExpression(
                        new DoubleExpression(2),
                        new DoubleExpression(3)

                )
        );
        PrintingVisitor printingVisitor = new PrintingVisitor();
        printingVisitor.visit(e);

        CalculationVisitor calculationVisitor = new CalculationVisitor();
        calculationVisitor.visit(e);
        System.out.println(printingVisitor);
        System.out.println(calculationVisitor.result);
    }
}