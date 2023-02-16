package enums;

public enum AutomationStatus {

    NOT_AUTOMATED("Not automated"), TO_BE_AUTOMATED("To be automated"), AUTOMATED("Automated");

    private String name;

    AutomationStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static AutomationStatus fromString(String value) {
        for (AutomationStatus automationStatus : AutomationStatus.values()) {
            if (automationStatus.getName().equals(value)) {
                return automationStatus;
            }
        }
        return null;
    }
}
