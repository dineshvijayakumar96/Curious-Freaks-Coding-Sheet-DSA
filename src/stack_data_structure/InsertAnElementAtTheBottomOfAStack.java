package stack_data_structure;

import java.util.Stack;

public class InsertAnElementAtTheBottomOfAStack {

    public static Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        Stack<Integer> temp = new Stack<>();
        while (!st.empty()) {
            temp.push(st.pop());
        }
        temp.push(x);
        while (!temp.empty()) {
            st.push(temp.pop());
        }
        return st;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);
        st.push(8);
        int x = 2;
        System.out.println("Output: " + insertAtBottom(st, x));
    }
}
