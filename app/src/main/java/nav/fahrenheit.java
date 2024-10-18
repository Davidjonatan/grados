    package nav;

    public class fahrenheit extends grados{
    public fahrenheit(){
        this.setUnidad("f");
    }
    public fahrenheit(double valor){
        this.setUnidad("f");
        this.setValor(valor);
    }
    public fahrenheit parse(kelvin kelvin){
        return new fahrenheit((kelvin.getValor() - 32) * 5/9 + 273.15);
    }
    public fahrenheit parse(celsius celsius){
        return new fahrenheit((celsius.getValor() - 32)* 5 / 9 );
    }
    }
