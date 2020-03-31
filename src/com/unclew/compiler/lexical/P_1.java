package com.unclew.compiler.lexical;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyingqiang
 * on 2020/3/29-10:49 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class P_1 {

    public static void main(String[] args) {
        // 解析 TODO age >= 45
        String str = "age >= 45";
        SimpleLetterMachine slm = new SimpleLetterMachine(str);

        List tokens = new ArrayList<Token>();

        char c;
        Token token = null;
        TokenType t = TokenType.INIT;

        while (!slm.isEnd()) {
            c = slm.current();
            System.out.print(c);

            switch (t) {
                case INIT:
                    boolean canAdd = true;
                    if (isLetter(c)) {
                        t = TokenType.IDENTIFY;
                    } else if (c == '>') {
                        t = TokenType.GT;
                    } else if (isDigit(c)) {
                        t = TokenType.DIGIT;
                    } else {
                        canAdd = false;
                    }

                    if (canAdd) {
                        token = new Token(c, t);
                    }

                    break;
                case IDENTIFY:
                    if (!isLetter(c)) {
                        t = TokenType.INIT;
                        slm.fallback();
                    } else {
                        token.append(c);
                    }

                    break;
                case GT:
                    if (c == '=') {
                        t = TokenType.GE;
                        token.changeType(t);
                        token.append(c);
                    } else {
                        t = TokenType.INIT;
                        slm.fallback();
                    }
                    break;
                case GE:
                    t = TokenType.INIT;
                    slm.fallback();
                    break;
                case DIGIT:
                    if (isDigit(c)) {
                        token.append(c);
                    } else {
                        t = TokenType.INIT;
                        slm.fallback();
                    }
                    break;
                default:
                    slm.next(1);
            }

            if (t == TokenType.INIT && token != null) {
                tokens.add(token);
                token = null;
            }

            slm.next(1);
        }

        if(token != null) {
            tokens.add(token);
            token = null;
        }

        System.out.println();
        System.out.println(tokens);
        slm.reset();
    }

    static boolean isLetter(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
