package Views;

public class MainView {

    public void mainMenuView(){

    }

    public static void exitView(){
        System.out.println("Czy na pewno chcesz wyjść?");
        System.out.println("Yes");
        System.out.println("No");
        try{System.in.read();}
        catch(Exception e){}
    }
}
