package CharacterCreator.DnDClass;

public class ClassFactory {
    public CharacterClass getClass(String type) {
        if (type.equals("Halflingy")) {
            return new Halflingy() {
            };
        } else if (type.equals("Hobgoblin")) {
            return new Hobgoblin() {
            };
        } else {
            return null;
        }
    }
}
