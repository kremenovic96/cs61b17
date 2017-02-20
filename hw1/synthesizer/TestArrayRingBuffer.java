package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(4);
        assertEquals(true, arb.isEmpty());
        arb.enqueue(5.0);
        arb.enqueue(6.0);
        arb.enqueue(7.0);
        arb.enqueue(8.0);
        assertEquals(5.0, arb.dequeue());
        assertEquals(6.0,arb.peek());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
