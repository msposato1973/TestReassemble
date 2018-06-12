package fragment.submissions.reassembler;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

 

import fragment.submissions.bean.ResultConcat;
import fragment.submissions.bean.VariationOf2;
import fragment.submissions.constant.ConstantValue;
import fragment.submissions.error.ReassembleException;

/***
 * 
 * @author maxp
 *
 */
public class ReassemblerImpl implements Reassembler {
	
	/**
	 * 
	 * @param fragment
	 * @return
	 */
	public String reassemble(final String fragment) {
		
		if(fragment == null) { 
			throw new ReassembleException(ConstantValue.FRAGMNEBT_ERROR);
		}
		
		//Return list of fragments separeted by ;
		List<String> fragments = splitValues(fragment);
		
		if(fragments.size() == 1) { 
			return fragment; 
		}else{
			
			List<VariationOf2> variations = null;
			while (fragments.size() > 1) {
				variations = getAllVariationsOf2(fragments.size());
				ResultConcat max = new ResultConcat(fragments.get(0) + fragments.get(1), 0);
				int maxPosition = 0;
				int currentPosition = 0;
				for (VariationOf2 variation : variations) {
					ResultConcat concacResult = concatWithOverlappingCharacters(fragments.get(variation.getI1()), fragments.get(variation.getI2()));
					if (concacResult.getNumberOfOverlappingChars() > max.getNumberOfOverlappingChars()) {
						max = concacResult;
						maxPosition = currentPosition;
					}
					currentPosition++;
				}
				safeRemove(fragments, variations.get(maxPosition).getI1(), variations.get(maxPosition).getI2());
				fragments.add(max.getConcatenatedString());
			}
			return fragments.get(ConstantValue.FIRST);
		}
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public List<VariationOf2> getAllVariationsOf2(int n) {
		List<VariationOf2> variationsOf2 = new ArrayList<VariationOf2>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				variationsOf2.add(new VariationOf2(i, j));
			}
		}
		return variationsOf2;
	}
	
	/**
	 * 
	 * @param fragments
	 * @param index1
	 * @param index2
	 */
	public void safeRemove(List<String> fragments, int index1, int index2) {
		List<Integer> indicesToRemove = Arrays.asList(index1, index2);
		Collections.sort(indicesToRemove, Collections.reverseOrder());
		for (Integer index : indicesToRemove) fragments.remove(index.intValue());
	}
	
	/**
	 * 
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public ResultConcat concatWithOverlappingCharacters(final String s1, final String s2) {
		// Verification and management of nulls, if you do not regret anything
		if (s1 == null || s1.isEmpty()) {
			if (s2 == null || s2.isEmpty()) {
				return new ResultConcat(ConstantValue.EMPTY_VALUE, 0);
			}
			return new ResultConcat(s2, 0);
		}
		if (s2 == null || s2.isEmpty()) {
			return new ResultConcat(s1, 0);
		}
		if (s1.contains(s2)) {
			return new ResultConcat(s1, s2.length());
		}

		// A check is made to ensure that both strings have at least one character
		int len1 = s1.length() - 1;
		char last1 = s1.charAt(len1);
		char first2 = s2.charAt(0);

		// Find the first likely match, limited by the length of s1
		int indexOfLast2 = s2.lastIndexOf(last1, Math.min(len1, s2.length() - 1));
		while (indexOfLast2 != -1) {
			if (s1.charAt(len1 - indexOfLast2) == first2) {
				// After a first partial check, a complete check is performed
				int ix = indexOfLast2;
				while ((ix != -1) && (s1.charAt(len1 - indexOfLast2 + ix) == s2.charAt(ix)))
					ix--;
				if (ix == -1) {
					return new ResultConcat(s1 + s2.substring(indexOfLast2 + 1), indexOfLast2 + 1);
				}
			}

			// He searched for the next probable
			indexOfLast2 = s2.lastIndexOf(last1, indexOfLast2 - 1);
		}

		// no match was found, so concatenate the whole string
		return new ResultConcat(s1 + s2, 0);
	}

	@Override
	public boolean validatePrecondition(String[] args) {
		if((args.length > ConstantValue.FIRST) && (args[ConstantValue.FIRST]==null)){
	         
        	throw new ReassembleException(ConstantValue.PRECONDITION_ERROR);
        }else return true;
	}

	 
	private List<String> splitValues(String fragment) {
		List<String> fragments = new ArrayList<String>(Arrays.asList(fragment.split(ConstantValue.SEPARATOR)));
		return fragments;
	}
	
	 
	 
	 
}
