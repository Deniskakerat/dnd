package CharacterCreator.DnDRace;

import CharacterCreator.DnDClass.CharacterClass;
import CharacterCreator.Stats;
import GUI.DndGui;

import java.util.ArrayList;
import java.util.List;

public class Halflingy extends CharacterRace {
    public Halflingy() {
        setName(DndGui.getDndClass());
        setBonuses(new Stats(2, 0, 1, 0, 0, 0));
    }

    @Override
    public void saySMTH() {
        System.out.println(" ");
    }
}