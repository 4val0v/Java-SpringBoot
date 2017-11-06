
public class StringManipulator {

    public String trimAndConcat(String str1, String str2) {
        String trim1 = str1.trim();
        String trim2 = str2.trim();
        String concat = trim1.concat(trim2);
        return concat;
    }

    public Integer getIndexOrNull(String str, char letter) {
        Integer index = str.indexOf(letter);
        if (index >= 0) {
            return index;
        } else {
            return null;
        }
    }

    public Integer getIndexOrNull(String str1, String str2) {
        Integer index = str1.indexOf(str2);
        if (index >= 0) {
            return index;
        } else {
            return null;
        }
    }

     public String concatSubstring(String str1, int int1, int int2, String str2) {
         String substring = str1.substring(int1, int2);
         String concat = substring.concat(str2);
         return concat;
     }
}


// How CD did it

public class StringManipulation{
    
        public String trimAndConcat(String string1, String string2){
            return string1.trim() + string2.trim();
        }
    
        public Integer getIndexOrNull(String string1, char char1){
            int idx = string1.indexOf(char1);
            
            // if idx == -1, return null, else return the idx
            return idx == -1 ? null : idx;
        }
    
        public Integer getIndexOrNull(String string1, String string2){
            int idx = string1.indexOf(string2);
            
            // if idx == -1, return null, else return the idx
            return idx == -1 ? null : idx;
        }
    
        public String concatSubstring(String string1, int int1, int int2, String string2){
            String substring = string1.substring(int1, int2);
            return substring + string2;
        }
    }
    