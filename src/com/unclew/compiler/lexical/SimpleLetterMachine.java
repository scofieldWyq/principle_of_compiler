package com.unclew.compiler.lexical;

/**
 * Created by wuyingqiang
 * on 2020/3/30-11:24 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class SimpleLetterMachine implements WordMachine {
    private int cursor = 0;
    private int offset = 0;

    private String str;

    public SimpleLetterMachine(String str) {
        this.str = str;
    }

    @Override
    public char current() {
        return str.charAt(cursor);
    }

    @Override
    public char preview(int offset) {
        if(cursor + offset < str.length()) {
            return str.charAt(cursor + offset);
        }

        return (char)-1;
    }

    @Override
    public boolean isEnd() {
        return cursor == str.length();
    }

    @Override
    public void next(int offset) {
        if(cursor < str.length())
            cursor++;
    }

    @Override
    public void reset() {
        cursor = 0;
    }

    @Override
    public void fallback() {
        if(cursor > 1) {
            cursor--;
        }
    }


    public static void main(String[] args) {
        // test
        String str = "jdaskjhdgashdgasgdasdgasjgdhkjasgdkasgdas";

        SimpleLetterMachine slm = new SimpleLetterMachine(str);
        while(!slm.isEnd()) {
            System.out.print(slm.current());
            slm.next(1);
        }
    }
}
