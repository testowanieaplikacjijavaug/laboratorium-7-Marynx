import java.util.ArrayList;
import java.util.List;

public class NotesStorageMock implements NotesStorage {
    
    private boolean isEmpty=true;
    
    @Override
    public void add(Note note) {
        isEmpty=false;
    }
    
    @Override
    public List<Note> getAllNotesOf(String name) {
        List<Note> notes=new ArrayList<>();
        notes.add(Note.of(name,4.0f));
        notes.add(Note.of(name,4.0f));
        return notes;
    }
    
    @Override
    public void clear() {
        isEmpty=true;
    }
    
    @Override
    public boolean isEmpty() {
        return isEmpty;
    }
    
}
