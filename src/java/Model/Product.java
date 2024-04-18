
package Model;

import java.sql.Date;


public class Product {
    private String product_id;
    private String product_name;
    private int quantify;
    private String unit;
    private String status;
    private String supplier_id;
    private String describe;
    private String photo;
    private float price;
    private Date create_at;
    private Date updated_at;
    private int category_id;
    Category  cate;

    public Product() {
    }

    public Product(String product_id, String product_name) {
        this.product_id = product_id;
        this.product_name = product_name;
    }

    
    public Product(String product_id, String product_name, int quantify, String unit, String status, String supplier_id, String describe, String photo, float price, Date create_at, Date updated_at, int category_id, Category cate) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantify = quantify;
        this.unit = unit;
        this.status = status;
        this.supplier_id = supplier_id;
        this.describe = describe;
        this.photo = photo;
        this.price = price;
        this.create_at = create_at;
        this.updated_at = updated_at;
        this.category_id = category_id;
        this.cate = cate;
    }

    public Product(String product_name, String photo, float price) {
        this.product_name = product_name;
        this.photo = photo;
        this.price = price;
    }
    
    

    public Product(String product_id, String product_name, int quantify, String unit, String status, String supplier_id, String describe, String photo, float price, Date updated_at, int category_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantify = quantify;
        this.unit = unit;
        this.status = status;
        this.supplier_id = supplier_id;
        this.describe = describe;
        this.photo = photo;
        this.price = price;
        this.updated_at = updated_at;
        this.category_id = category_id;
    }
    
    

    public Product(String product_id, String product_name, int quantify, String unit, String status, String supplier_id, String describe, String photo, float price, int category_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantify = quantify;
        this.unit = unit;
        this.status = status;
        this.supplier_id = supplier_id;
        this.describe = describe;
        this.photo = photo;
        this.price = price;
        this.category_id = category_id;
    }

    public Product(String product_id, String product_name, int quantify, String unit, String status, String supplier_id, String describe, String photo, float price, Date create_at, Date updated_at) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantify = quantify;
        this.unit = unit;
        this.status = status;
        this.supplier_id = supplier_id;
        this.describe = describe;
        this.photo = photo;
        this.price = price;
        this.create_at = create_at;
        this.updated_at = updated_at;
    }

    
    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }
    
    

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getQuantify() {
        return quantify;
    }

    public void setQuantify(int quantify) {
        this.quantify = quantify;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        if (this.status.equals("stocking")) {
            return status;
        }
        if (this.status.equals("out of stock")) {
            return status;
        }
        return null;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Product{" + "\n product_id=" + product_id + "\n product_name=" + product_name + "\n quantify=" + quantify + "\n unit=" + unit + "\n status=" + status + "\n supplier_id=" + supplier_id + "\n describe=" + describe + "\n photo=" + photo + "\n price=" + price + "\n create_at=" + create_at + "\n updated_at=" + updated_at + "\n category_id=" + category_id + '}';
    }
    
    
}
