import java.util.Arrays;

public class ArrayStack extends StaticStack {
    private float growthRate;

    public void push(int elements) {
        if(top >= getCapacity() - 1) {
            int newCapacity = (int)(getCapacity() * (growthRate + 1));
            newCapacity = Math.max(getCapacity() + 1, newCapacity);
            var newArray = Arrays.copyOf(this.elements, newCapacity);
            this.elements = newArray;
        }

        top = top + 1;
        this.elements[top] = elements;
    }

    public ArrayStack(int capacity, float growthRate) {
        super(capacity);
        this.growthRate = growthRate;
    }

    public int lastPosition() {
        if(top >= 0) {
            return elements[top];
        }
        return 0;
    }

    public String toString() {
        String border = "[";
        if(getSize() > 0) {
            border += this.elements[0];
        }
        for (int i = 1; i < getSize(); i++) {
            border += ", " + this.elements[i];
        }
        border += "]";
        return border;
    }
}
