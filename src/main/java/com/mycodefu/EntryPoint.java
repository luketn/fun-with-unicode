package com.mycodefu;

import java.nio.charset.Charset;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;

public class EntryPoint {
    /**
     * Combining characters!
     */
    public static void main(String[] args) {
        char[] motleyCrue = {'M','o','\u0308','t','l','e','y',' ','C','r','u','\u0308','e'};
        String m = "Mo\u031Ftley";
        System.out.println(motleyCrue);
        System.out.println(motleyCrue.length);
        System.out.println(m);

        for (char c = 0x0300; c < 0x0370; c++) {
            System.out.printf("0x%x: O%cO%n", (int)c, c);
        }

        //skin tones are also achieved with combining characters
        int thumbs_up = 0x1f44d;
        int medium_dark_skin = 0x1f3fe;
        String dark_skin_thumb = new String(new int[]{thumbs_up, medium_dark_skin}, 0, 2);
        System.out.println(dark_skin_thumb);

        int woman = 0x1f469;
        int zero_width_joiner = 0x200d;
        int rocket = 0x1f680;
        String female_astronaut = new String(new int[]{woman, medium_dark_skin, zero_width_joiner, rocket}, 0, 4);
        System.out.println(female_astronaut);

        int flag_black = 0x1F3F4;
        String england = new String(new int[]{flag_black, 0xE0067, 0xE0062, 0xE0065, 0xE006E, 0xE0067, 0xE007F}, 0, 7);
        System.out.println(england);

        String p = "p\u0300";
        String preg = "p";
        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);
        if (collator.compare(p, preg) != 0) {
            throw new RuntimeException("Bad normalizer.");
        }
    }
}
