package CharacterCreator.DnDClass;

import DataVisitor.DataElement;
import DataVisitor.DataElementsVisitor;

import java.util.TreeMap;

public abstract class CharacterClass implements DataElement {
    private String name;
    private int hp;

    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public abstract void printMagika();

    public String toString() {
        return "Name of class: " + name + "\nHealth points: " + hp;
    }

    public TreeMap<Object, Object> accept(DataElementsVisitor elementsVisitor) {
        return elementsVisitor.visit(this);
    }

}
