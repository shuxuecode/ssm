package org.weixin.entity.message.resp;
/**
 * 回复视频消息
 * @author zsx
 *
 */
public class VideoMessage extends BaseMessage{

	//视频消息的标题
	private String Title;
	//视频消息的描述
	private String Description;
	//通过上传多媒体文件，得到的id
	private String MediaId;
	
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
	
	
}
