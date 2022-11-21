package GUI;

import CharacterCreator.Character;
import CharacterCreator.DnDClass.ClassFactory;
import CharacterCreator.DnDRace.HalflingFactory;
import CharacterCreator.DnDRace.HobgoblinFactory;
import CharacterCreator.DnDRace.RaceAbstractFactory;
import CharacterCreator.Stats;
import DataVisitor.DataElement;
import DataVisitor.ElementVisitor;
import org.json.simple.JSONObject;

import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Controller {
    public static RaceAbstractFactory raceAbstractFactory;

    public static Character saveCharecter() {
        ClassFactory classFactory = new ClassFactory();
            if (DndGui.getDndClass().equals("Halflingy")) {
                raceAbstractFactory = new HalflingFactory();
            }
            if (DndGui.getDndClass().equals("Hobgoblin")) {
                raceAbstractFactory = new HobgoblinFactory();
            }
        System.out.println(DndGui.getDndName());
        return new Character(DndGui.getDndName(), classFactory.getClass
                (DndGui.getDndClass()), raceAbstractFactory.create());
    }
    public static void printCharecter(FileWriter fw,Stats stats) throws IOException {
        ElementVisitor elementVisitor = new ElementVisitor();
        JSONObject jsonObject;

        Character character1 = saveCharecter();
        character1.setAttributes(stats);
        try {
            fw.write("[");
            jsonObject = formObject(character1, elementVisitor);
            fw.write(jsonObject.toJSONString());
            fw.write(",");
            DndGui.setCharecter(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static JSONObject formObject(Character character, ElementVisitor elementVisitor) {
        List<DataElement> dataElements = new LinkedList<>();

        dataElements.add(character);
        dataElements.add(character.getDndClass());
        dataElements.add(character.getRace());
        dataElements.add(character.getAttributes());

        JSONObject jsonObject = new JSONObject();

        for (DataElement element : dataElements) {
            jsonObject.putAll(element.accept(elementVisitor));
        }

        return jsonObject;
    }

}
