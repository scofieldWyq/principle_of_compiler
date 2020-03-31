package com.unclew.compiler.lexical;

/**
 * Created by wuyingqiang
 * on 2020/3/29-11:04 下午.
 *
 * 提供处理的字符集合
 *
 * @author wuyingqiang
 * @since 1.0
 */
public interface WordMachine {
    // read
    char current(); // 返回当前没有被消费的字符
    char preview(int offset); // 预览当前位置后第 {offset} 个字符
    boolean isEnd();

    // operation
    void next(int offset); // 滑动到下 {offset} 个字符
    void reset();
    void fallback(); // 退一步
}
