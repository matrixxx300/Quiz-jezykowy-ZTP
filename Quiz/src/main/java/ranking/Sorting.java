package ranking;

//TODO: Przenieść do modeli, w celu spełnienia wzorca MVC.
public interface Sorting {
    //TODO: Czy na pewno 'public' jest tutaj potrzebne? Kompilator sugeruje, że nie.
    public void sort(Ranking ranking);
}
