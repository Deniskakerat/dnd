package DataVisitor;

import CharacterCreator.Character;
import CharacterCreator.DnDClass.CharacterClass;
import CharacterCreator.DnDRace.CharacterRace;
import CharacterCreator.Stats;

import java.util.TreeMap;

public interface  DataElementsVisitor {
    TreeMap<Object, Object> visit(Character character);
    TreeMap<Object, Object> visit(Stats stats);
    TreeMap<Object, Object> visit(CharacterClass characterClass);
    TreeMap<Object, Object> visit(CharacterRace characterRace);
}
