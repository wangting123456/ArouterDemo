package com.example.java.design.moshi_shipeiqi;

/**
 * 步骤3:创建实现了 MediaPlayer 接口的适配器类。
 */
public class MediaAdapter implements MediaPlayer {
    private AdvanceMediaPlayer player;
    public MediaAdapter(String audiotype){
        if("vlc".equals(audiotype)){
            player = new VlcPlayer();
        }else if("mp4".equals(audiotype)){
            player = new Mp4Player();
        }
    }
    @Override
    public void play(String audioType, String filename) {
        if("vlc".equals(audioType)){
            player.playvlc(filename);
        }else if("mp4".equals(audioType)){
            player.playmp4(filename);
        }
    }
}
