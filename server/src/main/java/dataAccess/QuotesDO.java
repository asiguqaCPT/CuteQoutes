package dataAccess;

import net.lemnik.eodsql.ResultColumn;
import net.lemnik.eodsql.Update;

public class QuotesDO {
    public QuotesDO(){}

    public int id;
    public String text;
    public String name;

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
//    @ResultColumn( value = "id")
//    public void setName(String name){
//        this.name = name;
//    }
//
    public String getText(){
        return this.text;
    }
//    @ResultColumn( value = "text")
//    public void setText(String text){
//        this.text = text;
//    }
    @Override
    public String toString(){
        return "id: " + this.id + "\ntext: " + this.text + "\nname: "+this.name;
    }
}
