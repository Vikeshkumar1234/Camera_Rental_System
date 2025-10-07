package Camera_HomePage;

public class Camera_Details {
    private int Camera_Id;
    private String Brand;
    private String Model;
    private float Price;
    private String status;

    public Camera_Details(int camera_Id) {
        Camera_Id = camera_Id;
    }

    public Camera_Details(int camera_Id, String brand, String model, float price, String status) {
        Camera_Id = camera_Id;
        Brand = brand;
        Model = model;
        Price = price;
        this.status = status;
    }

    public int getCamera_Id() {
        return Camera_Id;
    }

    public void setCamera_Id(int camera_Id) {
        Camera_Id = camera_Id;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
