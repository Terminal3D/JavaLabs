import java.util.Iterator;

public class MutableSubstringIterator implements Iterable<Integer> {
    private StringBuilder S;
    private String Substring;

    public MutableSubstringIterator(StringBuilder S, String substring) {
        this.S = S;
        this.Substring = substring;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SuffixIterator(-1);
    }

    private class SuffixIterator implements Iterator<Integer> {
        private int index = 0;

        private SuffixIterator(int index) {
            this.index = index;
        }
        @Override
        public boolean hasNext() {
            return (S.indexOf(Substring, index + 1) != -1);
        }

        @Override
        public Integer next() {
            index = getNextIndex();
            return index;
        }

        private int getNextIndex() {
            return S.indexOf(Substring, index + 1);
        }
    }

    public void StringAppend(String s) {
        this.S.append(s);
    }

    public void StringInsert(String s, int pos) {
        this.S.insert(pos, s);
    }

    public void StringDelete(int start, int end) {
        this.S.delete(start, end);
    }

    public void StringReplace(int start, int end, String s) {
        this.S.replace(start, end, s);
    }

    public String StringSubstring(int start, int end) {
        return S.substring(start, end);
    }

    public StringBuilder getString() {
        return S;
    }

}

