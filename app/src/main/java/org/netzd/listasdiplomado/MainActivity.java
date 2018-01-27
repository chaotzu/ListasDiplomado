package org.netzd.listasdiplomado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView contactsListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactsListView=(ListView) findViewById(R.id.contactsListView);
        ContactAdapter contactsAdapter = new ContactAdapter(
                getBaseContext(),
                getContacts());
        contactsListView.setAdapter(contactsAdapter);

        contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    //Simular crga de informacion
    public List<Contact> getContacts(){
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1, "Pepe", "abc"));
        contacts.add(new Contact(2, "Pepa", "def"));
        contacts.add(new Contact(3, "Pepi", "ghi"));
        contacts.add(new Contact(4, "Pepo", "jkl"));
        contacts.add(new Contact(5, "Pepu", "mno"));
        return  contacts;
    }

}


/*@Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    contactsListView=(ListView) findViewById(R.id.contactsListView);
    ContactAdapter contactsAdapter = new ContactAdapter(
        getBaseContext(),
        getContacts());
    contactsListView.setAdapter(contactsAdapter);

    contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

      }
    });
  }

  public List<Contact> getContacts(){
    List<Contact> contacts = new ArrayList<>();
    contacts.add(new Contact(1,"Juan Solis 1","Benemerito"));
    contacts.add(new Contact(2,"Juan Solis 2","Benemerito"));
    contacts.add(new Contact(3,"Juan Solis 3","Benemerito"));
    contacts.add(new Contact(4,"Juan Solis 4","Benemerito"));
    contacts.add(new Contact(5,"Juan Solis 5","Benemerito"));
    contacts.add(new Contact(6,"Juan Solis 6","Benemerito"));
    contacts.add(new Contact(7,"Juan Solis 7","Benemerito"));
    contacts.add(new Contact(8,"Juan Solis 8","Benemerito"));
    contacts.add(new Contact(9,"Juan Solis 9","Benemerito"));
    contacts.add(new Contact(10,"Juan Solis 10","Benemerito"));
    contacts.add(new Contact(11,"Juan Solis 11","Benemerito"));
    contacts.add(new Contact(12,"Juan Solis 12","Benemerito"));
    return contacts;
  }
}

*/



/*all el codigo
//View item_contact
-

//Model

package com.cybertech.listasdiplomado;


public class Contact {

    private int id=0;
    private String name=null;
    private String school=null;
    private String address=null;
    private int age=0;

    public Contact() {
    }

    public Contact(int id, String name, String school) {
        this.id = id;
        this.name = name;
        this.school = school;
    }

    public Contact(int id, String name, String school, String address, int age) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.address = address;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (!name.equals(contact.name)) return false;
        if (school != null ? !school.equals(contact.school) : contact.school != null)
            return false;
        if (address != null ? !address.equals(contact.address) : contact.address != null)
            return false;
        return age != contact.age;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}


//Adapter

package com.cybertech.listasdiplomado;

        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.List;


public class ContactAdapter extends ArrayAdapter<Contact> {

    private Context context=null;
    private List<Contact> contacts=null;

    public ContactAdapter(@NonNull Context context,
                          @NonNull List<Contact> objects) {
        super(context, R.layout.item_contact, objects);
        this.contacts=objects;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item=convertView;
        ContactViewHolder contactViewHolder;
        if(item==null){
            LayoutInflater inflater=(LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item=inflater.inflate(R.layout.item_contact,null);
            contactViewHolder= new ContactViewHolder();
            contactViewHolder.contactImageView=(ImageView) item
                    .findViewById(R.id.contactImageView);
            contactViewHolder.nameTextView=(TextView) item
                    .findViewById(R.id.nameTextView);
            contactViewHolder.schoolTextView=(TextView) item
                    .findViewById(R.id.schoolTextView);
            item.setTag(contactViewHolder);
        }else{
            contactViewHolder=(ContactViewHolder) item.getTag();
        }

        contactViewHolder.contactImageView.setImageResource(R.mipmap.ic_launcher);
        contactViewHolder.nameTextView.setText(contacts.get(position).getName());
        contactViewHolder.schoolTextView.setText(contacts.get(position).getSchool());
        return item;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    static class ContactViewHolder{
        ImageView contactImageView;
        TextView nameTextView;
        TextView schoolTextView;
    }
}

//Activity

package com.cybertech.listasdiplomado;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView contactsListView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactsListView=(ListView) findViewById(R.id.contactsListView);
        ContactAdapter contactsAdapter = new ContactAdapter(
                getBaseContext(),
                getContacts());
        contactsListView.setAdapter(contactsAdapter);

        contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    public List<Contact> getContacts(){
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1,"Juan Solis 1","Benemerito"));
        contacts.add(new Contact(2,"Juan Solis 2","Benemerito"));
        contacts.add(new Contact(3,"Juan Solis 3","Benemerito"));
        contacts.add(new Contact(4,"Juan Solis 4","Benemerito"));
        contacts.add(new Contact(5,"Juan Solis 5","Benemerito"));
        contacts.add(new Contact(6,"Juan Solis 6","Benemerito"));
        contacts.add(new Contact(7,"Juan Solis 7","Benemerito"));
        contacts.add(new Contact(8,"Juan Solis 8","Benemerito"));
        contacts.add(new Contact(9,"Juan Solis 9","Benemerito"));
        contacts.add(new Contact(10,"Juan Solis 10","Benemerito"));
        contacts.add(new Contact(11,"Juan Solis 11","Benemerito"));
        contacts.add(new Contact(12,"Juan Solis 12","Benemerito"));
        return contacts;
    }
}


 */


//ULTIMO
/*
//activity
package com.cybertech.listasdiplomado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private ListView contactsListView=null;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    contactsListView=(ListView) findViewById(R.id.contactsListView);
    ContactAdapter contactsAdapter = new ContactAdapter(
        getBaseContext(),
        getContacts());
    contactsListView.setAdapter(contactsAdapter);

    contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getBaseContext(),
            ((ContactAdapter)parent.getAdapter()).getContactSelected(position).getName(),
            Toast.LENGTH_LONG).show();
      }
    });
  }

  public List<Contact> getContacts(){
    List<Contact> contacts = new ArrayList<>();
    contacts.add(new Contact(1,"Juan Solis 1","Benemerito"));
    contacts.add(new Contact(2,"Juan Solis 2","Benemerito"));
    contacts.add(new Contact(3,"Juan Solis 3","Benemerito"));
    contacts.add(new Contact(4,"Juan Solis 4","Benemerito"));
    contacts.add(new Contact(5,"Juan Solis 5","Benemerito"));
    contacts.add(new Contact(6,"Juan Solis 6","Benemerito"));
    contacts.add(new Contact(7,"Juan Solis 7","Benemerito"));
    contacts.add(new Contact(8,"Juan Solis 8","Benemerito"));
    contacts.add(new Contact(9,"Juan Solis 9","Benemerito"));
    contacts.add(new Contact(10,"Juan Solis 10","Benemerito"));
    contacts.add(new Contact(11,"Juan Solis 11","Benemerito"));
    contacts.add(new Contact(12,"Juan Solis 12","Benemerito"));
    return contacts;
  }
}

//ULTIMO adapter

//adapter

package com.cybertech.listasdiplomado;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private Context context=null;
    private List<Contact> contacts=null;

    public ContactAdapter(@NonNull Context context,
                          @NonNull List<Contact> objects) {
        super(context, R.layout.item_contact, objects);
        this.contacts=objects;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item=convertView;
        ContactViewHolder contactViewHolder;
        if(item==null){
            LayoutInflater inflater=(LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item=inflater.inflate(R.layout.item_contact,null);
            contactViewHolder= new ContactViewHolder();
            contactViewHolder.contactImageView=(ImageView) item
                    .findViewById(R.id.contactImageView);
            contactViewHolder.nameTextView=(TextView) item
                    .findViewById(R.id.nameTextView);
            contactViewHolder.schoolTextView=(TextView) item
                    .findViewById(R.id.schoolTextView);
            item.setTag(contactViewHolder);
        }else{
            contactViewHolder=(ContactViewHolder) item.getTag();
        }

        contactViewHolder.contactImageView.setImageResource(R.mipmap.ic_launcher);
        contactViewHolder.nameTextView.setText(contacts.get(position).getName());
        contactViewHolder.schoolTextView.setText(contacts.get(position).getSchool());
        return item;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    public Contact getContactSelected(int position){
        return contacts.get(position);
    }

    static class ContactViewHolder{
        ImageView contactImageView;
        TextView nameTextView;
        TextView schoolTextView;
    }
}




* */