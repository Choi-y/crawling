package Covid;

public class CovidVO {
    private String gu;
    private String num;

    public CovidVO(String gu, String num) {
        this.gu = gu;
        this.num = num;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
