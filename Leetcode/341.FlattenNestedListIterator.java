public class NestedIterator implements Iterator<Integer> {
    List<Integer> flattendList;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        flattendList = flattenList(nestedList);
    }

    private List<Integer> flattenList(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        for(NestedInteger nestedInteger : nestedList)
            if(nestedInteger.isInteger()) list.add(nestedInteger.getInteger());
            else list.addAll(flattenList(nestedInteger.getList()));
        return list;
    }

    private boolean isValidIndex() {
        return index < flattendList.size();
    }

    @Override
    public Integer next() {
        return isValidIndex() ? flattendList.get(index++) : -1;
    }

    @Override
    public boolean hasNext() {
        return isValidIndex();
    }
}