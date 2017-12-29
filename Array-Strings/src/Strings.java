import java.util.HashMap;
import java.util.Map;

public class Strings {

	public static void main(String[] args) {
		System.out.println(isUnique("abd%!~oe`	 s\n"));
		System.out.println(arePermutations("acb3452", "2354cab"));
		System.out.println(isPermutationPalindrome("abcabctdtA #"));
	}
	
	public static boolean isUnique(String string) {
		
		if(string.length() > 128)
			return false;
		boolean charSet[] = new boolean[128];
		for(char c : string.toCharArray()) {
			if(charSet[c])
				return false;
			charSet[c] = true;			
		}
		return true;
	}
	
	public static boolean arePermutations(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		boolean charSet[] = new boolean[128];
		for(char c : str1.toCharArray()) {
			charSet[c] = true;			
		}
		for(char c : str2.toCharArray()) {
			if(!charSet[c])
				return false;
		}
		return true;
	}
	
	public static boolean isPermutationPalindrome(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c: str.toCharArray()) {
			int value = c;
			int a = 'a';
			int z = 'z';
			if(value<a || value>z )
				continue;
			int count = 0;
			//c = Character.toLowerCase(c);
			if(map.containsKey(c)) {
				count = map.get(c);
			}
			count++;
			map.put(c, count);
		}
		int oddCount = 0;
		for(int count : map.values()) {
			if(count%2 == 1)
				oddCount++;
			if(oddCount > 1)
				return false;
		}
		
		return true;
	}

}
