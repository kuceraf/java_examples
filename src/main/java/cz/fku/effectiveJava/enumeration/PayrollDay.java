package cz.fku.effectiveJava.enumeration;

public enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);
    private final PayType payType;
    PayrollDay(PayType payType) {
        this.payType = payType;
    }
    PayrollDay(){this(PayType.WEEKDAY);}

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }
    // Strategy enum type
    private enum PayType {
        WEEKDAY {
            @Override
            int overtimePay(int minutesWorked, int payRate) {
                return minutesWorked <= MINS_PER_SHIFT ? 0 :
                        (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        }, WEEKEND {
            @Override
            int overtimePay(int minutesWorked, int payRate) {
                return (minutesWorked * payRate) / 2;
            }
        };
        private static final int MINS_PER_SHIFT = 8 * 60;
        int pay(int minutesWorked, int payRate) {
            return minutesWorked * payRate + overtimePay(minutesWorked, payRate);
        }
        abstract int overtimePay(int minutesWorked, int payRate);
    }
}



