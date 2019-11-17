package cz.fku.proxy;

import java.lang.reflect.Proxy;

// https://dzone.com/articles/java-dynamic-proxies
public class RunCalculatorExample {
    public static void main(String[] args) {
        CalculatorImpl realCalc = new CalculatorImpl();
        Auditor auditor = new Auditor();

        // BAD approach
        AuditingCalculator auditingCalculator = new AuditingCalculator(realCalc, auditor);
        auditingCalculator.add(6, 6);

        // GOOD approach
        // auditing can be dynamically added to any method call (no need to implement Auditing for avery audited class)
        AuditingInvocationHandler auditingInvocationHandler = new AuditingInvocationHandler(auditor, realCalc);
        // which dynamically generates a class that claims to implement Calculator
        Calculator proxiedCalc = (Calculator) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{Calculator.class},
                auditingInvocationHandler);

        proxiedCalc.add(2,3);
    }
}
