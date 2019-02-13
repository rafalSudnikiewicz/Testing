package pl.sda.advanced.sandbox;

public class Computer {
    private final Mouse MOUSE;
    private final Keyboard KEYBOARD;

    public Computer(Mouse MOUSE, Keyboard KEYBOARD) {
        this.MOUSE = MOUSE;
        this.KEYBOARD = KEYBOARD;
    }

    public void type(String text) {
        for (int i = 0; i < text.length(); i++) {
            KEYBOARD.pressKey(text.charAt(i));
        }
    }

    public void open() {
        MOUSE.click();
        MOUSE.click();
    }
}
