import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotesServiceImplTest {
    
    private NotesService notesService;
    
    private NotesStorage notesStorage;
    
    @BeforeEach
    public void setup(){
        notesStorage= new NotesStorageMock();
        notesService=NotesServiceImpl.createWith(notesStorage);
    }
    
    @Test
    public void testAddValidNote(){
        Note note = Note.of("Adam",4.0f);
        notesService.add(note);
        Assertions.assertEquals(false,notesStorage.isEmpty());
    }
    
    @Test
    public void testCalculateAverageForValidName(){
        Note note = Note.of("Adam",4.0f);
        notesService.add(note);
        Assertions.assertEquals(false,notesStorage.isEmpty());
    }
    
    @Test
    public void testCalculateAverageForBlankName(){
        notesService.add(Note.of("Adam",4.0f));
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            notesService.averageOf("");
        });
    }
    
    @Test
    public void testCalculateAverageForNullName(){
        notesService.add(Note.of("Adam",4.0f));
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            notesService.averageOf(null);
        });
    }
    
    @Test
    public void testCalculateAverageForNameOnlyWithSpaces(){
        notesService.add(Note.of("Adam",4.0f));
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            notesService.averageOf("    ");
        });
    }
    
    @Test
    public void testClear(){
        notesService.clear();
        Assertions.assertEquals(notesStorage.isEmpty(),true);
    }
    
    @AfterEach
    public void teardown(){
        notesService=null;
        notesStorage=null;
    }
    
}
