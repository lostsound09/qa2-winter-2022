public class Meal {
    private int calories;
    private int protein;
    private int fat;
    private int carbs;
    private boolean allergenFree;

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public boolean isAllergenFree() {
        return allergenFree;
    }

    public void setAllergenFree(boolean allergenFree) {
        this.allergenFree = allergenFree;
    }
}
