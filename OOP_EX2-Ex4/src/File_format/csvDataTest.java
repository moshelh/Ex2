package File_format;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class csvDataTest {
	 csvData dTest=new csvData("C:\\Users\\ariel\\git\\Ex2-Ex4\\WigleWifi_20171201110209.csv");
	 
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void getIndexOfHeaderTest() {
		String header="FirstSeen";
		int indexExpected=3;
		int actual=dTest.getIndexOfHeader(header);
		assertEquals(actual,indexExpected);
	}
	@Test
	void getElementTest() {
		String s="SSID";
		int index=2;
		String expected="Volvo247";
		String actual=dTest.getElement(s, index);
		assertTrue(actual.equals(expected));
	}
	@Test
	void getLineTest() {
		int index=1;
		String []line=dTest.getLine(index);
		
		String [] expected= {"40:65:a3:35:4c:c4", "Efrat", "[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS]","2017-12-01 10:49:08","1","-75", "32.17218268216534", "34.81446401702757", "13.65040888895076","6", "WIFI"};
		boolean eqs=true;
		for(int i=0;i<line.length;i++) {
			
			if(!line[i].equals(expected[i]))
				eqs=false;
		
		}
		assertTrue(eqs);
	}
	@Test
	void getrowTest() {
		String row = dTest.getRaw("SSID");
		String expected = "Efrat,Volvo247,love,Chakir,Orit,Mevohot_1,Partner,DIR-825-4f83,DIR-825-4f83,Partner,NIPPON_3687,NIPPON_3687,Hotbox,varda,Helen.,Partner,Ben Ami_2.4,varda,ronkla2_5,mika1,Partner,Gana7_2GExt,Guymic,stephane,devolo-0f4,HOTBOX-4D4E,Neeman2.4,oved-main_2EX,oved-main,Partner,Lili,Liliup,ELCHARAR_2.4,Alpha125,Bezeq Free T00C36,dlink-A09C,edimax_5G_A9241C,spielman,forestisthebest,evanson,KaymeraDev,KaymeraDev,spielman,evanson,BezeqNGN_001489_2.4GHz_1,oved-main,Partner,spielman,Jamcanup,Jamcandown,edimax_2.4G_ruty,HP-Print-C1-Deskjet 4640 series,HP-Print-C1-Deskjet 4640 series,iFOREX,INGENEO,DIRECT-a8-HP M477 LaserJet,Candan,LRWN,HOTBOX111,LRWN,LRWN,  InnovationEndeavors,HOTFiber-400D,LRWN,Talfamily,HOTBOX-8156,Partner,Fuck Off Yourself,Fuck Off ext,Mheta_AP,ELCHARAR_2.4,Bezeq Free T00C36,Partner,nina,hilda,DIRECT-29-HP OfficeJet Pro 8710,Candan,dlink,orange,Bezeq Free,Partner,orange,HOTBOX-F028,HOTBOX-F028,Partner,amnon,Is,My_Internet,Beni,Beni,HOTBOX,HOTBOX111,My_Internet,MNP_HOME_2.4GHz_1,test012,Yotam _ work _ room,tal,sirocco_2.4o,tal,nurit,044870715,tal2,sirocco_2.4o,DIRECT-75-HP DeskJet 4670 series,Partner,DIR-825-4f83,Oded 5Ghz,Oded 2.4Ghz,Oded 5Ghz,SIEMENS_LivingRoom,frank,TP-LINK_E3CA,ter123,Daizad,Daizad,yotam17,Beni,HOTBOX,Baruch_2.4,yotam17,Yotam_Shir,claire,Bezeq Free 672B84,ter123,BezeqFree,geller,Partner,DIRECT-1C-HP DeskJet 3830 series,nina,UFI_UF230_B3F,hot,klaiman,WR,HOTBOX-651B,Partner,nina,landau,LRWN,HOTBOX-651B,klaiman,Partner,frank,UFI_UF230_B3F,ter123,hot,TUCHLER,UFI_UF230_B3F,Laufer-wifi,HP-Print-AF-Officejet Pro 6830,Partner,Oded 5Ghz,Oded 2.4Ghz,DIR-825-4f83,Partner,DIR-825-4f83,Bezeq Free GA32E3,Lahav,Partner,love," ;
		assertTrue(row.equals(expected));
	}
	

}
