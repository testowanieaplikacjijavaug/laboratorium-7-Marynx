import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NoteTest {
    
    @Test
    public void testGetNameOfValidNote(){
        Note note=Note.of("Adam",3.0f);
        Assertions.assertEquals(note.getName(),"Adam");
    }
    
    @Test
    public void testGetNoteOfValidNote(){
        Note note=Note.of("Adam",3.0f);
        Assertions.assertEquals(note.getNote(),3.0f);
    }
    
    @Test
    public void testNoteNotNull(){
        Note note=Note.of("Adam",3.0f);
        Assertions.assertNotNull(note);
    }
    
    @Test
    public void testNoteNullName(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Note.of(null,3.0f);
        });
    }
    
    @Test
    public void testNoteBlankName(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Note.of("",3.0f);
        });
    }
    
    @Test
    public void testNoteHigherThan6(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Note.of("Adam",7.0f);
        });
    }
    
    @Test
    public void testNoteSmallerThan2(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Note.of("Adam",1.0f);
        });
    }
    
}
