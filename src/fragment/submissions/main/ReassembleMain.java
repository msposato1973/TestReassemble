package fragment.submissions.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import fragment.submissions.constant.ConstantValue;
import fragment.submissions.error.ReassembleException;
import fragment.submissions.reassembler.Reassembler;
import fragment.submissions.reassembler.ReassemblerImpl;

public class ReassembleMain {

		/**
		 * @param args
		 */
		public static void main(String[] args) {
	
			
			boolean precondition = false;
			Reassembler reassInstance = new ReassemblerImpl();
			precondition = reassInstance.validatePrecondition(args) ;
			
			
			if(precondition){
				 
				try (
					 
					BufferedReader in = new BufferedReader(new FileReader(args[ConstantValue.FIRST]))) { 
			 		String fragmentProblem; 
			 		while ((fragmentProblem = in.readLine()) != null) { 
			 			System.out.println(reassInstance.reassemble(fragmentProblem));
			 		} 
	
			    }catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	
		/**
		 * 
		 * @param args
		 * @return boolean
		 */
		public static boolean validatePrecondition(String[]  args) {
			//Pre validity condition of input data
			//Verify the consistency of the input value
	        if((args.length > ConstantValue.FIRST) && (args[ConstantValue.FIRST] == null)){
	        	throw new ReassembleException(ConstantValue.PRECONDITION_ERROR);
	        }else return true;
	    }
		
		
		 
}

	
