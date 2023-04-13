public class P2 {
    public static int findName(String[] names, String name){
        for (int i = 0; i < names.length; i++) {
            if(names[i].equals(name)){
                return i;
            }
        }
        return -1;
    }
}
