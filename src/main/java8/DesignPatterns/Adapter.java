package DesignPatterns;




// MusicPlayer (new), LegacyPlayer(old)

interface MediaPlayer{
    public void playSong(String songName);
}

class LegacyPlayer{
    public void play(String songName){
        System.out.println(songName+" legacy music will be played ");
    }
}

class MediaAdapter implements MediaPlayer{
    LegacyPlayer legacyPlayer;

    public MediaAdapter(LegacyPlayer legacyPlayer){
        this.legacyPlayer = legacyPlayer;
    }

    public void playSong(String songName){
        legacyPlayer.play(songName);
    }
}

public class Adapter {
    public static void main(String[] args){

        LegacyPlayer legacyPlayer = new LegacyPlayer();
        MediaPlayer mediaPlayer = new MediaAdapter(legacyPlayer);

        mediaPlayer.playSong("Alpha.mp3");

    }
}
