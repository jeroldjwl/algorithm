package org.jerold.algorithm;

import org.jerold.stack.Stack;

/**
 * Created by Jerold on 2016/10/31.
 */
public class StackAlgorithm {
    // 1. 判断输入的字符串的括号是否匹配问题
    public boolean isIllegal(String str) {
        Stack stack = new Stack();
        boolean isIllegal = true;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            switch (c) {
                case '(':
                    stack.push(')');
                    continue;
                case '[':
                    stack.push(']');
                    continue;
                case '{':
                    stack.push('}');
                    continue;
                case ')':
                    char tmp = (char) stack.pop();
                    if (c != tmp) {
                        isIllegal = false;
                        break;
                    } else continue;
                case ']':
                    tmp = (char) stack.pop();
                    if (c != tmp) {
                        isIllegal = false;
                        break;
                    } else continue;
                case '}':
                    tmp = (char) stack.pop();
                    if (c != tmp) {
                        isIllegal = false;
                        break;
                    } else continue;

                default:
            }
        }
        return isIllegal;
    }

    // 2. 如何把中缀表达式转换为后缀表达式
    public String transfer(String preStr) {
        char[] origin = preStr.toCharArray();
        char[] result = new char[origin.length];
        int count = 0;
        for (int i = 0; i < origin.length; i++) {
            char tmp = origin[i];
            if (tmp == '(' || tmp == ')')
                continue;
            else if (tmp == '+' || tmp == '-' || tmp == '*' || tmp == '/') {
                char next = origin[i + 1];
                if (!isIllegalCharacter(next)) {
                    System.out.println("contains illegal character " + next);
                    return null;
                }
                result[count++] = next;
                result[count++] = tmp;
                i++;
            } else if (tmp >= 'a' || tmp <= 'z' || tmp >= 'A' || tmp <= 'Z') {
                result[count++] = tmp;
            }
        }
        return String.valueOf(result).trim();
    }

    private boolean isIllegalCharacter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    // 3. 给定一个栈，如何只使用push和pop逆置栈中内容
    public void reverseStack(Stack stack) {
        if (stack == null)
            return;
        int tmp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, tmp);
    }

    private void insertAtBottom(Stack stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int tmp = stack.pop();
        insertAtBottom(stack, data);
        stack.push(tmp);
    }

    public static void main(String[] args) {
        StackAlgorithm sa = new StackAlgorithm();
        String origin = "[*(*[++]*){()}]";
        System.out.println(sa.isIllegal(origin));
        origin = "(A+B)*C-D";
        origin = "A+B-C";
        System.out.println(sa.transfer(origin));
    }
}
