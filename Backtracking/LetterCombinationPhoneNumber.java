class Solution {
    public List<String> letterCombinations(String digits) {
        // Map of digits to corresponding letters
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        // Edge case: if input is empty
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        backtrack(result, map, digits, 0, new StringBuilder());
        return result;
    }

    public void backtrack(List<String> result, Map<Character, String> map, String digits, int index, StringBuilder current) {
        // Base case: when the current combination's length equals the input digits' length
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = map.get(digits.charAt(index));

        // Loop through each letter and recurse
        for (int i = 0; i < letters.length(); i++) {
            // Add the current letter to the combination
            current.append(letters.charAt(i));

            // Recurse to process the next digit
            backtrack(result, map, digits, index + 1, current);

            // Backtrack: remove the last letter to try the next one
            current.deleteCharAt(current.length() - 1);
        }
    }
}

        /*//valid for only 1 or 2 digits 
        Map<String, String> map = new HashMap<>();

        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        // Edge case: if input is empty
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> Output = new ArrayList<>();

        if (digits.length() == 1) {
            // Handle case for single digit
            String First_st = String.valueOf(digits.charAt(0));
            for (int i = 0; i < map.get(First_st).length(); i++) {
                Output.add(String.valueOf(map.get(First_st).charAt(i)));
            }
        } else {
            // Handle case for two or more digits
            String First_st = String.valueOf(digits.charAt(0));
            String Second_st = String.valueOf(digits.charAt(1));

            for (int i = 0; i < map.get(First_st).length(); i++) {
                for (int j = 0; j < map.get(Second_st).length(); j++) {
                    Output.add(
                        String.valueOf(map.get(First_st).charAt(i)) 
                        + String.valueOf(map.get(Second_st).charAt(j))
                    );
                }
            }
        }

        return Output;
    }
}*/


/*
                      (level=0, prefix="")
                    /      |      \
               [a]         [b]        [c]
              / | \       / | \      / | \
           [ad][ae][af] [bd][be][bf][cd][ce][cf]   ← level=1 (leaves)

           Why a for-loop here?

At each position (i.e. each digit) you have multiple choices (its mapped letters). Backtracking always follows the pattern:

Loop over all choices at this level.
Choose one (append letter).
Recurse to build the rest.
Un-choose (remove letter) and loop on to the next choice.
*/
