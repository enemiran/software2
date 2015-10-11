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
public class lortuEskaerakKonprobatu extends TestCase {
    prozesu pr;
    Bezeroak bz;

    Bezeroa bezero = new Bezeroa("77878909", "Eneritz Ardanaz", "Borroto 87 5.B", "987657483", 300);
    Hornitzailea horn = new Hornitzailea("44567876", "Pepe Garmendia", "Kale Nagusia, 7.B", "987678755", "Handia");
    Artikulua art = new Artikulua("Pirritx eta Porrotx", "Tapa gogorreko liburua", 25, horn);
    Osagaia os1 = new Osagaia(art, 3);
    Osagaia[] osarray = {os1};

    //@Override
    protected void setUp() throws Exception {
        super.setUp();
        
        pr.kargatuBezeroak();
        pr.kargatuHornitzaileak();
	pr.kargatuArtikuluak();
  
    }
    
    //@Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    // 1. eta 2. kasuen tratamendua
    public void testCreateGui1() throws InterruptedException, IOException {
       assertEquals(null, bezero.lortuEskaera(""));
    }
    // 4. kasuaren tratamendua. Bezeroaren eskareak erakutsi dir.
    public void testCreateGui2(){
        Bezeroa bb = bz.bilatuBezeroa("12341234");
        Eskaera esk = new Eskaera(bb, osarray);
        bb.gehituEskaera(esk);
        assertEquals(si.Eskaera.class, bb.lortuEskaera("Pello Korta").getClass());
    }
    // 3. kasuaren tratamendua. Bezeroak ez zuen inongo eskaerarik.
    public void testCreateGui3() throws InterruptedException, IOException {
        assertEquals(null, bezero.lortuEskaera("Eneritz Ardanaz"));
    }
}
