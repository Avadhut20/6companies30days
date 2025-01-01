import java.util.HashMap;

public class bullncows {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : secret.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int bull = 0;
        int cow = 0;
        
        // First pass: Count bulls
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
                map.put(secret.charAt(i), map.get(secret.charAt(i)) - 1);
                if (map.get(secret.charAt(i)) == 0) {
                    map.remove(secret.charAt(i));
                }
            }
        }
        
        // Second pass: Count cows
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i) && map.containsKey(guess.charAt(i))) {
                cow++;
                map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                if (map.get(guess.charAt(i)) == 0) {
                    map.remove(guess.charAt(i));
                }
            }
        }
        
        // Construct the result
        return bull + "A" + cow + "B";
    }
}
