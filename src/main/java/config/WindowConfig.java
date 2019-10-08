package config;

public class WindowConfig {

    public static int getWidth() {
        return (int) (getColumnsAmount() * CheckboxConfig.getSize());
    }

    public static int getHeight() {
        return (int) (getRowsAmount() * CheckboxConfig.getSize());
    }

    public static int getColumnsAmount() {
        return 5;
    }

    public static int getRowsAmount() {
        return 7;
    }
}
