package com.example.expandablelistview

import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.ExpandableListView.OnGroupClickListener
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var listViewAdapter: ExpandableListViewAdapter
    private lateinit var stateList: List<String>
    private lateinit var citiesList: HashMap<String,List<String>>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Show Data List
        showDataList()

        val eListView = findViewById<ExpandableListView>(R.id.eListView)
        listViewAdapter = ExpandableListViewAdapter(this,stateList, citiesList)
        eListView.setAdapter(listViewAdapter)

        eListView.setOnGroupClickListener(OnGroupClickListener { parent, v, groupPosition, id ->
            true // This way the expander cannot be collapsed
        })

//        eListView.setOnGroupClickListener(OnGroupClickListener { parent, v, groupPosition, id ->
//            parent.isGroupExpanded(
//                groupPosition
//            )
//        })
    }

    private fun showDataList() {
        stateList = ArrayList()
        citiesList=HashMap()

        (stateList as ArrayList<String>).add("Uttar Pradesh")
        (stateList as ArrayList<String>).add("Guajarat")
        (stateList as ArrayList<String>).add("Maharashtra")
        (stateList as ArrayList<String>).add("Madhya Pradesh")
        (stateList as ArrayList<String>).add("Rajasthan")
        (stateList as ArrayList<String>).add("Punjab")


        val stateUP: MutableList<String> = ArrayList()
        stateUP.add("Lucknow")
        stateUP.add("Kanpur")
        stateUP.add("Jhansi")
        stateUP.add("Varanasi")
        stateUP.add("Noida")

        val stateG : MutableList<String> = ArrayList()
        stateG.add("Vadodara")
        stateG.add("Ahemdabad")
        stateG.add("Rajkot")
        stateG.add("Surat")
        stateG.add("Anand")

        val stateMH: MutableList<String> = ArrayList()
        stateMH.add("Pune")
        stateMH.add("Mumbai")
        stateMH.add("Nasik")
        stateMH.add("Nagpur")
        stateMH.add("Thane")

        val stateMP: MutableList<String> = ArrayList()
        stateMP.add("Indore")
        stateMP.add("Bhopal")
        stateMP.add("Jabalpur")
        stateMP.add("Gwalior")
        stateMP.add("Ujjain")

        val stateRJ: MutableList<String> = ArrayList()
        stateRJ.add("Udaipur")
        stateRJ.add("Kota")
        stateRJ.add("Ajmer")
        stateRJ.add("Alwar")
        stateRJ.add("Bikaner")

        val statePB: MutableList<String> = ArrayList()
        statePB.add("Ludhiana")
        statePB.add("Patiala")
        statePB.add("Bathinda")
        statePB.add("Phagwara")
        statePB.add("Jalandhar")

        citiesList[stateList[0]] =stateUP
        citiesList[stateList[1]] =stateG
        citiesList[stateList[2]] =stateMH
        citiesList[stateList[3]] =stateMP
        citiesList[stateList[4]] =statePB


    }

}