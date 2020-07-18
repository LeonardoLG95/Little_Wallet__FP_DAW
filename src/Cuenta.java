import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos = new ArrayList<>();
    private List<Ingreso> ingresos = new ArrayList<>();

    public Cuenta(Usuario usuario){
        this.saldo = 0;
        this.usuario = usuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double addIngresos (String description, double cantidad){
        Ingreso miIngreso = new Ingreso(cantidad, description);
        this.ingresos.add(miIngreso);
        this.saldo += cantidad;
        return saldo;
    }

    public double addGastos (String description, double cantidad){
        if(saldo > cantidad){
            Gasto miGasto = new Gasto(cantidad, description);
            this.gastos.add(miGasto);
            this.saldo -= cantidad;
        }else {
            throw new GastoException();
        }
        return saldo;
    }

    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                " usuario = " + usuario +
                ", saldo = " + saldo + '}';
    }
}
