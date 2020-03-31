package com.unclew.compiler.lexical;

/**
 * Created by wuyingqiang
 * on 2020/3/31-10:34 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class Token {
    private TokenType type;
    private StringBuilder value;

    Token(char c, TokenType type) {
        value = new StringBuilder();
        value.append(c);
        this.type = type;
    }

    public void append(char c) {
        value.append(c);
    }

    public void changeType(TokenType t) {
        type = t;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value=\"" + value +
                "\"}";
    }
}
