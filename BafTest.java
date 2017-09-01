package baf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hello on 2017/9/1.
 */
public class BafTest {

    public static void main(String[] args) {
        String str = "{OPER 0} {PAY_DATE 1} {PAY_MONEY 0}";
        char ch[] = str.toCharArray();
        Map map = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            StringBuffer sb = new StringBuffer();
            StringBuffer sb1 = new StringBuffer();
            if("{".equals(String.valueOf(ch[i]))){
                for (int j = i + 1; j < ch.length; j++){
                    if (!" ".equals(String.valueOf(ch[j]))){
                        sb.append(String.valueOf(ch[j]));
                    } else {
                        i = j;
                        break;
                    }
                }
            }
            if (" ".equals(String.valueOf(ch[i]))){
                for (int k = i + 1; k < ch.length; k++){
                    if (!"}".equals(String.valueOf(ch[k]))){
                        sb1.append(String.valueOf(ch[k]));
                    } else {
                        i = k;
                        break;
                    }
                }
            }
            map.put(sb, sb1);
            if (i < ch.length){
                i = i + 1;
            }
            sb=null;
            sb1=null;
        }

        System.out.println(map);
    }
}
