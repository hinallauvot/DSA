class SeatManager {
    TreeSet<Integer> ts;
    int count = 1;
    public SeatManager(int n) {
        ts = new TreeSet<>();
    }
    
    public int reserve() {
        if(ts.isEmpty())
            return count++;
        else
            return ts.pollFirst();
    }
    
    public void unreserve(int seatNumber) {
        ts.add(seatNumber);
    }
}