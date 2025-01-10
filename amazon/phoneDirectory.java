import java.util.*;

class phoneDirectory {
    public static ArrayList<ArrayList<String>> displayContacts(int n, String[] contact, String s) {
        // Using a TreeSet to store unique contacts and maintain lexicographical order
        TreeSet<String> sortedContacts = new TreeSet<>(Arrays.asList(contact));
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        StringBuilder prefix = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            prefix.append(c);
            String currentPrefix = prefix.toString();
            
            // Find matching contacts
            ArrayList<String> matches = new ArrayList<>();
            for (String entry : sortedContacts) {
                if (entry.startsWith(currentPrefix)) {
                    matches.add(entry);
                }
            }
            
            // If no matches found, add "0"
            if (matches.isEmpty()) {
                matches.add("0");
            }
            
            result.add(matches);
        }
        
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        int n = 3;
        String[] contact = {"geeikistest", "geeksforgeeks", "geeksfortest"};
        String s = "geeips";
        
        phoneDirectory ob = new phoneDirectory();
        ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
        for (ArrayList<String> res : ans) {
            System.out.println(String.join(" ", res));
        }
    }
}
