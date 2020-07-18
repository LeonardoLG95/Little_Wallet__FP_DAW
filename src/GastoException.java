public class GastoException extends RuntimeException{

    public GastoException(){
        super("El saldo es insuficiente para este gasto");
    }
}
