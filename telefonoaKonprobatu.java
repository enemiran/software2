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
public class telefonoaKonprobatu extends TestCase {
    prozesu pr;
    Bezeroak bzk;  
    Bezeroa bz = new Bezeroa("44565434", "Eneritz Ardanaz", "Borroto 28 9.A", "954567890", 1500);


    //@Override
    protected void setUp() throws Exception {
        super.setUp();
        pr.kargatuBezeroak();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

   //3 eta 4 kasuen proba. Telefonoa ezin da NULL izan.
    public void testCreateGui1(){
        assertEquals(false, bz.gordeTelefonoa(null));
    }
    //10 kasuaren proba. Kasu egokia. Bezeroaren telefonoa sisteman gorde da.
    public void testCreateGui2(){ 
        assertEquals(true, bz.gordeTelefonoa("976789098"));
        bz.ikuskatu();
    }
    //1 eta 2 kasuen proba. Telefonoa ezin da hutsik egon.
    public void testCreateGui3() throws InterruptedException, IOException {
       assertEquals(false, bz.gordeTelefonoa(""));
    }
    //6 kasuaren proba. Telefonoa ezin da < 9 izan.
    public void testCreateGui4() throws InterruptedException, IOException {
       assertEquals(false, bz.gordeTelefonoa("94321678"));
    }
    //7 kasuaren proba. Telefonoa ezin da > 9 izan.
    public void testCreateGui5() throws InterruptedException, IOException {
       assertEquals(false, bz.gordeTelefonoa("9432178909"));
    }
    //8 eta 9 kasuen proba. Telefonoak ezin ditu karaktereak eduki.
    public void testCreateGui6() throws InterruptedException, IOException {
       assertEquals(false, bz.gordeTelefonoa("1k4567897"));
    }
}
