import java.util.*;
class Car{
    private String manufacturer,marka;
    private String gos_number;
    Car(String manufacturer,String marka,String gos_number){
        this.manufacturer = manufacturer;
        this.marka = marka;
        this.gos_number = gos_number;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getGos_number() {
        return gos_number;
    }

    public void setGos_number(String gos_number) {
        this.gos_number = gos_number;
    }

    @Override
    public String toString() {
        return  '\n' + "Машины в автопарке:" + '\n' +
                "Производитель " + manufacturer + '\n' +
                "Марка " + marka + '\n' +
                "Гос.Номер " + gos_number + '\n';
    }
    public static Comparator<Car> ManComparator = new Comparator<Car>(){
        public int compare(Car c1,Car c2){

            return c1.getManufacturer().compareToIgnoreCase(c2.getManufacturer());
        }
    };
    public static Comparator<Car> MarkComparator = new Comparator<Car>() {
        public int compare(Car c1, Car c2) {
            return c1.getMarka().compareToIgnoreCase(c2.getMarka());
        }
    };
}

