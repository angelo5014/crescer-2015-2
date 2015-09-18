
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void valoresSaoDevidamenteArmazenados(){
        DataTerceiraEra data = new DataTerceiraEra(21,11,1000);
        assertEquals(21, data.getDia());
        assertEquals(11, data.getMes());
        assertEquals(1000, data.getAno());
    }
    

    @Test
    public void anoRealmenteEhBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(1,1,2008);
        assertTrue(data.ehBissexto());
    }
}
