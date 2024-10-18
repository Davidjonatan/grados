package nav;

public class celsius extends grados {
    public celsius(){
        this.setUnidad("C");
    }
    public celsius(Double valor){
        this.setUnidad("C");
        this.setValor(valor);
    }
     public celsius parse(kelvin kelvin){
         return new celsius( kelvin.getValor()+273.15);
     }
    public celsius parse(fahrenheit fahrenheit){
        return new celsius((fahrenheit.getValor() *9/5)+32);
    }
}
