package org.weixin.entity.message.resp;

/**
 * 回复语音消息
 * @author zsx
 *
 */
public class VoiceMessage extends BaseMessage{

	//通过上传多媒体文件，得到的id
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
	
}
