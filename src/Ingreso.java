public class Ingreso extends Dinero{

    public Ingreso(double gasto, String description){
        super.setDinero(gasto);
        super.setDescription(description);
    }

    //Hereda de dinero, el toString nos sirve para mostrar el gasto por pantalla
    @Override
    public String toString() {
        return "Ingreso: " + super.getDescription() + ", cantidad: " + super.getDinero() + "€";
    }
}
