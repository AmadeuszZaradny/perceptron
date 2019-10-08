package component;

import config.CheckboxConfig;
import config.WindowConfig;
import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainWindow extends PApplet {

    private List<Checkbox> checkboxes = new ArrayList<Checkbox>();

    public void settings() {
        size(WindowConfig.getWidth(), WindowConfig.getHeight());
    }

    public void setup() {
        generateMesh();
        drawMesh();
    }

    public void draw() {
        // drawMesh();
    }

    public void mousePressed(){
        pressCheckbox();
    }

    public void mouseClicked() {
    }

    private void drawMesh() {
        for (Checkbox checkbox : checkboxes) {
            checkbox.render();
        }
    }

    private void generateMesh() {
        float size = CheckboxConfig.getSize();
        for(int row = 0; row < WindowConfig.getRowsAmount(); row++) {
            for(int column = 0; column < WindowConfig.getColumnsAmount(); column++)
                checkboxes.add(new Checkbox(this, column * size, row * size, size));
        }
    }

    private Checkbox getPointedCheckbox() {
        float checkboxSize = CheckboxConfig.getSize();
        int columnsAmount = WindowConfig.getColumnsAmount();
        int row = (int) (mouseY / checkboxSize);
        int column = (int) (mouseX / checkboxSize);
        return checkboxes.get(row * columnsAmount + column);
    }

    private void pressCheckbox() {
        Checkbox checkbox = getPointedCheckbox().switchState();
        checkbox.render();
    }

    public void keyTyped(KeyEvent event) {
        switch (event.getKey()) {
            case '\n':
                System.out.println(getCheckboxsState());
                break;
            case 'r':
                clearWindow();
                break;
            default: break;
        }
    }

    private List getCheckboxsState() {
        return checkboxes.stream().map(checkbox -> checkbox.isChecked() ? 1 : 0).collect(Collectors.toList());
    }

    private void clearWindow() {
        checkboxes.forEach(Checkbox::cleanAndRefresh);
    }
}
