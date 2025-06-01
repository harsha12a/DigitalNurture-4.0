interface Playable {
    void play();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("Guitar is playing: Strumming chords.");
    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("Piano is playing: Playing notes.");
    }
}

class Interface {
    public static void main(String[] args) {
        Guitar guitar = new Guitar();
        Piano piano = new Piano();
        guitar.play();
        piano.play();
    }
}
