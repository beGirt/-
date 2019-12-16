package org.lsf.model;

public class PageMessage extends Message {
    private int code;

    public static PageMessage fail_1(){
        PageMessage result = new PageMessage();
        result.setCode(200);        /*200 代表页数 < 0*/
        result.setMsg("页数不合理");
        return result;
    }

    public static PageMessage fail_2(){
        PageMessage result = new PageMessage();
        result.setCode(300);        /*300 代表页数 > 总页数*/
        result.setMsg("页数不合理");
        return result;
    }

    public static PageMessage success(){
        PageMessage result = new PageMessage();
        result.setCode(100);
        result.setMsg("页数合理");
        return result;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }
}
