package DataBase;
import Main.GUI;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.jsoup.Jsoup;
import org.json.simple.*;

public class Auto implements Runnable{
    Thread thread;
    GUI gui;
    int row_count;
    public Auto(GUI gui){
        this.gui = gui;
    }
    
    @Override
    public void run() {
        for(int i=0; i < gui.getLstTitles().getModel().getRowCount(); i++){
            String title = (String) gui.getLstTitles().getModel().getValueAt(i, 0);
            ResultSet rs;
            Statement st = null;
            DBHelper help = new DBHelper();
            Connection c;
            try{
                c = help.getConnection();
                st = c.createStatement();
                rs = st.executeQuery("select * from Database.Series where Title = \"" +  title + "\"");
                rs.next();
                int ID = rs.getInt("ID");
                String json = Jsoup.connect("https://api.tmdb.org/3/tv/" + String.valueOf(ID) + "?api_key=4169c18556ebe6ana480a5d10e861831").ignoreContentType(true).execute().body();
                JSONObject jo = (JSONObject) JSONValue.parse(json);
                st.executeUpdate("update Database.Series set Progressivity = " + String.valueOf(jo.get("in_production")) + ", Episodes = " + String.valueOf(jo.get("number_of_episodes")) + ", Seasons = " + String.valueOf(jo.get("number_of_seasons")) + " where ID = " + String.valueOf(ID));
                c.close();
                st.close();
                rs.close();
            }catch(Exception e){System.out.println(e.getClass() + "\n" + e.getLocalizedMessage());}
        }
        gui.renewList();
        gui.getLstTitles().getColumnModel().getColumn(0).setHeaderValue("Title: (Up to Date)");
    }
    public void start(){
        if(thread == null){
            thread = new Thread(this, "Auto");
        }
        thread.start();
    }
}
