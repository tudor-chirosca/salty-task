package org.example.SimulateAis.enums;

public enum ElementType {
    STRING_REQUIRED("string, required"),
    STRING_OPTIONAL("string, optional"),
    DATETIME_REQUIRED("datetime, required"),
    ARRAY_REQUIRED("array, required");

    private final String type;

    ElementType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static ElementType fromString(String type) {
        return switch (type) {
            case "string, required" -> STRING_REQUIRED;
            case "string, optional" -> STRING_OPTIONAL;
            case "datetime, required" -> DATETIME_REQUIRED;
            case "array, required" -> ARRAY_REQUIRED;
            default -> throw new IllegalArgumentException("Unknown element type: " + type);
        };
    }
}
