package cz.fku.proxy;

public class Auditor {
    public void audit(String service, String extraData) {
        System.out.println("Auditing call on: " + service +" "+extraData);
    }
}
