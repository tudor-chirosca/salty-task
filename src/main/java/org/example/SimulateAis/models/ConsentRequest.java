package org.example.SimulateAis.models;

public class ConsentRequest {

    private boolean recurringIndicator;
    private int frequencyPerDay;
    private String validUntil;
    private Access access;

    public boolean isRecurringIndicator() {
        return recurringIndicator;
    }

    public void setRecurringIndicator(boolean recurringIndicator) {
        this.recurringIndicator = recurringIndicator;
    }

    public int getFrequencyPerDay() {
        return frequencyPerDay;
    }

    public void setFrequencyPerDay(int frequencyPerDay) {
        this.frequencyPerDay = frequencyPerDay;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public static class Access {
        private String allPsd2;

        public String getAllPsd2() {
            return allPsd2;
        }

        public void setAllPsd2(String allPsd2) {
            this.allPsd2 = allPsd2;
        }
    }
}
