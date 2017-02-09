/**
 * Created by ranko on 2/8/17.
 */
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
public class TestArrayDeque1B {
    @Test
    public void testAddFirst(){
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        Random rn = new Random();
        for(int i = 0;i<10; i++){
            int rnd = rn.nextInt();
            student.addFirst(rnd);
            solution.addFirst(rnd);
        }
        for(int i = 0;i<10; i++){
            assertEquals(student.get(i), solution.get(i));
        }

    }
    @Test
    public void testAddLast(){
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        Random rn = new Random();
        for(int i = 0;i<10;i++){
            int rnd = rn.nextInt();
            student.addLast(rnd);
            solution.addLast(rnd);
        }
        for(int i =0;i<10;i++){
            assertEquals(student.get(i), solution.get(i));
        }
    }
    @Test
    public void testRemoveFirst(){
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        Random rn = new Random();
        for(int i =0;i<10;i++){
            int rnd = rn.nextInt();
            student.addFirst(rnd);
            solution.addFirst(rnd);

        }
        for(int i = 0;i<10; i++){
            assertEquals(student.removeFirst(),solution.removeFirst());
        }
    }
    @Test
    public void testRemoveLast(){
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        OperationSequence fs = new OperationSequence();
        Random rn = new Random();
        for(int i =0;i<10;i++){
            //int rnd = rn.nextInt();
            student.addLast(i);//instead of "i" i used "rn" for first time, "i" is easier to look at
            solution.addLast(i);
        }

        for(int i = 0; i < 10; i++){
            Integer last = student.removeLast();
            DequeOperation aa = new DequeOperation("removeLast", last);
            fs.addOperation(aa);
            assertEquals(fs.toString(), solution.removeLast(), last);
        }

    }

}
