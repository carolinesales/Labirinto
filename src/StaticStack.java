public class StaticStack {
    protected int top;
    protected int[] elements;

    public StaticStack(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        top = -1;
        elements = new int[capacity];
    }

    public int pop() {
        if(isEmpty()) {
            throw new IllegalStateException("The stack is empty.");
        }
        int component = elements[top];
        elements[top] = 0;
        top = top - 1;
        return component;
    }

    public int getSize() {
        return top + 1;
    }

    public int getCapacity() {
        return elements.length;
    }

    public boolean isEmpty() {
        return top < 0;
    }
}

