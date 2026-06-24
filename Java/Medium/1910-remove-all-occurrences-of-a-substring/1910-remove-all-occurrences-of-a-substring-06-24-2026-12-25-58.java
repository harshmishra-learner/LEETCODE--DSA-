class Solution {
    public String removeOccurrences(String s, String part) {
      
        StringBuilder sb = new StringBuilder(s);
        int partLen = part.length();
        int index = sb.indexOf(part);
        
        while (index != -1) {
            sb.delete(index, index + partLen);
            
            index = sb.indexOf(part);
        }
        
        return sb.toString();
    }
}