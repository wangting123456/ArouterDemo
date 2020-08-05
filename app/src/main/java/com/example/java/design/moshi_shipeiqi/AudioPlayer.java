package com.example.java.design.moshi_shipeiqi;

/**
 * 步骤4：创建实现了 MediaPlayer 接口的实体类
 */
public class AudioPlayer implements MediaPlayer{
    private MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String filename) {
        if(audioType.equals("vlc") || audioType.equals("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,filename);
        } else{
            System.out.println("Invalid media. "+
                    audioType + " format not supported");
        }
    }
}
