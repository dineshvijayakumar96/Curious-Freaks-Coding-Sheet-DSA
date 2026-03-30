package stack_data_structure;

import java.util.Stack;

public class ReverseAStack {

    public static void reverseStack(Stack<Integer> st) {
        int[] temp = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            temp[i] = st.get(i);
        }
        st.clear();
        for (int i = temp.length - 1; i >= 0; i--) {
            st.push(temp[i]);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        reverseStack(st);
        System.out.println("Output: " + st);
    }
}
