package sistemaAutogestion;
public interface ICola {
    public boolean esVacia();
    public boolean esLLena();
    public void encolar(int dato);
    public void Desencolar();
    public nodo frente();
    public nodo fondo();   
}
