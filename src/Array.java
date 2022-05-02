public class Array {

    private int[] size;

    Array(int size) {
        this.size = new int[size];
    }

    public static Array create(int... size) {
        Array array = new Array(size.length);
        for (int i = 0; i < size.length; i++) {
            array.set(i, size[i]);
        }
        return array;
    }

    public void set(int position, int value) {
        this.size[position] = value;
    }

    public int size() {
        return this.size.length;
    }

    public int indexOf(int value) {
        for (int i = 0; i < size(); i++) {
            if(size[i] == value) return i;
        }
        return -1;
    }

    public String toString() {
        String border = "[";
        if(size() > 0) {
            border += this.size[0];
        }
        for (int i = 1; i < size(); i++) {
            border += ", " + this.size[i];
        }
        border += "]";
        return border;
    }
}
