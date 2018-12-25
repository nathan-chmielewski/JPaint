package model.interfaces;

public interface IDrawSubject {
    void registerObserver(IDrawObserver o);
    void removeObserver(IDrawObserver o);
    void notifyObservers();
}
