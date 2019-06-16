package cz.fku.hariri.basic;

public class ClosureJv {
    private void outsideFunction() {
        for(int number=0; number < 100; number++) {
            GetingFunctionalKt.unaryOperation(20, (x) -> {
//                System.out.println(number); // impossible to use number here
                return 20;
            });
        }
    }
    public static void main(String[] args) {
        ClosureJv closureJv = new ClosureJv();
        closureJv.outsideFunction();
    }
}
