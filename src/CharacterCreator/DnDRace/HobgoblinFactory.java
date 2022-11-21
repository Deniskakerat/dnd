package CharacterCreator.DnDRace;

import CharacterCreator.Stats;
import DataVisitor.DataElementsVisitor;

import java.util.Map;
import java.util.TreeMap;

public class HobgoblinFactory implements RaceAbstractFactory {
    @Override
    public CharacterRace create() {
        return new Hobgoblin();
    }
}
