import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class VoidMethodTest {
    @Test
    public void testVoidMethod() {
        Logger mockLogger = mock(Logger.class);
        doNothing().when(mockLogger).log("Test Message");
        mockLogger.log("Test Message");
        verify(mockLogger).log("Test Message");
    }
}
