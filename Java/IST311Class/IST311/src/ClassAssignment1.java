public class ClassAssignment1 {
    public static void main(String[] args) {
        String word = "amxt";
        int length = 1;
        for(int i=0;i<word.length();i++) {
            for(int j=0;j<word.length();j++){
                if(j+length>word.length()){
                    break;
                }else{
                    System.out.println(word.substring(j,j+length));
                }

            }
            length++;
        }
    }
}