package Covid;

import java.util.ArrayList;

public class CovidApplication {
    public static void main(String[] args) {
        ArrayList<CovidVO> CV = new ArrayList<CovidVO>();

        CovidDAO.CoronaDAO(CV);
        DbDAO.UploadToDB(CV);
    }
}
