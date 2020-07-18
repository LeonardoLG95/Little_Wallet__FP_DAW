public class Usuario {
    private String nombre;
    private int edad;
    private String DNI;

    public Usuario(){
        this.nombre = "Predeterminado";
        this.edad = 0;
        this.DNI = "00000000A";
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDNI() {
        return DNI;
    }

    public boolean setNombre(String nombre) {
        char[] chars = nombre.toCharArray();
        boolean incorrecto = false;
        // Compruebo que el nombre no tenga numeros
        // ya que no suele ser habitual que alguien tenga numeros en su nombre.
        for(char c : chars){
            if(Character.isDigit(c)){
                incorrecto = true;
                break;
            }
        }
        // Compruebo que el nombre no sea mayor de 10 letras ya que no es frecuente.
        if(chars.length > 10){
            incorrecto = true;
        }else{
            this.nombre = nombre;
        }
        return incorrecto;
    }

    public boolean setEdad(int edad) {
        boolean incorrecto = false;
        // Como dije en otro comentario, comprobar si el numero era un String
        // daba bastantes errores a si que lo hago en el main, lo que si compruebo
        // es que la edad sea entre 0 y 200 ya que nadie a vivido 200 años, que se sepa.
        if(edad >= 0 && edad <=200){
            this.edad = edad;
        }else{
            incorrecto = true;
        }
        return incorrecto;
    }

    public boolean setDNI(String DNI) {
        char[] chars = DNI.toCharArray();
        boolean incorrecto = false;

        // Compruebo si la longitud es adecuada
        if(chars.length < 9 || chars.length > 10){
            incorrecto = true;
        }
        // Si lo es, compruebo los caracteres para que sean los que me interesan
        if(!incorrecto) {
            for (int i = 0; i < chars.length; i++) {
                if (i < 8 && !Character.isDigit(chars[i])) {
                    incorrecto = true;
                }
                if (i == 8 && chars.length == 10 && chars[i] != '-'){
                    incorrecto = true;
                }

                if (i == 8 && chars.length == 9 && !Character.isAlphabetic(chars[i])){
                    incorrecto = true;
                }

                if(i == 9 && !Character.isAlphabetic(chars[i])){
                    incorrecto = true;
                }
            }
        }

        if(!incorrecto){
            this.DNI = DNI;
        }
        return incorrecto;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre + ", edad: " + edad + ", DNI: " + DNI;
    }
}
