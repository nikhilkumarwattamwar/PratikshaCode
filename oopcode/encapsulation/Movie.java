package encapsulation;

import org.w3c.dom.ls.LSOutput;

public class Movie {
   private String title;
   private String director;
   private int duration;

   public Movie(String title,String director,int duration){
       this.title=title;
       this.director=director;
       this.duration=duration;
   }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setDirector(String director){
       this.director=director;
    }
    public String getDirector(){
       return director;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    void printDetails(){
        System.out.println("Movie title is:"+title);
        System.out.println("Movie director is:"+director);
        System.out.println("Movie duration is:"+duration);
    }
}

class Zed {
    public static void main(String[] args) {
    Movie obj=new Movie("abc","xyz",120);
        obj.printDetails();
        obj.setDuration(240);
        obj.printDetails();

}}