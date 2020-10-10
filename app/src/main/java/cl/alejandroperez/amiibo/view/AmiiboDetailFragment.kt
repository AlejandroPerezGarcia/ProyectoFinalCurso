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
import cl.alejandroperez.amiibo.model.api.db.EntityAmiibo
import cl.alejandroperez.amiibo.viewmodel.AmiiboViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_amiibo_detail.*
import kotlinx.android.synthetic.main.list_amiibo.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

 class AmiiboDetailFragment : Fragment() {

     lateinit var amiibo: EntityAmiibo
     private var favorito = false
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
        //setHasOptionsMenu(true)
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

     fun button() {

         buttonFavorito.setOnClickListener{

             if (amiibo.favorite) {

                 amiibo.favorite = false
                 buttonFavorito.setBackgroundResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24)
                 amiiboViewModel.actualizar(amiibo)
                 Log.d("favoirito2" , "$favorito")

             }else{
                 amiibo.favorite = true
                 buttonFavorito.setBackgroundResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
                 amiiboViewModel.actualizar(amiibo)
                 Log.d("favoirito3" , "$favorito")

             }

         }
     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        amiiboViewModel.datoSelecionado.observe(viewLifecycleOwner, Observer {

            amiibo = it
            textViewName.text = it.name
            textViewGameSerie.text = it.gameSeries
            textViewTail.text = it.tail
            textViewCharacter.text = it.character
            textViewType.text = it.type
            Picasso.get().load(it.image).into(imageViewDetail)

         // textViewFavorito.text = it.favorite.toString()
            Log.d("favoirito0" , "$favorito")
          if (it.favorite){
              favorito = it.favorite
              buttonFavorito.setBackgroundResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24)
              Log.d("favoirito1" , "$favorito")

            }
            button()

          /*  buttonFavorito.setOnClickListener{
                
              if (amiibo.favorite) {

                  amiibo.favorite = false
                  buttonFavorito.setBackgroundResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24)
                  amiiboViewModel.actualizar(amiibo)
                  Log.d("favoirito2" , "$favorito")

              }else{
                  amiibo.favorite = true
                  buttonFavorito.setBackgroundResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
                  amiiboViewModel.actualizar(amiibo)
                  Log.d("favoirito3" , "$favorito")

            }

           }
*/

        })

    }



 }