public class Catalog {

    private String name;
    private String title;
    private String price;
    private int id;

    public Catalog(){ }

    public Catalog(String name, String title, String price, int id){
        this.name = name;
        this.title = title;
        this.price = price;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    //@Override
    //public String toString() {
        //return "[name=" + name +", title=" + title + ",price=" + price + "]";
    //}
    public String toString(){
        StringBuffer sb = new StringBuffer();

        sb.append("Name:"+ getName());
        sb.append(", ");
        sb.append("Title:" + getTitle());
        sb.append(", ");
        sb.append("Price:"+getPrice());
        return sb.toString();
    }
}
