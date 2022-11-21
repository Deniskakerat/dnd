package CharacterCreator.DnDRace;


public class HalflingFactory implements RaceAbstractFactory {
    @Override
    public CharacterRace create() {
        return new Halflingy();
    }
}