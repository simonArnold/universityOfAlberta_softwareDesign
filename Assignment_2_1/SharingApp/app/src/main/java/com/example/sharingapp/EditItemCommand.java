package com.example.sharingapp;

import android.content.Context;

public class EditItemCommand extends Command {

    private ItemList itemList;
    private Item oldItem, newItem;
    private Context context;

    public EditItemCommand(ItemList itemList, Item oldItem, Item newItem, Context context) {
        this.itemList = itemList;
        this.oldItem = oldItem;
        this.newItem = newItem;
        this.context = context;
    }

    @Override
    public void execute() {
        itemList.deleteItem(oldItem);
        itemList.addItem(newItem);
        boolean success = itemList.saveItems(context);
        setIsExecuted(success);
    }
}
