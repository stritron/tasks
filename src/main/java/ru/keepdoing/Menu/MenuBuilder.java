package ru.keepdoing.Menu;

import ru.keepdoing.TasksExceptions.WrongMenuItemException;
import java.util.HashMap;

public class MenuBuilder {

    private HashMap<Integer, AbstractMenuItem> items = new HashMap<>();

    private final String menuName;

    public MenuBuilder(String menuName) {
        this.menuName = menuName;
    }

    public void run(int menuItem) throws WrongMenuItemException {
        if (!items.containsKey(menuItem)) throw new WrongMenuItemException();
        items.get(menuItem).run();
    }

    public void add(int itemNumber, AbstractMenuItem item) {
        items.put(itemNumber, item);
    }

    public String getText() {
        StringBuilder sb = new StringBuilder(this.menuName);
        sb.append('\n');
        for (Integer i : items.keySet()) {
            sb
                    .append('\t')
                    .append(i)
                    .append(":\t")
                    .append(items.get(i).getName())
                    .append('\n');
        }
        return sb.toString();
    }

}