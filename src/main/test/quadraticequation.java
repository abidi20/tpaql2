import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class quadraticequation {
    @Mock
    private QuadraticEquation solve;
     @Test
    public  void solvetestunselsoulition(){
         when(solve.solve(1, 2,1)).thenReturn(new double[]{-1});
         //TODO : Appel de la méthode à tester
         double[] resu = solve.solve(1, 2,1);
         //TODO : Vérification du résultat
         assertArrayEquals(new double[]{-1}, resu);
         verify(solve).solve(1, 2,1);
         verifyNoMoreInteractions(solve);
     }
    @Test
    public  void solvetestdeuxsoulition(){
        when(solve.solve(1, -3, 2)).thenReturn(new double[]{2, 1});
        //TODO : Appel de la méthode à tester
        double[] resu = solve.solve(1, -3, 2);
        //TODO : Vérification du résultat
        assertArrayEquals(new double[]{2, 1}, resu);
        verify(solve).solve(1, -3, 2);
        verifyNoMoreInteractions(solve);
    }
    public  void solvetestpassoulition(){
        when(solve.solve(1, 0, 4)).thenReturn(null);
        //TODO : Appel de la méthode à tester
        double[] resu = solve.solve(1, 2,1);
        //TODO : Vérification du résultat
        assertArrayEquals(new double[]{-1}, resu);
        verify(solve).solve(1, 2,1);
        verifyNoMoreInteractions(solve);
    }

}
