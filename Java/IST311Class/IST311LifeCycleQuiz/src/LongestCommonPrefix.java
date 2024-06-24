import java.util.ArrayList;

/**
 * This class includes functionality to find the longest common prefix in an array of Strings
 *
 * If there is no common prefix, return an empty string ""
 *
 * Example: in this array ["flower","flow","flight"], we would return "fl"
 *
 * Example: in this array ["flower","flow"], we would return "flow"
 *
 * Example: in this array ["dog","racecar","car"], we would return ""
 *
 * Example: in this array [], we would return "" as there are no strings at all
 */
public class LongestCommonPrefix {

    public String findLongestCommonPrefix(ArrayList<String> strings) {
        if(strings.isEmpty()){
            return "";
        }else{
            // get the longest prefix as just the first one
            String prefix = strings.get(0);

            // loop through all of the strings
            for (String string : strings) {
                // do a temp string builder to keep track of current prefix
                StringBuilder tempPrefix = new StringBuilder();
                // loop through the length of the prefix (the longest prefix can't be longer than the first string
                for (int i = 0; i < prefix.length(); i++) {
                    // make sure you aren't going out of bounds
                    if (string.length() > i) {
                        // compare them
                        if (prefix.charAt(i) == string.charAt(i)) {
                            // add if the match
                            tempPrefix.append(prefix.charAt(i));
                        } else {
                            // break out of the loop if they don't
                            break;
                        }
                    }
                }
                // update the prefix
                prefix = tempPrefix.toString();
            }

            // return the prefix
            return prefix;
        }//end if else statement

    }

    public String findLongestCommonSuffix(ArrayList<String> strings) {
        if(strings.isEmpty()){
            return "";
        }else{
            // get the longest prefix as just the first one
            String suffix = strings.get(0);

            // loop through all of the strings
            for (String string : strings) {
                // do a temp string builder to keep track of current prefix
                StringBuilder tempSuffix = new StringBuilder();
                // loop through the length of the prefix (the longest prefix can't be longer than the first string
                int indexString = string.length()-1;
                for (int i = suffix.length()-1; i>=0; i--) {
                    // make sure you aren't going out of bounds
                        // compare them
                        if (suffix.charAt(i) == string.charAt(indexString)) {
                            // add if the match
                            tempSuffix.append(suffix.charAt(i));
                        } else {
                            // break out of the loop if they don't
                            break;
                        }
                        indexString--;
                        if(indexString<0){
                            break;
                        }

                }
                // update the prefix
                suffix = tempSuffix.reverse().toString();
            }

            // return the prefix
            return suffix;
        }//end if else statement

    }
}