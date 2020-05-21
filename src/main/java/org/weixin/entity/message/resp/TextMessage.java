package org.weixin.entity.message.resp;

import javax.xml.bind.annotation.XmlRootElement;

/** 
 * 文本消息 
 *  
 * @author liufeng 
 * @date 2013-05-19 
 */  
@XmlRootElement
public class TextMessage extends BaseMessage {  
    // 回复的消息内容  
    private String Content;  
  
    public String getContent() {  
        return Content;  
    }  
  
    public void setContent(String content) {  
        Content = content;  
    }  
}