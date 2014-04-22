package adapter;

class VideoPlayer{
	public void playVideo(){
		System.out.println("VideoPlayer.playVideo()");
	}
}
class AudioPlayer{
	public void playAudio(){
		System.out.println("AudioPlayer.playAudio()");
	}
}

interface PlayerAdapter{
	public void play();
}

class VideoPlayerAdapter implements PlayerAdapter{
	public void play(){
		new VideoPlayer().playVideo();
	}
}
class AudioPlayerAdapter implements PlayerAdapter{
	public void play(){
		new AudioPlayer().playAudio();
	}
}
class Client{
	public void play(PlayerAdapter p){
		p.play();
	}
}
public class AdapterTest {


	public static void main(String[] args) {
		VideoPlayerAdapter videoPlayerAdapter = new VideoPlayerAdapter();
		AudioPlayerAdapter audioPlayerAdapter = new AudioPlayerAdapter();
		new Client().play(videoPlayerAdapter);
		new Client().play(audioPlayerAdapter);
	}

}
