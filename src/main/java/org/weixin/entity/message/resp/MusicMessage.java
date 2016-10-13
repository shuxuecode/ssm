package org.weixin.entity.message.resp;

/** 
 * 音乐消息 
 *  
 * @author liufeng 
 * @date 2013-05-19 
 */  
public class MusicMessage extends BaseMessage {  
    // 音乐  
    private Music Music;  
    // 缩略图的媒体id，通过上传多媒体文件，得到的id
    private String ThumbMediaId;
  
    public Music getMusic() {  
        return Music;  
    }  
  
    public void setMusic(Music music) {  
        Music = music;  
    }

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}  
    
    
} 