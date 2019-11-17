package cz.fku.proxy;

// BAD APPROACH
//We have to write a separate class for every service we are auditing,
// It is better to use dynamic proxy
public class AuditingCalculator implements Calculator {
    private Calculator inner;
    private Auditor auditor;

    public AuditingCalculator(Calculator inner, Auditor auditor) {
        this.inner = inner;
        this.auditor = auditor;
    }

    @Override
    public int add(int left, int right) {
        auditor.audit(this.getClass().getCanonicalName(), "before add");
        int result = inner.add(left, right);
        auditor.audit(this.getClass().getCanonicalName(), "after add");
        return result;
    }
}
