package ino.web.freeBoard.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("archiveDto")
public class ArchiveDto {

    private int num;
    private String title;
    private String name;
    private String regdate;
    private String content;
    private int readcnt;
    private String fileLoad;

    private MultipartFile uploadFile;

    public MultipartFile getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(MultipartFile uploadFile) {
        this.uploadFile = uploadFile;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReadcnt() {
        return readcnt;
    }

    public void setReadcnt(int readcnt) {
        this.readcnt = readcnt;
    }

    public String getFileLoad() {
        return fileLoad;
    }

    public void setFileLoad(String fileLoad) {
        this.fileLoad = fileLoad;
    }

    @Override
    public String toString() {
        return "ArchiveDto [num=" + num + ", title=" + title + ", name=" + name + ", regdate=" + regdate + ", content="
                + content + ", readcnt=" + readcnt + ", fileLoad=" + fileLoad + ", uploadFile=" + uploadFile
                + ", getUploadFile()=" + getUploadFile() + ", getNum()=" + getNum() + ", getTitle()=" + getTitle()
                + ", getName()=" + getName() + ", getRegdate()=" + getRegdate() + ", getContent()=" + getContent()
                + ", getReadcnt()=" + getReadcnt() + ", getFileLoad()=" + getFileLoad() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
}
