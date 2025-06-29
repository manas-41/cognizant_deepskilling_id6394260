import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import org.junit.jupiter.api.Test;

public class ArgumentMatcherTest {
    @Test
    public void testArgumentMatcher() {
        Calculator mockCalculator = mock(Calculator.class);
        when(mockCalculator.add(anyInt(), anyInt())).thenReturn(10);
        mockCalculator.add(5, 3);
        verify(mockCalculator).add(eq(5), eq(3));
    }
}
