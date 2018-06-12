package fragment.submissions.reassembler;

import java.util.List;

import fragment.submissions.bean.ResultConcat;
import fragment.submissions.bean.VariationOf2;


public interface Reassembler {
	 
	String reassemble(final String fragment);
	boolean validatePrecondition(String[] args) ;
	List<VariationOf2> getAllVariationsOf2(int n);
	ResultConcat concatWithOverlappingCharacters(final String s1, final String s2);
	void safeRemove(List<String> fragments, int index1, int index2);
	 
	 
}
