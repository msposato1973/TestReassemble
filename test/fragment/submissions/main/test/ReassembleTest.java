package fragment.submissions.main.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fragment.submissions.main.ReassembleMain;
import fragment.submissions.reassembler.Reassembler;
import fragment.submissions.reassembler.ReassemblerImpl;

public class ReassembleTest {

	private Reassembler lineReassembler = null;
	private String[] args = null;
	public  String S_INPUT_TEST_CASE_1 = "";
	public  String S_OUTPUT_TEST_CASE_1 = "";
	
	@Before
	public void setUp() throws Exception {
		lineReassembler = new ReassemblerImpl();
		args = new String[]{"D://newtest.txt"};
		
	    S_INPUT_TEST_CASE_1 = "m quaerat voluptatem.;pora incidunt ut labore et d;, consectetur, adipisci velit;olore magnam aliqua;idunt ut labore et dolore magn;uptatem.;i dolorem ipsum qu;iquam quaerat vol;psum quia dolor sit amet, consectetur, a;ia dolor sit amet, conse;squam est, qui do;Neque porro quisquam est, qu;aerat voluptatem.;m eius modi tem;Neque porro qui;, sed quia non numquam ei;lorem ipsum quia dolor sit amet;ctetur, adipisci velit, sed quia non numq;unt ut labore et dolore magnam aliquam qu;dipisci velit, sed quia non numqua;us modi tempora incid;Neque porro quisquam est, qui dolorem i;uam eius modi tem;pora inc;am al";
		
	    S_OUTPUT_TEST_CASE_1 = "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, "
				+ "consectetur, adipisci velit, sed quia non numquam eius modi tempora "
				+ "incidunt ut labore et dolore magnam aliquam quaerat voluptatem.";
	}

	@Test
	public void testMain() throws Exception {
		
		ReassembleMain reassembleMain = new ReassembleMain();
		reassembleMain.main(args);
		 
	}

	 
	@Test
    public void testMain2() throws Exception {
        String input = "O draconia;conian devil! Oh la;h lame sa;saint!";
        String expectedOutput = "O draconian devil! Oh lame saint!";

        String output = lineReassembler.reassemble(input);

        assertEquals(output, expectedOutput);

    }	
	
	@Test
    public void testMain3() throws Exception {
        String input = "O draconia;conian devil! Oh la;h lame sa;saint!";
        String expectedOutput = "O draconian devil! Oh lame saint!";

        String output = lineReassembler.reassemble(input);

        assertEquals(output, expectedOutput);

    }	
	
	@Test
	public void reassembleTestCase1() {
		lineReassembler.reassemble(S_INPUT_TEST_CASE_1);
		assertEquals(lineReassembler.reassemble(S_INPUT_TEST_CASE_1),S_OUTPUT_TEST_CASE_1);
	}
	
	@Test
	public void reassembleTestCase2() {
		lineReassembler.reassemble(S_INPUT_TEST_CASE_1);
		assertEquals(lineReassembler.reassemble(S_INPUT_TEST_CASE_1),S_OUTPUT_TEST_CASE_1);
	}

	@Test
	public void reassembleWithTwoNoOverlappingFragmentsShouldWork() {
		assertEquals(lineReassembler.reassemble("naples ;was beautiful"), "naples was beautiful");
	}
	
	  
}
