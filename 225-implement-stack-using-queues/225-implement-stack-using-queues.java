class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        while (q1.size() != 1) q2.offer(q1.poll());
        var tmp = q1; q1 = q2; q2 = tmp; //swapping queues
        return q2.poll();
    }

    public int top() {
        var val = pop();
        push(val);
        return val;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */