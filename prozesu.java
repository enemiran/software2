package si;

import java.util.*;

import java.util.Vector;          // java.util.* eta java.io.* ordez
import java.util.StringTokenizer; //     Ikusteko non dauden 
import java.io.BufferedReader;    // erabili beharreko klaseak 
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Enumeration;


public class prozesu {
public prozesu(){};
        public static final String FITXATEGI_AMAIERA=null;
        public static void main(String[] args)
            throws FileNotFoundException, IOException
		 {
            
			kargatuBezeroak();
			kargatuHornitzaileak();
			kargatuArtikuluak();


	// Osagai generikoak sortzen ditugu

	for (int i=50;i<56;i++)  {
		Artikulua artikulua=
                (Artikulua)Bezeroak.BiltegiArtikuluak.elementAt(i-49);            
		Osagaia osagaia = new Osagaia(artikulua,i);
		//osagaia.ikuskatu();
                Bezeroak.gehituOsagaia(osagaia);
		}

	//Eskaerak sortzen

		Osagaia[] osagaiak = new Osagaia[20];

		for (int k=0;k<5;k++)  {
		Bezeroa bezeroa=(Bezeroa)Bezeroak.BiltegiBezeroak.elementAt(k);
		for (int i=0;i<6;i++)  {
		     int j = (int)Math.round(Math.random()*5);
	    Osagaia osagaia= (Osagaia)Bezeroak.BiltegiOsagaiak.elementAt(j);
                 osagaiak[i] = osagaia;
					}
		Eskaera eskaera = new Eskaera(bezeroa,osagaiak);
		Bezeroak.gehituEskaera(eskaera);
		}


	// Ikuskatu bezero guztiak
            for (int i=0;i<Bezeroak.BiltegiBezeroak.size();i++)
              ((Bezeroa)Bezeroak.BiltegiBezeroak.elementAt(i)).ikuskatu();
		
	// Bezero bat bilatu bere NANa erabilita
            BufferedReader f=new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.print("Emaidazu bezeroaren NAN-a: ");
            System.out.flush();
            String nan=f.readLine();
            Bezeroa bezeroa = Bezeroak.bilatuBezeroa(nan);
	    if (bezeroa ==null)
                    System.out.println("Bezero Ez aurkitua: NAN = "+ nan);
            		else bezeroa.ikuskatu();

        }


	static void kargatuBezeroak()
            throws FileNotFoundException, IOException {
            BufferedReader sarrera =
              new BufferedReader(new FileReader("bezeroak.txt"));
            // bezeroak.txt TESTU FITXATEGIA DA
            // lerro bakoitzean <bezeroaren> informazioa dator
            // ondoko formatuan:	nan/izena/helbidea/telefonoa/kreditua
            // Adibidea:  12341234/Pello Korta/Zugarramurdi 32-4.B/12344321/1200.50
            String lerro;
            while ((lerro=sarrera.readLine())!=FITXATEGI_AMAIERA)
            {
               StringTokenizer st=new StringTokenizer(lerro,"/");
               Bezeroa bezeroa= new Bezeroa(
                       st.nextToken(),
                       st.nextToken(),
		       st.nextToken(),
		       st.nextToken(),
                       Float.valueOf(st.nextToken()).floatValue());
                Bezeroak.gehituBezeroa(bezeroa);
            }
        }
	
static void kargatuHornitzaileak()
            throws FileNotFoundException, IOException {
            BufferedReader sarrera =
              new BufferedReader(new FileReader("hornitzaileak.txt"));
            // hornitzaileakak.txt TESTU FITXATEGIA DA
            // lerro bakoitzean <hornitzailearen> informazioa dator
            // ondoko formatuan:	nan/izena/helbidea/telefonoa/fidagarritasuna
            // Adibidea:  12341234/Pello Korta/Zugarramurdi 32-4.B/12344321/txikia
            String lerro;
            while ((lerro=sarrera.readLine())!=FITXATEGI_AMAIERA)
            {
               StringTokenizer st=new StringTokenizer(lerro,"/");
               Hornitzailea hornitzailea= new Hornitzailea(
                       st.nextToken(),
                       st.nextToken(),
		       st.nextToken(),
		       st.nextToken(),
                       st.nextToken());
		//hornitzailea.ikuskatu();
                Bezeroak.gehituHornitzailea(hornitzailea);
            }
        }
	
static void kargatuArtikuluak()
            throws FileNotFoundException, IOException {
            BufferedReader sarrera =
              new BufferedReader(new FileReader("artikuluak.txt"));
            // bezeroak.txt TESTU FITXATEGIA DA
            // lerro bakoitzean <artikuluaren> informazioa dator
            // ondoko formatuan:	izena/deskripzioa/salneurria
            // Adibidea:  LAM001/Txoria txori lamina.Zumeta-Artze/12
            String lerro;
	    Hornitzailea hornitzailea=(Hornitzailea)(Bezeroak.BiltegiHornitzaileak.elementAt(2));

            while ((lerro=sarrera.readLine())!=FITXATEGI_AMAIERA)
            {
               StringTokenizer st=new StringTokenizer(lerro,"/");
               Artikulua artikulua= new Artikulua(
                       st.nextToken(),
                       st.nextToken(),
		       Float.valueOf(st.nextToken()).floatValue(),
		       hornitzailea);
                       
		//artikulua.ikuskatu();
                Bezeroak.gehituArtikulua(artikulua);
            }
        }


}
// prozesu amaiera

   //=================================================================





class Bezeroak {
	
	 static Vector BiltegiBezeroak = new Vector();
	 static Vector BiltegiHornitzaileak = new Vector();
	 static Vector BiltegiArtikuluak = new Vector();
	 static Vector BiltegiOsagaiak = new Vector();
	 static Vector BiltegiEskaerak = new Vector();


	public static void gehituHornitzailea(Hornitzailea hornitzailea) {
		BiltegiHornitzaileak.addElement(hornitzailea);
			}

	public static void gehituArtikulua(Artikulua artikulua) {
		BiltegiArtikuluak.addElement(artikulua);
			}

	public static void gehituOsagaia(Osagaia osagaia) {
		BiltegiOsagaiak.addElement(osagaia);
			}
	
	public static void gehituEskaera(Eskaera eskaera) {
		BiltegiEskaerak.addElement(eskaera);
			}

  // --------------------------------------------------------------------

	/** gehitu Bezero berria BiltegiBezeroak Bektorean */
	public static void gehituBezeroa(Bezeroa bezeroa) {
		BiltegiBezeroak.addElement(bezeroa);
	}

	/** ezabatu Bezeroa BiltegiBezeroak Bektoretik */
	public static Bezeroa ezabatuBezeroa(String izena) {
		Bezeroa bezeroa;
		Enumeration total = BiltegiBezeroak.elements();
		while (total.hasMoreElements()) {
			bezeroa = (Bezeroa)total.nextElement();
			if (bezeroa.lortuizena().equals(izena)) {
				BiltegiBezeroak.removeElement(bezeroa);
				return bezeroa;
			}
		}
		return null;
	}

	

	public static Bezeroa bilatuBezeroa(String nan) {
           
            //3 eta 4 kasuen tratamendua
            if(nan == null){
                System.out.println("Nan-a ezin da null izan");
                return null;
            }
            //1 eta 2 kasuen tratamendua
            else if("".equals(nan)){
                System.out.println("Nan-a ezin hutsik egon");
                return null;
            }
            //6 kasuaren tratamendua
            else if(nan.length() < 8){
                System.out.println("Nan-ak ezin ditu 8 digitu baino gutxiago eduki");
                return null;
            }
            //7 kasuaren tratamendua
            else if(nan.length() > 8){
                System.out.println("Nan-ak ezin ditu 8 digitu baino gehiago eduki");
                return null;
            }
            //8 eta 9 kasuen tratamendua
            else {
                try  {  
                    double d = Double.parseDouble(nan);  
                    }  
                    catch(NumberFormatException nfe)  
                    {  
                    System.out.println("Nan-ak ezin ditu karaktererik eduki");
                    return null;  
                    }  
            }
            //10 eta 11 kasuen tratamendua
            for (int i=0;i<BiltegiBezeroak.size();i++)
                if(((Bezeroa)(BiltegiBezeroak.elementAt(i))).lortunan().equals(nan)){
                    System.out.println("Bezeroa sisteman aurkitu da");
                    return (Bezeroa)(BiltegiBezeroak.elementAt(i));
                }else {
                    System.out.println("Ez da sisteman nan hori duen bezerorik aurkitu");
                    return null;
                }          
            return null;
          }
   }

   //=================================================================


  class Bezeroa {
	
	private String nan;
	private String Izena;
	private String Helbidea;
	private String Telefonoa;
	private float kreditua;

	private Eskaera[] eskaerak = new Eskaera[20];
        public String getName(){
            return Izena;
        }
	Bezeroa(String nanB, String izenaB,String helbiB,String telB, float kredB)
		{  
		  this.nan = nanB;
		  this.Izena = izenaB;
		  this.Helbidea = helbiB; 
		  this.Telefonoa = telB;
		  this.kreditua = kredB; }


	/** Eskuratu bezeroaren nan-a */
	public String lortunan() {
		return nan;
	}

	/** Gorde bezeroaren nan-a */
	 
	public void gordenan(String nan) {
		this.nan = nan;
	}

	/** Eskuratu bezeroaren izena */
	public String lortuizena() {
		return Izena;
	}

	/** Gorde bezeroaren izena */ 
	
	public void gordeizena(String izena) {
		this.Izena = izena;
	}

	/** Eskuratu bezeroaren Helbidea */
	public String lortuHelbidea() {
		return Helbidea;
	}

	/** Gorde bezeroaren Helbidea  */
	public void gordeHelbidea(String Helbidea) {
		this.Helbidea = Helbidea;
	}

	/** Eskuratu bezeroaren Telefono zenbakia */
	public String lortuTelefonoa() {
		return Telefonoa;
	}

	/** Gorde bezeroaren Telefonoa */
	public boolean gordeTelefonoa(String Telefonoa) {
                if ("".equals(Telefonoa)){
                    System.out.println("Telefonoa hutsik dago.");
                    return false;
                }
                else if (Telefonoa == null){
                    System.out.println("Telefonoa ezin da null izan.");
                    return false;
                }
                else if (Telefonoa.length() < 9){
                    System.out.println("Telefonoak ezin ditu 9 zenbaki baino gutxiago eduki.");
                    return false;
                }
                else if (Telefonoa.length() > 9){
                    System.out.println("Telefonoak ezin ditu 9 zenbaki baino gehiago eduki.");
                    return false;
                }
                else {
                    try  {  
                        double d = Double.parseDouble(Telefonoa);  
                    }  
                    catch(NumberFormatException nfe) {  
                        System.out.println("Telefonoak ezin ditu karaktereak eduki");
                        return false;  
                    }  
                }
                this.Telefonoa = Telefonoa;
                System.out.println("Telefonoa ondo gorde da.");
                return true;
	}

	/** Eskuratu bezeroaren kreditua */
	public float lortukreditua() {
		return kreditua;
	}

	/** Gorde bezeroaren kreditua */
	public void gordekreditua(float kreditua) {
		this.kreditua = kreditua;
	}

	/** Ikuskatu bezeroaren informazio pertsonala*/
	public void ikuskatu()
           { System.out.println(" <<BEZEROA: NAN = "+this.nan+ "\n");
           System.out.println("            IZENA = "+this.Izena+ "\n");
	     System.out.println("            HELBIDEA= "+this.Helbidea+ "\n");
           System.out.println("            TELEFONOA= "+this.Telefonoa+ "\n");
	     System.out.println("            KREDITUA= "+this.kreditua+ "\n");   
        }


	/** Hemendik beherakoa Bezeroaren Eskaerak tratatzeko zatia */
	/** ======================================================= */

	/** Eskuratu bezeroaren Eskaera bat. Ez badu bilatzen 
	*   null itzultzen du. 
	*/
	public Eskaera lortuEskaera() {
		if (eskaerak == null) return null;
		Eskaera temp_Eskaera;
		for (int i = 1; i < eskaerak.length; i++) {
			if (eskaerak[i] != null) {
				temp_Eskaera = eskaerak[i];
				eskaerak[i] = null;
				return temp_Eskaera;
			}
		}
		return null;
	}

	/** Eskuratu bezeroaren Eskaera bat izena emanda. Ez badu bilatzen 
	*   null itzultzen du. 
	*/
	public Eskaera lortuEskaera(String izena) {
                if ("".equals(izena)){
                    System.out.println("Izena hutsik dago.");
                    return null;
                }
                else {
		Eskaera temp_Eskaera;
		for (int i = 1; i < eskaerak.length; i++) {
			if (eskaerak[i] != null && eskaerak[i].hartzaile.Izena.equals(izena)) {
				temp_Eskaera = eskaerak[i];
				eskaerak[i] = null;
                                System.out.println(temp_Eskaera);
				return temp_Eskaera;
			}
		}
                System.out.println("Bezero horrek ez du inongo eskaerarik.");
		return null;
                }
	}

	/** Eskuratu bezeroaren Eskaera bat hartzailearen arabera. 
	*    Ez badu bilatzen null itzultzen du. 
	*/
	public Eskaera lortuEskaera(Bezeroa hartzaile) {
            
		if (eskaerak == null) return null;
		Eskaera temp_Eskaera;
		for (int i = 1; i < eskaerak.length; i++) {
			if (eskaerak[i] != null && eskaerak[i].hartzaile == hartzaile) {
				temp_Eskaera = eskaerak[i];
				eskaerak[i] = null;
				return temp_Eskaera;
			}
		}
		return null;
	}
	/** Eskuratu bezeroaren Eskaera bat hartzailearen izenaren arabera. 
	*    Ez badu bilatzen null itzultzen du. 
	*/
	public Eskaera[] lortuEskaerak(String izena) {
                
		if (eskaerak == null) return null;
		Eskaera[] temp_eskaerak = new Eskaera[eskaerak.length];
		int j = 0;
		for (int i = 0; i < eskaerak.length; i++)
			if (eskaerak[i] != null && eskaerak[i].hartzaile.Izena.equals(izena))
				temp_eskaerak[j++] = eskaerak[i];
		Eskaera[] eskaerak = new Eskaera[j];
		for (int i = 0; i < j; i++)
			eskaerak[i] = temp_eskaerak[i];
		return eskaerak;
	}

	/** Eskuratu hartzaile batek jasoko dituen Eskaerak. */
	public Eskaera[] lortuEskaerak(Bezeroa hartzaile) {
               
               
		if (eskaerak == null) return null;
		Eskaera[] temp_eskaerak = new Eskaera[eskaerak.length];
		int j = 0;
		for (int i = 0; i < eskaerak.length; i++)
			if (eskaerak[i] != null && eskaerak[i].hartzaile == hartzaile)
				temp_eskaerak[j++] = eskaerak[i];
		Eskaera[] eskaerak = new Eskaera[j];
		for (int i = 0; i < j; i++)
			eskaerak[i] = temp_eskaerak[i];
		return eskaerak;

	}

	/** Gehitu Eskaera berri bat Bezeroari bere  
	*   kreditua 1000 baino handiagoa bada. Eragiketa ondo joan bada 
	*   true itzultzen du bestela false. 
	*/
	public boolean gehituEskaera(Eskaera eskaera) {
		if (this.lortukreditua() <= BezeroaInterface.kreditua_LIMIT) return false;
		if (eskaerak == null) eskaerak = new Eskaera[20];
		for (int i = 1; i < eskaerak.length; i++) {
			if (eskaerak[i] == null) {
				eskaerak[i] = eskaera;
				return true;
			}
		}
		return false;
	}}

class Eskaera {
	Bezeroa hartzaile;
	Osagaia[] osagaiak;

	Eskaera(Bezeroa harE, Osagaia[] osaE) {
		this.hartzaile= harE;
		//System.out.println("ESKAERA SORTUTA DAGO !!!!!!!! \n \n \n");
		this.osagaiak = osaE;
		}

public String toString(){
    String g="- ";
    int i = 0;
    while(i<osagaiak.length){
        if(osagaiak[i]!=null){    g+=osagaiak[i]+" ";
}
        i++;
    }
    return this.hartzaile.getName() + " " + g ;
}
}

class Osagaia {
	Artikulua osagaia;
	int kopurua;

	Osagaia(Artikulua artikuluaO, int kopO) {
		this.osagaia= artikuluaO;
		this.kopurua= kopO;
		}

public void ikuskatu()
           { 
	   System.out.println("<<ESKATUTAKO OSAGAIA:     \n");
	    osagaia.ikuskatu();
        System.out.println("Eskatutako KOPURUA = "+this.kopurua+"\n");    
        }
public String toString(){
    return osagaia .izena + "  -> Eskatutako KOPURUA = "+this.kopurua+"\n";
}
}

class Artikulua {
	String izena;
	String deskripzioa;
	float salneurria;
	Hornitzailea hornitzailea;

	Artikulua(String izenA, String deskA,float salnA,Hornitzailea horA)
		{  
		this.izena = izenA;
		this.deskripzioa = deskA;
		this.salneurria = salnA;
		this.hornitzailea = horA;
		}

public void ikuskatu()
           { System.out.println("<<ARTIKULUA: IZENA = "+this.izena+ "\n");
           System.out.println("            DESKRIPZIOA = "+this.deskripzioa+ "\n");
	     System.out.println("            SALNEURRIA= "+this.salneurria+ "\n");
             hornitzailea.ikuskatu();   
        }}


 class Hornitzailea {
	
	private String nan;
	private String Izena;
	private String Helbidea;
	private String Telefonoa;
	private String fidagar;

	private Artikulua[] artikuluak= new Artikulua[10];

	Hornitzailea(String nanH, String izenaH,String helbiH,String telH, String fidH)
		{  
		  this.nan = nanH;
		  this.Izena = izenaH;
		  this.Helbidea = helbiH; 
		  this.Telefonoa = telH;
		  this.fidagar = fidH; }

	public void ikuskatu()
           { System.out.println("<<HORNITZAILEA: NAN = "+this.nan+ "\n");
           System.out.println("            IZENA = "+this.Izena+ "\n");
	     System.out.println("            HELBIDEA= "+this.Helbidea+ "\n");
           System.out.println("            TELEFONOA= "+this.Telefonoa+ "\n");
	     System.out.println("            FIDAGARRITASUNA= "+this.fidagar+ "\n");   
        }

}

interface BezeroaInterface {
	static final float kreditua_LIMIT = 1000f;
	abstract float lortukreditua();
}


            









