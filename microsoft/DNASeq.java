
import java.util.*;

public class DNASeq {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) {
            return result;
        }

        
        Set<String> seen = new HashSet<>();
        
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String subSequence = s.substring(i, i + 10);
            if (seen.contains(subSequence)) {
                repeated.add(subSequence);
            } else {
                seen.add(subSequence);
            }
        }

        
        result.addAll(repeated);
        return result;
    }

    public static void main(String[] args) {
        DNASeq solution = new DNASeq();

        String s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(solution.findRepeatedDnaSequences(s1)); 
        String s2 = "AAAAAAAAAAAAA";
        System.out.println(solution.findRepeatedDnaSequences(s2)); 

        String s3 = "ACGTACGTACGT";
        System.out.println(solution.findRepeatedDnaSequences(s3)); 
    }
}

