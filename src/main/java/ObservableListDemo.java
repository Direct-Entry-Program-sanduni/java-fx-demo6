import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ObservableListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        ObservableList<Integer> olnNmbers  = FXCollections.observableArrayList();

        olnNmbers.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> change) {
                System.out.println("subscriber 1"+change);
            }
        });
        olnNmbers.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> change) {
                System.out.println("subscriber 2");
            }
        });
        olnNmbers.add(10);
        olnNmbers.add(10);
        olnNmbers.add(10);
        olnNmbers.add(10);
    }
}
