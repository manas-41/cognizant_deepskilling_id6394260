import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VoidExceptionTest {
    @Test
    public void testVoidMethodException() {
        Logger mockLogger = mock(Logger.class);
        doThrow(new RuntimeException("Logging failed")).when(mockLogger).log("Error");
        assertThrows(RuntimeException.class, () -> {
            mockLogger.log("Error");
        });
        verify(mockLogger).log("Error");
    }
}
