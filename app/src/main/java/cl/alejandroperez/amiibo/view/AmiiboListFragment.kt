package cl.alejandroperez.amiibo.view


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.alejandroperez.amiibo.R
import cl.alejandroperez.amiibo.model.api.Amiibo
import cl.alejandroperez.amiibo.model.api.db.EntityAmiibo
import cl.alejandroperez.amiibo.viewmodel.AmiiboViewModel
import kotlinx.android.synthetic.main.fragment_amiibo_list.*


class AmiiboListFragment : Fragment() {

    private var amiiboList = ArrayList<EntityAmiibo>()
    private lateinit var adapter: AmiiboAdapter
    private lateinit var AmiiboViewModel : AmiiboViewModel


      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amiibo_list, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = AmiiboListFragment()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AmiiboAdapter(amiiboList)
        amiiboRecyclerView.adapter = adapter
        val amiiboViewModel : AmiiboViewModel by activityViewModels()

        amiiboViewModel.listAmiibo.observe(viewLifecycleOwner,Observer {
            Log.d("fragment" , "$it")
            adapter.updateItems(it)

        })
        adapter.amiiboSelect.observe(viewLifecycleOwner,Observer{
            Log.d("lifeCyclearOwner", " Amiibo selecionado $it")
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragments,AmiiboDetailFragment.newInstance("",""), "detail")
                .addToBackStack("detail")
                .commit()

        })
    }

}