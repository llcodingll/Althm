import java.util.*;

class BoJ1157{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String[] st = sc.next().split("");
        
        for(int i=0; i<st.length; i++){
            st[i] = st[i].toUpperCase();
            if(map.containsKey(st[i])){
                map.put(st[i], map.get(st[i])+1);
            }
            else{
                map.put(st[i], 1);
            }
        }
        final Holder maxHolder = new Holder();
        final Holder maxstHolder = new Holder();
        
        map.forEach((key, value) -> {
            if (value > maxHolder.value) {
                maxHolder.value = value;
                maxstHolder.value = (int) key.charAt(0);
            } else if (value == maxHolder.value) {
                maxstHolder.value = 63; // 63 is the ASCII value for '?'
            }
        });
        
        System.out.print((char) maxstHolder.value);
    }
}

class Holder {
    int value = -1;
}