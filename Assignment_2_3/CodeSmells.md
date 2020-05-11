# Code smell 1: Duplicated code
The code in ContactList.saveContacts/loadContacts and ItemList.saveItems/loadItems is duplicated and can be refactored into a separate class. This class could be called for example DataPersistence and would provide the save/load methods to be used by both the ContactList and the ItemList.
Also, this improves the separation of responsibilities and algorithms for saving/loading can be changed easily.
## Rough Diagram of the change
![uml](./DataPersistence.png)

# Code smell 2: Large Class
It is not necessarily the responsibility of the Item class to know how to convert an image to base 64 or deconvert to bitmap.
There may be different algorithms on how to convert a bitmap into base64.