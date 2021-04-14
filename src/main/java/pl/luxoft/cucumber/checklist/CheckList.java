package pl.luxoft.cucumber.checklist;

import pl.luxoft.cucumber.checkitem.CheckItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckList {
    
    private String name;
    private List<CheckItem> items;


    public CheckList(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }


    public void add(CheckItem checkItem) {
        items.add(checkItem);
    }

    public int size() {
        return items.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void delete(String checkItemTitle) {
        CheckItem targetItem = items.stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(checkItemTitle))
                .findAny().get();
        items.remove(targetItem);
    }

    public void printAllItems() {
        items.forEach(el -> System.out.println("Item: " + el.getTitle()));
    }
}
