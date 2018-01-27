package org.netzd.listasdiplomado;

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

/**
 * Created by Alumno12 on 27/01/18.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {

    private List<Contact> contacts = null;
    private Context context = null;

    public ContactAdapter(@NonNull Context context, @NonNull List<Contact> objects) {
        super(context, R.layout.contacto, objects);
        this.contacts = objects;
        this.context = context;
    }


    //Sobreescribir metodo view
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView; //Recibir vista por default de la vista
        ContactViewHolder contactViewHolder;
        if(item == null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//Permite introducir nuestro elemento a la vista que se genero
            item = inflater.inflate(R.layout.contacto, null); //Reemplazar la lista que tienes por la que estas creando
            contactViewHolder = new ContactViewHolder();
            contactViewHolder.nameTextView =(TextView) item.findViewById(R.id.nameTextView);
            contactViewHolder.schoolTextView =(TextView) item.findViewById(R.id.schoolTextView); //Instanciamos
            contactViewHolder.contacImageView =(ImageView) item.findViewById(R.id.contactImageView);
            item.setTag(contactViewHolder);
        }else{
            contactViewHolder = (ContactViewHolder) item.getTag();
        }

        contactViewHolder.contacImageView.setImageResource(R.mipmap.ic_launcher);
        contactViewHolder.nameTextView.setText(contacts.get(position).getName());
        contactViewHolder.schoolTextView.setText(contacts.get(position).getSchool());
        return item;
        //return super.getView(position, convertView, parent);
    }


    //Regresar numero de elementos de la lista
    @Override
    public int getCount() {
        return  contacts.size();
    }



    //Guardar una referencia unica de la clase para que no se nos pierda la referencia de los elementos
    static class ContactViewHolder{
        ImageView contacImageView;
        TextView nameTextView;
        TextView schoolTextView;
    }
}
