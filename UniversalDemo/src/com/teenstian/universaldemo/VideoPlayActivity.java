package com.teenstian.universaldemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;


public class VideoPlayActivity extends Activity{
	
	private TextView videoTitle;
	private VideoView video;
	private Uri uri;
	private MediaController mediaController; 
	private String strTitle;
	private String strUri;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_play);
		
		videoTitle = (TextView)findViewById(R.id.video_play_title);
		video = (VideoView)findViewById(R.id.video_play);
		
		Intent intent = getIntent();
		strTitle = intent.getStringExtra("play_title");
		strUri = intent.getStringExtra("play_url");
		videoTitle.setText(strTitle);
		
        mediaController = new MediaController(this);
        
//        String strVideoFile = FileUtil.getSDCardFile("Video", "video_demo_mx3.flv");
//        File videoFile = new File(strVideoFile);
//        String uriString = "http://v.youku.com/v_show/id_XNjkzNTQ4MjE2.html";
          uri = Uri.parse(strUri);
        
//        if (videoFile.exists()) {  
        	//本地
//        	video.setVideoPath(videoFile.getAbsolutePath());  
//          System.out.println("videoFile.getAbsolutePath()----> " + videoFile.getAbsolutePath()); 
          	//资源文件
//        	video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator +R.raw.mx3)); 
        	//网络
          	video.setVideoURI(uri);
        	
            // 设置VideView与MediaController建立关联  
        	video.setMediaController(mediaController);  
            // 设置MediaController与VideView建立关联  
            mediaController.setMediaPlayer(video);  
            // 让VideoView获取焦点  
            video.requestFocus();  
            // 从第几毫秒开始播放
            video.seekTo(10); 
            // 开始/暂停 播放  
            video.pause(); 
//        } 
//        else {  
//            Toast.makeText(this, "文件不存在", Toast.LENGTH_LONG).show();  
//        }  
        
	}
	

}
