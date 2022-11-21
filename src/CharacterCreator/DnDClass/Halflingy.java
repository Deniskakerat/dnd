package CharacterCreator.DnDClass;

import java.util.ArrayList;
import java.util.List;

public abstract class Halflingy extends CharacterClass {
    private final List<String> spells;

    public Halflingy() {
        setName("Bard");
        setHp(8);
        spells = new ArrayList<>();
        spells.addAll(List.of(new String[]{"Charm Person", "Heroism"}));
    }

    public List<String> getSpells() {
        return spells;
    }

    public void printMagika() {
        System.out.println("Spells: ");
        for (String s: spells) {
            System.out.println(s);
        }
    }
}