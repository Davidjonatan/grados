package nav;

import androidx.annotation.NonNull;

public class kelvin extends grados{
    public kelvin() {
        this.setUnidad("K");
    }
    public kelvin(Double valor){
        this.setUnidad("k");
        this.setValor(valor);
    }
public kelvin parse(@NonNull celsius celsius){
        return new kelvin( celsius.getValor()-273.15);
}
public kelvin parse(fahrenheit fahrenheit){
            return new kelvin((fahrenheit.getValor() - 273.15) * 9 /5  + 32);
}
}
