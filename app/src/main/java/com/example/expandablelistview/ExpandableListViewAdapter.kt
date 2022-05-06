package com.example.expandablelistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class ExpandableListViewAdapter internal  constructor(private val context:Context,private val stateList: List<String>,private val citiesList:HashMap<String,List<String>> ):
    BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return  stateList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return this.citiesList[this.stateList[groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return stateList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return this.citiesList[this.stateList[groupPosition]]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return  groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return  childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var convertView = convertView
        val stateTitle =getGroup(groupPosition) as String

        if (convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.state_list,null)
        }

        //for state view list..
        val tvstate = convertView!!.findViewById<TextView>(R.id.tv_state)
        tvstate.setText(stateTitle)
        return convertView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var convertView = convertView
        val citiesTitle = getChild(groupPosition,childPosition) as String

        if (convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.cities_list,null)
        }

        //for cities view list..
        val tvcities = convertView!!.findViewById<TextView>(R.id.tv_cities)
        tvcities.setText(citiesTitle)
        return convertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}