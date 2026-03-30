package stack_data_structure;

import java.util.Stack;

public class SortAStack {

    public static void sortStack(Stack<Integer> st){
        if (!st.isEmpty()){
            int temp = st.pop();
            sortStack(st);
            insertSorted(st, temp);
        }
    }

    private static void insertSorted(Stack<Integer> st, int temp){
        if (st.isEmpty() || temp > st.peek()){
            st.push(temp);
            return;
        }
        int top = st.pop();
        insertSorted(st, temp);
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(11);
        st.push(2);
        st.push(32);
        st.push(41);
        sortStack(st);
        System.out.println("Output: " + st);
    }
}
