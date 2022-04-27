# **Recyclerview_Search**
## Search on Recyclerivew with EditText in Android
---
in the first step inside the adapter class,create a new list of models **as follows:**
```java
List<ModelName> filteritem;
```
**Notice :** here, for example, we (filteritem) the name of the object 
in the second step,you must new an ArrayList for the object created from List **as follows:**
```java
filteritem = new ArrayList<>();
filteritem = item
```
**Notice :** (item) is the intial List made of the Model

in the next step outside the viewholder we add a new class called setFilter containing the following code to the project :
```java
 public void setFilter (String namefilter){
        namefilter =namefilter.toLowerCase();
        if (namefilter.isEmpty()){
            filteritem = new ArrayList<>();
            filteritem = item;
        }
        else {
            filteritem = new ArrayList<>();
            for (int i = 0 ; i < item.size() ; i++)
            {
                if (item.get(i).getName().toLowerCase().contains(namefilter)){
                    filteritem.add(item.get(i));
                }
            }
        }
        notifyDataSetChanged();
    }
```
in the next step, we will replace the new list (filteritem) with the previous list (item) in onBindViewHolder and getItemCount
```java
Model model = filteritem.get(position)
```
then go to the MainActivity and create an EditText object, then findviewbyid it:
```java
EditText search;
search = findviewById (R.id.txtsearch);
return filteritem.size();
```
finally, add the TextChangeListener method to it and put the following code in the on TextChanged section :
```java
search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.setFilter(charSequence.toString().toLowerCase());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
```
---
### an example of the end of this code :


![alt - Github](https://raw.githubusercontent.com/lucanicoletti/HiddenSearchWithRecyclerView/master/default_example.gif)
