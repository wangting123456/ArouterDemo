package com.example.java.list.compare.bean;
import androidx.databinding.BaseObservable;

/**
 * @author cwj
 * @date 2019/9/22
 * <p>
 * "cretime": "截图时间",
 * "name": "被截图的单位",
 * "picfile": "图片路径"
 * "dutyfk": "截图外键"
 * "isread": "是否已读 P:是 N:否"
 * sendname  发送的单位
 */
public class ScreenSendUpBean extends BaseObservable {
    private final String READ = "Y";
    private String cretime;
    private String name;
    private String picfile;
    private String dutyfk;
    private String isread;
    private String sendname;
    private boolean read;

    public ScreenSendUpBean(String name, String cretime){
        this.name = name;
        this.cretime = cretime;
    }

    public String getREAD() {
        return READ;
    }

    public String getCretime() {
        return cretime;
    }

    public void setCretime(String cretime) {
        this.cretime = cretime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicfile() {
        return picfile;
    }

    public void setPicfile(String picfile) {
        this.picfile = picfile;
    }

    public String getDutyfk() {
        return dutyfk;
    }

    public void setDutyfk(String dutyfk) {
        this.dutyfk = dutyfk;
    }

    public String getIsread() {
        return isread;
    }

    public void setIsread(String isread) {
        this.isread = isread;
    }

    public String getSendname() {
        return sendname;
    }

    public void setSendname(String sendname) {
        this.sendname = sendname;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
