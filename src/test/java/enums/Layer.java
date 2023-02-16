package enums;

public enum Layer {

    NOT_SET("Not set"), E2E("E2E"), API("API"), UNIT("Unit");

    private String name;

    Layer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Layer fromString(String value) {
        for (Layer layer : Layer.values()) {
            if (layer.getName().equals(value)) {
                return layer;
            }
        }
        return null;
    }
}
