package CharacterCreator;
import DataVisitor.DataElement;
import DataVisitor.DataElementsVisitor;

import java.util.HashMap;
import java.util.TreeMap;

public class Stats implements DataElement {
    private HashMap<String, Integer> stats;

    public Stats() {
        stats = new HashMap<>();
    }

    public Stats(int str, int dex, int con, int intel, int wis, int charisma) {
        stats = new HashMap<>();
        stats.put("Strength", str);
        stats.put("Dexterity", dex);
        stats.put("Constitution", con);
        stats.put("Intellect", intel);
        stats.put("Wisdom", wis);
        stats.put("Charisma", charisma);
    }

    public static Stats generate() {
        Stats stats = new Stats();
        Dice dice = new Dice();

        stats.stats.put("Strength", dice.rollstat());
        stats.stats.put("Dexterity", dice.rollstat());
        stats.stats.put("Constitution", dice.rollstat());
        stats.stats.put("Intellect", dice.rollstat());
        stats.stats.put("Wisdom", dice.rollstat());
        stats.stats.put("Charisma", dice.rollstat());

        return stats;
    }

    public void print() {
        for (String s: stats.keySet()) {
            System.out.println(s + ": " + stats.get(s));
        }
    }

    public HashMap<String, Integer> getStats() {
        return stats;
    }

    @Override
    public TreeMap<Object, Object> accept(DataElementsVisitor elementsVisitor) {
        return elementsVisitor.visit(this);
    }}


