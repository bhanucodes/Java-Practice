class DateClass {
    private int date;
    private int month;
    private int year;

    // getter
    int  getDate(){
        return this.date;
    }
    int getMonth(){
        return this.month;
    }
    int getYear(){
        return this.year;
    }

    //setter
    void setDate(int date){
        this.date = date;
    }
    void setMonth(int month){
        this.month = month;
    }
    void setYear(int year){
        this.year = year;
    }

    DateClass(int date, int month, int year){
        this.date = date;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return "DateClass{ date ="+ this.date+", month ="+this.month+", year="+this.year+"}";
    }
}

public class Q4 {

    public static void main(String[] args) {
        
    }
}