package pack_vehicle;

public class Helm {
    private String material;
    private float weight;
    private String form;

    Helm () {
        material = "leather";
        weight = 0.5F;
        form = "circle";
    }

    Helm (String material, float weight, String form) {
        this.material = material;
        this.weight = weight;
        this.form = form;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return "Helm {" + " material = " + material + " | weight = " + weight + " | form = " + form + "}";
    }
}
