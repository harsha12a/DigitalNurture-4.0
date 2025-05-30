class ThreadEg implements Runnable {
    int id;
    ThreadEg(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread " + id + ": iteration - " + (i+1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Threads {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadEg(1));
        Thread thread2 = new Thread(new ThreadEg(2));
        thread1.start();
        thread2.start();
    }
}
