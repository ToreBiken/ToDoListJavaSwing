import java.util.ArrayList;
import java.util.List;

public class Watchlist {
    private List<WatchlistItem> items = new ArrayList<>();

    public void addItem(WatchlistItem item) {
        items.add(item);
    }

    public void removeItem(WatchlistItem item) {
        items.remove(item);
    }

    public void checkItems() {
        for (WatchlistItem item : items) {
            if (item.isInStock()) {
                System.out.println(item.getName() + " kazr dostupenz");
            }

        }
    }
}
