package cs.map;

public class Map {
    private int index;
    private String[] keys;
    private String[] values;

    public Map() {
        this.index = -1;
        this.keys = new String[100];
        this.values = new String[100];
    }

    public void put(String key, String value) {
        this.index++;
        keys[this.index] = key;
        values[this.index] = value;

        if (getIndex(key) > -1) {
            keys[getIndex(key)] = key;
            values[getIndex(key)] = value;
        }
    }

    public String get(String key) {
        String value = values[getIndex(key)];
        return value;
    }

    private int getIndex(String key) {
        for (int i = 0; i <= this.index; i++) {
            if (this.keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return this.index + 1;
    }

    public void remove(String key) {
        int index = getIndex(key);
        this.keys[index] = null;
        this.values[index] = null;
    }


    public boolean containKey(String key) {
        for (int i = 0; i <= this.index; i++) {
            if (this.keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(String value) {
        for (int i = 0; i <= this.index; i++) {
            if (this.values[i].equals(value)) {
                return true;
            }
        }
        return false;
    }


    public void clear() {
        for (int i = this.index; i >= 0; i--) {
            keys[i] = null;
            values[i] = null;
        }
        this.index = -1;
    }
}
