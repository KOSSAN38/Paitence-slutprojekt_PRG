public class counter {
    private long startTime;

    public counter() {
        this.startTime = System.currentTimeMillis();
    }

    public long time(){
       return System.currentTimeMillis()-startTime;

    }


}
