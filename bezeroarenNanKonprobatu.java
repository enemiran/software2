package si;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.rmi.RemoteException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import junit.framework.TestCase;

/**
 * @author Eneritz
 */
public class bezeroarenNanKonprobatu extends TestCase {
    prozesu pr;
    Bezeroak bz;    


    //@Override
    protected void setUp() throws Exception {
        super.setUp();
        pr.kargatuBezeroak();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    //3 eta 4 kasuen proba. Nan ezin da NULL izan.
    public void testCreateGui1(){
        assertEquals(null, bz.bilatuBezeroa(null));
    }
    //10 kasuaren proba. Kasu egokia. Bezeroa sisteman aurkitu da.
    public void testCreateGui2(){ 
        assertEquals(si.Bezeroa.class, bz.bilatuBezeroa("12341234").getClass());
    }
    //1 eta 2 kasuen proba. Nan ezin da hutsik egon.
    public void testCreateGui3() throws InterruptedException, IOException {
       assertEquals(null, bz.bilatuBezeroa(""));
    }
    //6 kasuaren proba. Nan ezin da < 8 izan.
    public void testCreateGui4() throws InterruptedException, IOException {
       assertEquals(null, bz.bilatuBezeroa("123456"));
    }
    //7 kasuaren proba. Nan ezin da > 8 izan.
    public void testCreateGui5() throws InterruptedException, IOException {
       assertEquals(null, bz.bilatuBezeroa("123456789"));
    }
    //8 eta 9 kasuen proba. Nan-ak ezin ditu karaktereak eduki.
    public void testCreateGui6() throws InterruptedException, IOException {
       assertEquals(null, bz.bilatuBezeroa("1k456789"));
    }
    //11 kasuaren proba. Sarrea-egokia. Bezeroa ez da sisteman aurkitu.
    public void testCreateGui7() throws InterruptedException, IOException {
       assertEquals(null, bz.bilatuBezeroa("11111111"));
    }
}
