package cz.fku.effectiveJava.method;

import java.util.HashMap;
import java.util.Map;

public class DefensiveCopy {
    private Map<MutableKey, String> stringMap = new HashMap<>();
    private MutableKey lastKey;
    public void insertToMap(MutableKey key, String val) {
        stringMap.put(key, val);
        lastKey = key;
    }

    public String searchMap(MutableKey key) {
        return stringMap.get(key);
    }

    public MutableKey getLastKey() {
        return lastKey;
    }

    public void setLastKey(MutableKey lastKey) {
        this.lastKey = lastKey;
    }

    public static class MutableKey {
        private String val1;
        private String val2;
        MutableKey (String val1, String val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        @Override
        public int hashCode() {
            return 37 * val1.hashCode() + val2.hashCode();
        }

        public String getVal1() {
            return val1;
        }

        public void setVal1(String val1) {
            this.val1 = val1;
        }

        public String getVal2() {
            return val2;
        }

        public void setVal2(String val2) {
            this.val2 = val2;
        }
    }
}
