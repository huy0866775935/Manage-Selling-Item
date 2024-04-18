
package Model;

/**
 *
 * @author Admin
 */
public class Category {
    private int category_id;
    private String category_name;
    private String descr;

    public Category() {
    }

    public Category(int category_id, String category_name, String descr) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.descr = descr;
    }
    
        public Category(int category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public Category(String category_name, String descr) {
        this.category_name = category_name;
        this.descr = descr;
    }
        
        

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "Category{" + "\ncategory_id=" + category_id + "\n category_name=" + category_name + "\n descr=" + descr + '}';
    }

   
    
    
}
