package cl.alejandroperez.amiibo.view

  import android.util.Log
  import android.view.LayoutInflater
  import android.view.View
  import android.view.ViewGroup
  import androidx.lifecycle.MutableLiveData
  import androidx.recyclerview.widget.RecyclerView
  import cl.alejandroperez.amiibo.R
  import cl.alejandroperez.amiibo.model.api.Amiibo
  import cl.alejandroperez.amiibo.model.api.AmiiboX
  import cl.alejandroperez.amiibo.model.api.db.EntityAmiibo
  import com.squareup.picasso.Picasso
  import kotlinx.android.synthetic.main.list_amiibo.view.*

class AmiiboAdapter(private var amiiboDataset : MutableList<EntityAmiibo>) :
        RecyclerView.Adapter<AmiiboAdapter.PostHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
      val view = LayoutInflater.from(parent.context)
          .inflate(R.layout.list_amiibo,parent,false)
        return PostHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("getItem", "${amiiboDataset.size}")
        return amiiboDataset.size
    }

    val amiiboSelect = MutableLiveData<EntityAmiibo>()

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val post = amiiboDataset[position]

        Log.d("Adapter", "${post.name}")
        holder.tail.text = amiiboDataset.get(position).tail
        holder.name.text = amiiboDataset.get(position).name
       /* holder.tail.text = post.tail
        holder.name.text = post.name*/
         Picasso.get().load(amiiboDataset.get(position).image).into(holder.image.imageViewImage)
        //funcion del click
        holder.itemView.setOnClickListener{
            Log.d("viewholder", "${amiiboDataset.get(position)}")
            amiiboSelect.postValue(amiiboDataset.get(position))
        }

    }

    class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tail  = itemView.textViewTail
        var name  = itemView.textViewName
        var image  = itemView.imageViewImage
    }

    fun updateItems (it: List<EntityAmiibo>){
        amiiboDataset.clear()
        amiiboDataset.addAll(it)
        notifyDataSetChanged()
    }
}