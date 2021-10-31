public class Sentido {
    private Direccion direccion = Direccion.Abajo;

    public Sentido(Direccion direccion) {
        setDireccion(direccion);
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

}
enum Direccion{
    Derecha,Izquierda,Arriba,Abajo
}