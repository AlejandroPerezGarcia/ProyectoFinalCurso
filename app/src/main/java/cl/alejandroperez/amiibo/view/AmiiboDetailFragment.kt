package cl.alejandroperez.amiibo.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.alejandroperez.amiibo.R
import cl.alejandroperez.amiibo.viewmodel.AmiiboViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_amiibo_detail.*
import kotlinx.android.synthetic.main.list_amiibo.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

 class AmiiboDetailFragment : Fragment() {

     private var favorito =  false
    private val amiiboViewModel: AmiiboViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val orientation = activity?.resources?.configuration?.orientation
        // Inflate the layout for this fragment
        Log.d("orientation", "${orientation}")
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_amiibo_detail, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AmiiboDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        amiiboViewModel.datoSelecionado.observe(viewLifecycleOwner, Observer {

            textViewName.text = it.name
            textViewGameSerie.text = it.gameSeries
            textViewTail.text = it.tail
            textViewCharacter.text = it.character
            textViewType.text = it.type
            Picasso.get().load(it.image).into(imageViewDetail)
        })
    }

     private fun setFavoriteIcon(menuItem: MenuItem){
         val id = if (favorito) R.drawable.ic_baseline_wither_24;
         else R.drawable.ic_baseline_favorite_whither_24;
         menuItem.icon = context?.let { ContextCompat.getDrawable(it,id) }

     }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         when (item.itemId){
             R.id.favorito -> {
                 favorito = !favorito
                 setFavoriteIcon(item)
             }

         }
         return super.onOptionsItemSelected(item)
     }


}